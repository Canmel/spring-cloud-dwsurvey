package com.camel.dwsurvey.system.mapper;

import com.camel.dwsurvey.system.model.SysMacro;
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
 * @since 2019-05-15
 */
@Mapper
@Repository
public interface SysMacroMapper extends BaseMapper<SysMacro> {
    /**
     * 查询字典列表
     * @param sysMacro
     * @return
     */
    List<SysMacro> list(SysMacro sysMacro);
}
