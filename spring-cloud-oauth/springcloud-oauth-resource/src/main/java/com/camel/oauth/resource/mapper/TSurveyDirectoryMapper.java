package com.camel.oauth.resource.mapper;

import com.camel.oauth.resource.model.TSurveyDirectory;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2019-04-17
 */

@Mapper
@Repository
public interface TSurveyDirectoryMapper extends BaseMapper<TSurveyDirectory> {
    List<TSurveyDirectory> list(TSurveyDirectory tSurveyDirectory);
}
