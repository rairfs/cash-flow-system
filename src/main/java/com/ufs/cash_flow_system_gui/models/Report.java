package com.ufs.cash_flow_system_gui.models;

import java.time.LocalDateTime;
import java.util.Date;

public class Report {
    private LocalDateTime transactionDate;
    private Double transactionAmount;

    public Report() {
    }

    public Report(Double transactionAmount) {
        this.transactionDate = LocalDateTime.now();
        this.transactionAmount = transactionAmount;
    }

    public Report(LocalDateTime transactionDate, Double transactionAmount) {
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
