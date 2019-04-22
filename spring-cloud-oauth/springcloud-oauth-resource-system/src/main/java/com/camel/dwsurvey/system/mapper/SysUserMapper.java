package com.camel.dwsurvey.system.mapper;

import com.camel.dwsurvey.system.model.SysUser;
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
 * @since 2019-04-22
 */
@Repository
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    List<SysUser> list(SysUser sysUser);
}
