package com.camel.oauth.server.service;

import com.camel.redis.entity.SysRole;
import com.baomidou.mybatisplus.service.IService;
import com.camel.redis.entity.SysUser;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author  * 
 *   ┏ ┓   ┏ ┓
 *  ┏┛ ┻━━━┛ ┻┓
 *  ┃         ┃
 *  ┃    ━    ┃
 *  ┃  ┳┛  ┗┳ ┃
 *  ┃         ┃
 *  ┃    ┻    ┃
 *  ┃         ┃
 *  ┗━━┓    ┏━┛
 *     ┃    ┃神兽保佑
 *     ┃    ┃代码无BUG！
 *     ┃    ┗━━━━━━━┓
 *     ┃            ┣┓
 *     ┃            ┏┛
 *     ┗┓┓┏━━━━━━┳┓┏┛
 *      ┃┫┫      ┃┫┫
 *      ┗┻┛      ┗┻┛
 * @since 2019-04-19
 */
public interface SysRoleService extends IService<SysRole> {
    List<SysRole> selectRoleByUser(SysUser sysUser);
}
