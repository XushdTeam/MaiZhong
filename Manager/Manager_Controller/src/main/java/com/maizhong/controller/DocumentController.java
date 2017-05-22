package com.maizhong.controller;

import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.pojo.Document;
import com.maizhong.service.DocumentService;
import com.maizhong.service.FileUploadService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * Created by Xushd on 2017/5/22.
 */
@Controller
public class DocumentController {


    @Autowired
    private DocumentService documentService;

    @Autowired
    private FileUploadService fileUploadService;

    /**
     * 跳转
     * @return
     */
    @RequestMapping(value = "/document",method = RequestMethod.GET)
    public String document(Model model){

        model.addAttribute("baseUrl","/document");
        model.addAttribute("listUrl","/document/list");
        model.addAttribute("handleUrl","/document/handle");
        model.addAttribute("deleteUrl","/document/delete");
        model.addAttribute("redisUrl","/document/redis");

        return "document/list";
    }

    /**
     * 获取列表数据
     * @return
     */
    @RequestMapping(value="/document/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult documentList(PageSearchParam param){
        PageResult result =  documentService.getDocList(param);
        return JsonResult.OK(result);
    }

    /**
     * 跳转到新增修改
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/document/handle/{id}")
    public String handle(@PathVariable String id, Model model){
        String resultView = "document/document_a_e";
        if(StringUtils.equals("new",id)){
            //新增
            model.addAttribute("handle","文章新增");
            model.addAttribute("saveUrl","/document/save");
        }else {
            //修改
            Document doc  = documentService.getDocById(Long.parseLong(id));
            model.addAttribute("doc",doc);
            model.addAttribute("handle", "文章修改");
            model.addAttribute("saveUrl","/document/update");
        }
        model.addAttribute("baseUrl","/document");
        return resultView;
    }

    /**
     * 文章新增
     * @param doc
     * @param result
     * @return
     */
    @RequestMapping(value = "/document/save",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult documentSave(@Valid Document doc, BindingResult result){
        //验证有错误
        if(result.hasErrors()){
            String error = "";
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError allError : allErrors) {
                error+= allError.getDefaultMessage();
            }
            return JsonResult.Error(error);
        } else{
            doc.setEditTime(new Date());
            JsonResult res = documentService.insertDoc(doc);
            return res;
        }
    }

    /**
     * 文章修改
     * @param doc
     * @param result
     * @return
     */
    @RequestMapping(value = "/document/update",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult documentUpdate(@Valid Document doc,BindingResult result){
        //验证有错误
        if(result.hasErrors()){
            String error = "";
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError allError : allErrors) {
                error+= allError.getDefaultMessage();
            }
            return JsonResult.Error(error);
        }else{
            return documentService.update(doc);
        }
    }

    /**
     * 文章删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/document/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult documentDelete(@PathVariable String id){
        return documentService.deleteById(id);
    }


    @RequestMapping(value = "/document/upload")
    public void uploadImg(@RequestParam(value = "uploadFile") MultipartFile file, HttpServletResponse response) throws IOException {

        JsonResult result = fileUploadService.uploadImg(file, "document/");
        PrintWriter writer = response.getWriter();
        if(result.getStatus()==200){
            writer.write(result.getData().toString());
        }else{
            writer.write("error|"+result.getMessage());
        }

        writer.flush();
    }

}
