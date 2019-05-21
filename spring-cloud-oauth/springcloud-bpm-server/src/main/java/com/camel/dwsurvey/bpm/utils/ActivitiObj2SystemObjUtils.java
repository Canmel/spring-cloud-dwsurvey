package com.camel.dwsurvey.bpm.utils;

import com.camel.core.entity.process.Comment;

import java.util.ArrayList;
import java.util.List;

public class ActivitiObj2SystemObjUtils {
    private final static ActivitiObj2SystemObjUtils INSTANCE = new ActivitiObj2SystemObjUtils();

    public ActivitiObj2SystemObjUtils() {
    }

    public static ActivitiObj2SystemObjUtils getInstance(){return INSTANCE;}

    public List<Comment> commentsToObj(List<org.activiti.engine.task.Comment> comments) {
        List<Comment> result = new ArrayList<>();
        comments.forEach(comment -> {
            Comment c1 = new Comment(comment.getUserId(), comment.getTime(), comment.getTaskId(), comment.getFullMessage());
            result.add(c1);
        });
        return result;
    }
}
