package com.maizhong.service.impl;

import com.maizhong.common.dto.MenuNode;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.target.ServiceLog;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.TbMenuMapper;
import com.maizhong.pojo.TbMenu;
import com.maizhong.pojo.TbMenuExample;
import com.maizhong.service.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单服务接口实现
 * Created by Xushd on 2017/3/1.
 */
@Service
public class MenuServiceImpl implements MenuService {

    public static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);


    @Autowired
    private TbMenuMapper tbMenuMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${MANAGER_MENU_KEY}")
    private String MANAGER_MENU_KEY;



    @ServiceLog(module = "菜单管理",methods = "菜单列表")
    @Override
    public List<TbMenu> getMenuList(Boolean isParent) {

        List<TbMenu> systemMenuList = tbMenuMapper.selectParentMenuList();
        if (isParent){
            return systemMenuList;
        }else {
            List<TbMenu> result = new ArrayList<>();
            for (TbMenu systemMenu : systemMenuList) {
                result.add(systemMenu);
                TbMenuExample example = new TbMenuExample();
                TbMenuExample.Criteria criteria = example.createCriteria();
                criteria.andDelflagEqualTo(0).andParentEqualTo(systemMenu.getId());
                example.setOrderByClause("sort");
                result.addAll(tbMenuMapper.selectByExample(example));
            }
            return result;
        }
    }


    @Override
    public TbMenu getMenuById(Long id) {
        return tbMenuMapper.selectByPrimaryKey(id);
    }

    @ServiceLog(module = "菜单管理",methods = "菜单新增")
    @Override
    public OperateEnum insertMenu(TbMenu menu) {
        int res = tbMenuMapper.insertSelective(menu);
        if(res>0){
            return OperateEnum.SUCCESS;
        }else {
            return OperateEnum.FAILE;
        }
    }

    @ServiceLog(module = "菜单管理",methods = "菜单修改")
    @Override
    public OperateEnum updateMenu(TbMenu menu) {

        int res = tbMenuMapper.updateByPrimaryKeySelective(menu);
        if(res>0){
            return OperateEnum.SUCCESS;
        }else {
            return OperateEnum.FAILE;
        }
    }

    @ServiceLog(module = "菜单管理",methods = "菜单删除")
    @Override
    public OperateEnum deleteMenu(long id) {
        //逻辑删除
        TbMenu menu = new TbMenu();
        menu.setDelflag(1);
        menu.setStatus(null);
        menu.setId(id);
        int res = tbMenuMapper.updateByPrimaryKeySelective(menu);
        if(res>0){
            return OperateEnum.SUCCESS;
        }else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public OperateEnum menuRedisClear() {
        try {
            long res = jedisClient.del(MANAGER_MENU_KEY);
            if(res>=0){
                return OperateEnum.SUCCESS;
            }else{
                return OperateEnum.FAILE;
            }

        }catch (Exception e) {
            e.printStackTrace();
            return OperateEnum.FAILE;
        }
    }


    @ServiceLog(module = "菜单管理", methods = "前台菜单获取")
    @Override
    public JsonResult getMenuListForWeb(String typeId) {
        //命中缓存
        try {
            String jsonResult = jedisClient.hget(MANAGER_MENU_KEY, typeId);
            if (!StringUtils.isBlank(jsonResult)) {
                LOGGER.info("命中缓存 MANAGER_MENU_KEY:{}", jsonResult);
                return JsonResult.OK(JsonUtils.jsonToList(jsonResult,MenuNode.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<MenuNode> results = getByParentId(Long.parseLong(typeId), false);
        //向缓存中添加
        try {
            String jsonResult = JsonUtils.objectToJson(results);
            jedisClient.hset(MANAGER_MENU_KEY, typeId, jsonResult);
            LOGGER.info("添加缓存 MANAGER_MENU_KEY:{}", jsonResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.OK(results);
    }

    /**
     * 递归获取菜单信息
     *
     * @param parentId menuType or parent
     * @param isParent true parent false menuType
     * @return
     */
    private List<MenuNode> getByParentId(long parentId, boolean isParent) {
        List<MenuNode> results = new ArrayList<>();
        TbMenuExample example = new TbMenuExample();
        TbMenuExample.Criteria criteria = example.createCriteria();
        if (isParent) {
            criteria.andParentEqualTo(parentId);
        } else {
            criteria.andMenuTypeEqualTo(String.valueOf(parentId)).andParentEqualTo(0L);
        }
        criteria.andDelflagEqualTo(0).andStatusEqualTo(1);
        example.setOrderByClause("sort");
        List<TbMenu> menuList = tbMenuMapper.selectByExample(example);
        for (TbMenu menu : menuList) {
            if (isParent) {
                MenuNode node = new MenuNode(menu.getMenuName(), menu.getMenuIco(), menu.getMenuUrl());
                results.add(node);
            } else {
                if (menu.getSort() == 0) {
                    MenuNode node = new MenuNode(menu.getMenuName(), menu.getMenuIco(), true, getByParentId(menu.getId(), true));
                    results.add(node);
                } else {
                    MenuNode node = new MenuNode(menu.getMenuName(), menu.getMenuIco(), false, getByParentId(menu.getId(), true));
                    results.add(node);
                }

            }

        }
        return results;
    }
}
