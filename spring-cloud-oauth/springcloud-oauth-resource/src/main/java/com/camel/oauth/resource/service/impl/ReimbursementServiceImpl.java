package com.camel.oauth.resource.service.impl;

import com.camel.core.entity.Result;
import com.camel.core.entity.process.ActivitiForm;
import com.camel.core.utils.PaginationUtil;
import com.camel.oauth.resource.feign.SpringCloudBpmFeignClient;
import com.camel.oauth.resource.model.Reimbursement;
import com.camel.oauth.resource.mapper.ReimbursementMapper;
import com.camel.oauth.resource.service.ReimbursementService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import feign.FeignException;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 <p>
 服务实现类
 </p>
 @author ${author}
 @since 2019-05-17 */
@Service
public class ReimbursementServiceImpl extends ServiceImpl<ReimbursementMapper, Reimbursement> implements ReimbursementService {
    public static final String PROCESSDEFINITIONKEY = "REIMBURSEMENT";

    @Autowired
    private ReimbursementMapper mapper;

    @Resource
    private SpringCloudBpmFeignClient springCloudBpmFeignClient;

    @Override
    public Boolean apply(Integer id, String flowId) {
        Result result = springCloudBpmFeignClient.applyById(Reimbursement.class.getSimpleName().toUpperCase() + id, flowId);
        return ObjectUtils.isEmpty(result) ? false : result.isSuccess();
    }

    @Override
    public PageInfo<Reimbursement> selectPage(Reimbursement entity) {
        PageInfo pageInfo = PaginationUtil.startPage(entity, () -> {
            mapper.list(entity);
        });
        return pageInfo;
    }

    @Override
    public Result current(Integer id) {
        Result result = current(id.toString());
        return result;
    }

    @Override
    public Result current(String id) {
        Result result = springCloudBpmFeignClient.current(Reimbursement.class.getSimpleName().toUpperCase() + id, PROCESSDEFINITIONKEY);
        return result;
    }

    @Override
    public Result pass(String taskId, ActivitiForm activitiForm) {
        Result result = springCloudBpmFeignClient.pass(taskId, activitiForm.getComment(), Reimbursement.class.getSimpleName().toUpperCase() + activitiForm.getBusinessId());
        return result;
    }

    @Override
    public Result back(String taskId, ActivitiForm activitiForm) {
        Result result = springCloudBpmFeignClient.back(taskId, activitiForm.getComment(), Reimbursement.class.getSimpleName().toUpperCase() + activitiForm.getBusinessId());
        return result;
    }

    @Override
    public Result comment(String id) {
        Result result = springCloudBpmFeignClient.comment(id);
        return result;
    }

    @Override
    public Result toDO() {
        Result result = springCloudBpmFeignClient.toDo();
        return result;
    }
}
