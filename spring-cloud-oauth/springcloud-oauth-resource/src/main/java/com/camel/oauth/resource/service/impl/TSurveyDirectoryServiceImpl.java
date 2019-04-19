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
import java.util.Map;

/**
 *　　　　　　　 ┏┓    ┏┓+ +
 *　　　　　　　┏┛┻━━━━┛┻┓ + +
 *　　　　　　　┃        ┃ 　问卷服务实现类
 *　　　　　　　┃     ━  ┃ ++ + + +
 *           ████━████ ┃+
 *　　　　　　　┃        ┃ +
 *　　　　　　　┃   ┻    ┃
 *　　　　　　　┃        ┃ + +
 *　　　　　　　┗━┓   ┏━━┛
 *　　　　　　　  ┃   ┃　　　　　　　　　　
 *　　　　　　　  ┃   ┃ + + + +
 *　　　　　　　  ┃   ┃　　　Code is far away from bug with the animal protecting　　　　　　　
 *　　　　　　　  ┃   ┃+ 　　　　神兽保佑,代码无bug　　
 *　　　　　　　  ┃   ┃
 *　　　　　　　  ┃   ┃　　+　　　　　　　　　
 *　　　　　　　  ┃   ┗━━━━━━━┓ + +
 *　　　　　　　  ┃           ┣┓
 *　　　　　　　  ┃           ┏┛
 *              ┗┓┓┏━━━━━┳┓┏┛ + + + +
 *               ┃┫┫     ┃┫┫
 *               ┗┻┛     ┗┻┛+ + + +
 */
@Service
public class TSurveyDirectoryServiceImpl extends ServiceImpl<TSurveyDirectoryMapper, TSurveyDirectory> implements TSurveyDirectoryService {

    @Autowired
    private TSurveyDirectoryMapper tSurveyDirectoryMapper;

    @Override
    public PageInfo<TSurveyDirectory> pageQuery(TSurveyDirectory entity) {
        PageInfo pageInfo = com.github.pagehelper.PageHelper.startPage(entity.getPageNum(), entity.getPageSize()).doSelectPageInfo(()-> tSurveyDirectoryMapper.list(entity));
        return pageInfo;
    }

    @Override
    public Page<TSurveyDirectory> selectListPage(TSurveyDirectory tSurveyDirectory) {
        // 新建分页
        Page<TSurveyDirectory> page = new Page<TSurveyDirectory>(1, 10);
        // 返回分页结果 1为id
        return page.setRecords(tSurveyDirectoryMapper.list(tSurveyDirectory));
    }
}
