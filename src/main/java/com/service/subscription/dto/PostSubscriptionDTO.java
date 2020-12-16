package com.service.subscription.dto;

import java.util.Date;

public class PostSubscriptionDTO {

    private Double amount;

    private String subType;

    private Date subDate;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public Date getSubDate() {
        return subDate;
    }

    public void setSubDate(Date subDate) {
        this.subDate = subDate;
    }

}
