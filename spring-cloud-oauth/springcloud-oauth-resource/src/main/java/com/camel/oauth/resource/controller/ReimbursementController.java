package com.camel.oauth.resource.controller;


import com.baomidou.mybatisplus.service.IService;
import com.camel.core.BaseCommonController;
import com.camel.core.entity.Result;
import com.camel.core.utils.ResultUtil;
import com.camel.oauth.resource.model.Reimbursement;
import com.camel.oauth.resource.service.ReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Override
    public IService getiService() {
        return service;
    }

    @Override
    public String getMouduleName() {
        return "报销";
    }
}

