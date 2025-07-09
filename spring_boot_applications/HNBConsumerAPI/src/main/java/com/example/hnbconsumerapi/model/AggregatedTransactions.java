package com.example.hnbconsumerapi.model;

import java.util.List;

public class AggregatedTransactions {

    private List<PendingTransactions> mpTransactions;
    private List<AccountDepositAchTransactions> achTransactions;
    private String accountId;
    private String startDate;
    private String endDate;

    public AggregatedTransactions(String accountId, String startDate, String endDate) {
        this.accountId = accountId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }

    public List<PendingTransactions> getMpTransactions() {
        return mpTransactions;
    }

    public void setMpTransactions(List<PendingTransactions> mpTransactions) {
        this.mpTransactions = mpTransactions;
    }

    public List<AccountDepositAchTransactions> getAchTransactions() {
        return achTransactions;
    }

    public void setAchTransactions(List<AccountDepositAchTransactions> achTransactions) {
        this.achTransactions = achTransactions;
    }
}
