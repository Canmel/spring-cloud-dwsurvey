package com.camel.dwsurvey.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.camel.dwsurvey.system.model.SysLog;
import com.github.pagehelper.PageInfo;

/**
 <p>
 服务类
 </p>
 @author ${author}
 @since 2019-05-09 */
public interface SysLogService extends IService<SysLog> {
    PageInfo<SysLog> pageQuery(SysLog entity);
}
