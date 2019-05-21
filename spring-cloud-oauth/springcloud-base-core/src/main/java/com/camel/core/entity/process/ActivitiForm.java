package com.camel.core.entity.process;

public class ActivitiForm {
    private String comment;

    private String businessId;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public ActivitiForm(String comment, String businessId) {
        this.comment = comment;
        this.businessId = businessId;
    }

    public ActivitiForm() {

    }
}
