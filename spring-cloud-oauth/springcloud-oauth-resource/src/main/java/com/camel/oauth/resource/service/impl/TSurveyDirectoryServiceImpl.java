package com.camel.oauth.resource.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.camel.oauth.resource.mapper.TSurveyDirectoryMapper;
import com.camel.oauth.resource.model.TSurveyDirectory;
import com.camel.oauth.resource.service.TSurveyDirectoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        PageInfo pageInfo = PageHelper.startPage(entity.getPageNum(), entity.getPageSize()).doSelectPageInfo(()-> tSurveyDirectoryMapper.list(entity));
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
