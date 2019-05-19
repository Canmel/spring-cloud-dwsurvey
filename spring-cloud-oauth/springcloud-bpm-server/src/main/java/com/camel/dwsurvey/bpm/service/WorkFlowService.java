package com.camel.dwsurvey.bpm.service;

import com.baomidou.mybatisplus.service.IService;
import com.camel.dwsurvey.bpm.model.WorkFlow;
import com.github.pagehelper.PageInfo;
import org.activiti.engine.repository.Deployment;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2019-05-16
 */
public interface WorkFlowService extends IService<WorkFlow> {
    PageInfo<WorkFlow> pageQuery(WorkFlow entity);

    PageInfo<Deployment> pageQueryDeployed(WorkFlow entity);

    List<Map<String, Object>> deployed(WorkFlow workFlow);
}
