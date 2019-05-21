package com.camel.oauth.resource.controller;


import com.baomidou.mybatisplus.service.IService;
import com.camel.core.BaseCommonController;
import com.camel.core.entity.Result;
import com.camel.core.entity.process.ActivitiForm;
import com.camel.core.utils.ResultUtil;
import com.camel.oauth.resource.enums.ReimbursementStatus;
import com.camel.oauth.resource.model.Reimbursement;
import com.camel.oauth.resource.service.ReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 <p>
 前端控制器
 </p>
 @author ${author}
 @since 2019-05-17 */
@RestController
@RequestMapping("/reimbursement")
public class ReimbursementController extends BaseCommonController {
    public static final String USER_ID_PROP_NAME = "id";

    @Autowired
    private ReimbursementService service;

    @GetMapping
    public Result index(Reimbursement reimbursement) {
        return ResultUtil.success(service.selectPage(reimbursement));
    }

    @GetMapping("/{id}")
    public Result ditail(@PathVariable Integer id) {
        return super.details(id);
    }

    @PostMapping
    public Result save(@RequestBody Reimbursement reimbursement) {
        return super.save(reimbursement);
    }

    @PutMapping
    public Result update(@RequestBody Reimbursement reimbursement) {
        return super.update(reimbursement);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return super.delete(id);
    }

    @GetMapping("/apply/{id}")
    public Result apply(@PathVariable Integer id, String flowId) {
        return service.apply(id, flowId) ? ResultUtil.success("发起流程成功") : ResultUtil.error(HttpStatus.BAD_REQUEST.value(), "发起流程失败");
    }

    @GetMapping("/current/{id}")
    public Result current(@PathVariable Integer id){
        return service.current(id);
    }

    @GetMapping("/comment/{id}")
    public Result comment(@PathVariable String id){
        Result result = service.comment(id);
        return result;
    }

    @GetMapping("/pass/{id}")
    public Result pass(@PathVariable Integer id, ActivitiForm activitiForm){
        Result result = service.current(id);
        if(!ObjectUtils.isEmpty(result.getData())){
            List<Map<String, Object>> list = (List) result.getData();
            Map<String, Object> userTask = list.get(0);
            if(StringUtils.isEmpty(userTask.get(USER_ID_PROP_NAME))){
                return ResultUtil.success("审批失败");
            }
            return service.pass(userTask.get(USER_ID_PROP_NAME).toString(), activitiForm);
        }
        return ResultUtil.success("审批失败");
    }

    @GetMapping("/back/{id}")
    public Result back(@PathVariable Integer id, ActivitiForm activitiForm) {
        Result result = service.current(id);
        if(!ObjectUtils.isEmpty(result.getData())){
            List<Map<String, Object>> list = (List) result.getData();
            Map<String, Object> userTask = list.get(0);
            if(StringUtils.isEmpty(userTask.get(USER_ID_PROP_NAME))){
                return ResultUtil.success("审批失败");
            }
            return service.back(userTask.get(USER_ID_PROP_NAME).toString(), activitiForm);
        }
        return ResultUtil.success("审批失败");
    }

    @Override
    public IService getiService() {
        return service;
    }

    @Override
    public String getMouduleName() {
        return "报销";
    }

    @GetMapping("/status")
    public Result reimbursementStatus() {
        return ResultUtil.success(ReimbursementStatus.all());
    }
}

