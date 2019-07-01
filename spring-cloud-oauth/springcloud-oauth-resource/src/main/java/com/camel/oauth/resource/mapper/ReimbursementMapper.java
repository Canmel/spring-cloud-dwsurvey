package com.camel.oauth.resource.mapper;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.camel.oauth.resource.model.Reimbursement;
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
 * @since 2019-05-17
 */
@Mapper
@Repository
public interface ReimbursementMapper extends BaseMapper<Reimbursement> {

    /**
     * 查询报销列表
     * @param entity
     * @return
     */
    List<Reimbursement> list(Reimbursement entity);
}
