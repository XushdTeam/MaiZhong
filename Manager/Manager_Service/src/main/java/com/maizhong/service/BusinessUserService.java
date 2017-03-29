package com.maizhong.service;


import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.TbBusinessUser;

/**
 * Description:店铺管理员管理服务接口
 * User: 王存浩
 * Date: 2017-03-06
 * Time: 10:57
 */
public interface BusinessUserService {


    /**
     * 通过类别id 获取4s店管理员对象
     * @param id
     * @return
     */
    TbBusinessUser getBusinessUserByid(Long id);

    /**
     * 类别列表-分页
     * @param param
     * @return
     */
    PageResult getBusinessUserList(PageSearchParam param);


    /**
     * 所有店铺列表
     * @return
     */

    public String getBusinessUserListAll();



    /**
     * 新增店铺
     * @param
     * @return
     */
    OperateEnum insertBusinessUser(TbBusinessUser tbBusinessUser);

    /**
     * 店铺管理员信息修改
     * @param tbBusinessUser
     * @return
     */
    OperateEnum updateBusinessUser(TbBusinessUser tbBusinessUser);


    /**
     * 删除店铺管理员信息
     * @param id
     * @return
     */
    OperateEnum deleteBusinessUserById(long id);



}
