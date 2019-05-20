package com.camel.dwsurvey.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.camel.dwsurvey.system.model.SysMenu;
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
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 查询菜单列表
     * @param sysMenu
     * @return
     */
    List<SysMenu> list(SysMenu sysMenu);
}
