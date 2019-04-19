package com.canmel.dwsurvey.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.canmel.dwsurvey.system.model.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

}
