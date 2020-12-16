package com.service.subscription.dto;

import java.util.List;

public class ResponseSubscriptionDTO {
    private Double amount;

    private String subType;

    private List<String> invoiceDates;

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

    public List<String> getInvoiceDates() {
        return invoiceDates;
    }

    public void setInvoiceDates(List<String> invoiceDates) {
        this.invoiceDates = invoiceDates;
    }
}
