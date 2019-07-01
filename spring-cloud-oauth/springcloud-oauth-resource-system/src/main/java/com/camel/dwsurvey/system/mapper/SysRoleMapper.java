package com.camel.dwsurvey.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.camel.dwsurvey.system.model.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2019-04-19
 */
@Mapper
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 查询角色列表
     * @param sysRole
     * @return
     */
    List<SysRole> list(SysRole sysRole);
}
