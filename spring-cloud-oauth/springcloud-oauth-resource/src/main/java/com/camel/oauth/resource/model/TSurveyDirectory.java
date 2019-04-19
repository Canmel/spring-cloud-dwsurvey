package com.camel.oauth.resource.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.camel.core.entity.BasePaginationEntity;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2019-04-17
 */
@Data
@TableName("t_survey_directory")
public class TSurveyDirectory extends BasePaginationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /*主键*/
    private String id;
    private Integer anItemLeastNum;
    /*收集答题数量*/
    private Integer answerNum;
    /*创建时间*/
    private Date createDate;
    /*类型*/
    private Integer dirType;
    /*收集预期数量*/
    private Integer excerptNum;
    /*html页面存放地址*/
    private String htmlPath;
    private Integer isShare;
    /*父问卷*/
    private String parentId;
    /*子问卷*/
    private String sid;
    /*问卷详细记录ID*/
    private String surveyDetailId;
    /*模式*/
    private Integer surveyModel;
    /*名称*/
    private String surveyName;
    /*题目数量*/
    private Integer surveyQuNum;
    /*状态 0 :'设计' 1: '发布' 2: '收集完成' */
    private Integer surveyState;
    /*标签*/
    private Integer surveyTag;
    /*创建人*/
    private String userId;
    private Integer viewAnswer;
    private Integer visibility;

    @TableField(exist = false)
    private TUser tUser;

    @Override
    public String toString() {
        return "TSurveyDirectory{" +
        ", id=" + id +
        ", anItemLeastNum=" + anItemLeastNum +
        ", answerNum=" + answerNum +
        ", createDate=" + createDate +
        ", dirType=" + dirType +
        ", excerptNum=" + excerptNum +
        ", htmlPath=" + htmlPath +
        ", isShare=" + isShare +
        ", parentId=" + parentId +
        ", sid=" + sid +
        ", surveyDetailId=" + surveyDetailId +
        ", surveyModel=" + surveyModel +
        ", surveyName=" + surveyName +
        ", surveyQuNum=" + surveyQuNum +
        ", surveyState=" + surveyState +
        ", surveyTag=" + surveyTag +
        ", userId=" + userId +
        ", viewAnswer=" + viewAnswer +
        ", visibility=" + visibility +
        "}";
    }
}
