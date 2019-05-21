package com.camel.core.entity.process;

import lombok.Data;

import java.util.List;

/**
 @author baily
 */
@Data
public class UserTask {
    /**
     id
     */
    private String id;
    /**
     名称
     */
    private String name;
    /**
     备注
     */
    private String description;
    /**
     是否结束
     */
    private boolean isEnd;
    /**
     评论与回复
     */
    private List<Comment> comment;
}
