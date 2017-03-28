package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.pojo.TbBusinessUser;
import com.maizhong.service.BusinessUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Description:店铺用户管理控制器
 * User: 王存浩
 * Date: 2017-03-27
 * Time: 10:56
 */

@Controller
public class BusinessUserController {

    @Autowired
    private BusinessUserService businessUserService;

    //@RequiresPermissions("/businessUser")
    @RequestMapping(value = "/businessUser", method = RequestMethod.GET)
    public String carType(Model model) {

        model.addAttribute("baseUrl", "/businessUser");
        model.addAttribute("listUrl", "/businessUser/list");
        model.addAttribute("handleUrl", "/businessUser/handle");
        model.addAttribute("deleteUrl", "/businessUser/delete");
        return "business/businessUser";
    }

    /**
     * 汽车类别获取 分页 查询
     * @param param
     * @return
     */
    @ControllerLog(module = "4S店管理员", methods = "管理员列表")
    @RequestMapping(value = "/businessUser/list", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult BusinessUserList(PageSearchParam param) {
        PageResult result = businessUserService.getBusinessUserList(param);
        return JsonResult.OK(result);
    }


    /**
     *获取所有4S店管理员 不含删除和停用
     * @return
     */
    @RequestMapping(value = "/getBusinessUserListAll", method = RequestMethod.GET)
    @ResponseBody
    public String typeListAll() {
        return businessUserService.getBusinessUserListAll();
    }

    /**
     * 4s店管理员新增和修改
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/businessUser/handle/{id}/{businessId}")
    public String handle(@PathVariable String id, @PathVariable String businessId,Model model) {

        model.addAttribute("baseUrl", "/businessUser");
        if (StringUtils.equals("new", id)) {
            //新增
            model.addAttribute("handle", "管理员管理/管理员新增");
            model.addAttribute("saveUrl", "/businessUser/save");
            model.addAttribute("businessId", businessId);
            return "business/businessUser_add";
        } else {
            TbBusinessUser businessUser = businessUserService.getBusinessUserByid(Long.valueOf(id));
            model.addAttribute("businessUser", businessUser);
            model.addAttribute("handle", "管理员管理/管理员修改");
            model.addAttribute("saveUrl", "/businessUser/update");
            return "business/businessUser_setting";
        }
    }

    /**
     * 店铺管理员新增
     * @param tbBusinessUser
     * @return
     */
    //@RequiresPermissions("/business/save")
    @ControllerLog(module = "4S店管理员", methods = "管理员新增")
    @RequestMapping(value = "/businessUser/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult businessUserSave(TbBusinessUser tbBusinessUser) {
            OperateEnum res = businessUserService.insertBusinessUser(tbBusinessUser);
            return JsonResult.build(res);
    }

    /**
     * 店铺管理员删除
     * @param id
     * @return
     */
  //  @RequiresPermissions("/business/delete")
    @ControllerLog(module = "4S店管理员", methods = "删除管理员")
    @RequestMapping(value = "/businessUser/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult businessUserDelete(@PathVariable long id) {
        //店铺管理员删除
        OperateEnum result = businessUserService.deleteBusinessUserById(id);
        return JsonResult.build(result);
    }

    /**
     * 店铺管理员信息修改
     * @param tbBusinessUser
     * @return
     */
   // @RequiresPermissions("/business/update")
    @ControllerLog(module = "4S店管理员", methods = "管理员信息修改")
    @RequestMapping(value = "/businessUser/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult businessUserUpdate(TbBusinessUser tbBusinessUser) {
        OperateEnum result = businessUserService.updateBusinessUser(tbBusinessUser);
        return JsonResult.build(result);
    }




    @RequestMapping("/businessUser/findAll")
    @ResponseBody
    public JsonResult findAll(){
        List<TbBusinessUser> list = JsonUtils.jsonToList(businessUserService.getBusinessUserListAll(), TbBusinessUser.class);
        return JsonResult.OK(list);
    }
}



