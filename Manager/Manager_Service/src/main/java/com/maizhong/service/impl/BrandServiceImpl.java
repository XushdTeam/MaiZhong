package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.mapper.TbCarBrandMapper;
import com.maizhong.pojo.TbCarBrand;
import com.maizhong.pojo.TbCarBrandExample;
import com.maizhong.pojo.TbRole;
import com.maizhong.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:汽车品牌接口实现
 * User: 王存浩
 * Date: 2017-03-06
 * Time: 11:13
 */

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    TbCarBrandMapper tbCarBrandMapper;

    /**
     * 根据Id获取品牌对象
     * @param id
     * @return
     */

    @Override
    public TbCarBrand getCarBrandByid(Long id) {
        TbCarBrandExample tbCarBrandExample = new TbCarBrandExample();
        TbCarBrandExample.Criteria criteria = tbCarBrandExample.createCriteria();
        criteria.andIdEqualTo(id).andDelflagEqualTo(0);
        List<TbCarBrand> carBrand = tbCarBrandMapper.selectByExample(tbCarBrandExample);
        if (carBrand == null || carBrand.size() == 0) return null;
        return carBrand.get(0);
    }

    /**
     * 根据参数查询品牌列表
     * @param param
     * @return
     */
    @Override
    public PageResult getCarBrandList(PageSearchParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        TbCarBrandExample example = new TbCarBrandExample();
        TbCarBrandExample.Criteria criteria = example.createCriteria();
        if (param.getFiled("brandName") != null) {
            criteria.andBrandNameLike(SqlUtils.getLikeSql(param.getFiled("brandName")));
        }
         //查询出未删除的
        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("brand_sequence ASC,id ASC");
        List<TbCarBrand> list = tbCarBrandMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo(list);

        return new PageResult(pageInfo);
    }

    /**
     * 查询出所有状态为1 未删除的品牌信息
     * @return
     */

    @Override
    public String getCarBrandListAll() {

        TbCarBrandExample example = new TbCarBrandExample();
        TbCarBrandExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        criteria.andStatusEqualTo(1);
        example.setOrderByClause("brand_sequence ASC,id ASC");
        List<TbCarBrand> list = tbCarBrandMapper.selectByExample(example);
        return  JsonUtils.objectToJson(list);
    }

    /**
     * 添加品牌信息含LOGO
     * @param tbCarBrand
     * @return
     */

    @Override
    public OperateEnum insertCarBrand(TbCarBrand tbCarBrand) {
        TbCarBrandExample tbCarBrandExample = new TbCarBrandExample();
        TbCarBrandExample.Criteria criteria = tbCarBrandExample.createCriteria();
        criteria.andBrandNameEqualTo(tbCarBrand.getBrandName());
        List<TbCarBrand> carBrand = tbCarBrandMapper.selectByExample(tbCarBrandExample);
        if (carBrand.size() > 0){
            return OperateEnum.NAME_REPEAT;
        }
            int res = tbCarBrandMapper.insertSelective(tbCarBrand);
            if (res > 0) {
                return OperateEnum.SUCCESS;
            } else {
                return OperateEnum.FAILE;
            }
        }

    /**
     * 更新品牌信息
     * @param tbCarBrand
     * @return
     */
    @Override
    public OperateEnum updateCarBrand(TbCarBrand tbCarBrand) {
        int res = tbCarBrandMapper.updateByPrimaryKeySelective(tbCarBrand);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    /**
     * 根据id删除品牌信息 delflag设置为1
     * @param id
     * @return
     */
    @Override
    public OperateEnum deleteCarBrandById(long id) {
        TbCarBrand carBrand = new TbCarBrand();
        carBrand.setId(id);
        carBrand.setDelflag(1);
        int ret = tbCarBrandMapper.updateByPrimaryKeySelective(carBrand);
        if (ret > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    /**
     * 修改品牌Logo
     * @param carBrandAdvertImgUrl
     * @param id
     * @return
     */

    @Override
    public int updateBrandAdvert(String carBrandAdvertImgUrl, long id) {
        //更新品牌logo
        TbCarBrand carBrand = new TbCarBrand();
        carBrand.setId(id);
        carBrand.setBrandImg(carBrandAdvertImgUrl);
        int res = tbCarBrandMapper.updateByPrimaryKeySelective(carBrand);
        return res;
    }
}
