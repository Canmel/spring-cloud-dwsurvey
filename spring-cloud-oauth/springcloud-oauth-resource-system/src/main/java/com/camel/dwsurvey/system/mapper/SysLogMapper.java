package com.camel.dwsurvey.system.mapper;

import com.camel.dwsurvey.system.model.SysLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2019-05-09
 */
@Mapper
@Repository
public interface SysLogMapper extends BaseMapper<SysLog> {

}
