package com.ufs.cash_flow_system_gui.models;

import java.util.Date;

public class Report {
    private Date transactionDate;
    private Double transactionAmount;

    public Report() {
    }

    public Report(Date transactionDate, Double transactionAmount) {
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
