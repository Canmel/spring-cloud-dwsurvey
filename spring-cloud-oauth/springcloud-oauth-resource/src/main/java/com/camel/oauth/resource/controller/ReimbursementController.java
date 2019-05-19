package com.camel.oauth.resource.controller;


import com.baomidou.mybatisplus.service.IService;
import com.camel.core.BaseCommonController;
import com.camel.core.entity.Result;
import com.camel.core.utils.ResultUtil;
import com.camel.oauth.resource.enums.ReimbursementStatus;
import com.camel.oauth.resource.model.Reimbursement;
import com.camel.oauth.resource.service.ReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 <p>
 前端控制器
 </p>
 @author ${author}
 @since 2019-05-17 */
@RestController
@RequestMapping("/reimbursement")
public class ReimbursementController extends BaseCommonController {
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

