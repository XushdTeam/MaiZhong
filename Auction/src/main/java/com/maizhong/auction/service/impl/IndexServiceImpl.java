package com.maizhong.auction.service.impl;

import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.dto.MenuDto;
import com.maizhong.auction.mapper.SysMenuMapper;
import com.maizhong.auction.mapper.SysUserMapper;
import com.maizhong.auction.pojo.SysMenu;
import com.maizhong.auction.pojo.SysMenuExample;
import com.maizhong.auction.pojo.SysUser;
import com.maizhong.auction.pojo.SysUserExample;
import com.maizhong.auction.service.IndexService;
import com.maizhong.common.enums.AuthEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.IDUtils;
import com.maizhong.common.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xushd on 2017/7/3.
 */
@Service
public class IndexServiceImpl implements IndexService {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;


    @Autowired
    private JedisClient jedisClient;


    /**
     * 后台登录验证
     * @param account
     * @param password
     * @param checked
     * @return
     */
    @Override
    public JsonResult loginCheck(String account, String password, boolean checked) {

        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0).andPhoneNumEqualTo(Long.valueOf(account));
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        if(sysUsers.size()==0){
            return JsonResult.build(AuthEnum.USER_NO_EXIT);
        }else{
            SysUser sysUser = sysUsers.get(0);
            if(!StringUtils.equals(password,sysUser.getPassword())){
                return JsonResult.build(AuthEnum.USER_ERROR_PASSWORD);
            }else{
                if(sysUser.getStatus()==0){
                    return JsonResult.build(AuthEnum.USER_STOP);
                }
                String token = IDUtils.getUUID();
                jedisClient.set("WEB_LOGIN:"+token, JsonUtils.objectToJson(sysUser));
                if(!checked){
                    jedisClient.expire("WEB_LOGIN:"+token,60*30);
                }
                return JsonResult.build(200,"登录成功",token);
            }
        }

    }

    /**
     * 验证登录状态
     * @param token
     * @return
     */
    @Override
    public JsonResult checkLoginStatus(String token) {

        String s = jedisClient.get("WEB_LOGIN:" + token);
        if(StringUtils.isBlank(s)){
            return JsonResult.Error("TIME IS OUT");
        }
        return JsonResult.OK(JsonUtils.jsonToPojo(s,SysUser.class).getUsername());
    }

    /**
     * 获取用户的菜单
     * @param token
     * @return
     */
    @Override
    public String getSystemMenu(String token) {

        String userStr = jedisClient.get("WEB_LOGIN:" + token);
        SysUser sysUser = JsonUtils.jsonToPojo(userStr, SysUser.class);


        List<SysMenu> sysMenus = sysMenuMapper.selectMenuByUserId(sysUser.getId());

        SysMenuExample example = new SysMenuExample();
        SysMenuExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(0L).andDelflagEqualTo(0);
        List<SysMenu> parents = sysMenuMapper.selectByExample(example);

        List<MenuDto> list = new ArrayList<>();

        for (SysMenu parent : parents) {
            List<MenuDto> temp = new ArrayList<>();
            for (SysMenu menu : sysMenus) {
                if(menu.getParentId()==parent.getId()){
                    MenuDto dto = new MenuDto();
                    dto.setIcon(menu.getIcon());
                    dto.setName(menu.getName());
                    dto.setUrl(menu.getUrl());
                    temp.add(dto);
                }
            }
            if(temp.size()>0){
                MenuDto dto = new MenuDto();
                dto.setIcon(parent.getIcon());
                dto.setName(parent.getName());
                dto.setUrl(parent.getUrl());
                dto.setSubs(temp);
                list.add(dto );
            }

        }
        return JsonUtils.objectToJson(list);
    }
}
