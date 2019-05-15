package com.camel.dwsurvey.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.camel.dwsurvey.system.model.SysMacro;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2019-05-15
 */
public interface SysMacroService extends IService<SysMacro> {
    PageInfo<SysMacro> selectPage(SysMacro entity);
}
