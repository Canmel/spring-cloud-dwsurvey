package com.camel.oauth.resource.service;

import com.camel.oauth.resource.model.Reimbursement;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2019-05-17
 */
public interface ReimbursementService extends IService<Reimbursement> {
    PageInfo<Reimbursement> selectPage(Reimbursement entity);

    Boolean apply(Integer id);
}
