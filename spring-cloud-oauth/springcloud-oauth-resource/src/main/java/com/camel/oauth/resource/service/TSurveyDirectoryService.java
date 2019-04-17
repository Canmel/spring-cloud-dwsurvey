package com.camel.oauth.resource.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.camel.oauth.resource.model.TSurveyDirectory;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-17
 */
public interface TSurveyDirectoryService extends IService<TSurveyDirectory> {
    PageInfo<TSurveyDirectory> pageQuery(TSurveyDirectory tSurveyDirectory);
}