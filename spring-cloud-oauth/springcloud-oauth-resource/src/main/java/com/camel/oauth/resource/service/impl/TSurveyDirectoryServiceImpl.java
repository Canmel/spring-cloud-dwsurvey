package com.camel.oauth.resource.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.camel.oauth.resource.model.TSurveyDirectory;
import com.camel.oauth.resource.mapper.TSurveyDirectoryMapper;
import com.camel.oauth.resource.service.TSurveyDirectoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-17
 */
@Service
public class TSurveyDirectoryServiceImpl extends ServiceImpl<TSurveyDirectoryMapper, TSurveyDirectory> implements TSurveyDirectoryService {

    @Autowired
    private TSurveyDirectoryMapper tSurveyDirectoryMapper;

    @Override
    public PageInfo<TSurveyDirectory> pageQuery(TSurveyDirectory tSurveyDirectory) {
        PageInfo pageInfo = com.github.pagehelper.PageHelper.startPage(1, 10).doSelectPageInfo(()-> tSurveyDirectoryMapper.list(tSurveyDirectory));
        return pageInfo;
    }
}
