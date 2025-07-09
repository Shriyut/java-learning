package com.example.hnbconsumerapi.model;

import lombok.Data;

import java.util.List;

@Data
public class TransactionHistory {

    private String accountId;
    private List<PendingTransactions> pendingTransactions;
    private List<AccountDepositAchTransactions> accountDepositAchTransactions;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<PendingTransactions> getPendingTransactions() {
        return pendingTransactions;
    }

    public void setPendingTransactions(List<PendingTransactions> pendingTransactions) {
        this.pendingTransactions = pendingTransactions;
    }

    public List<AccountDepositAchTransactions> getAccountDepositAchTransactions() {
        return accountDepositAchTransactions;
    }

    public void setAccountDepositAchTransactions(List<AccountDepositAchTransactions> accountDepositAchTransactions) {
        this.accountDepositAchTransactions = accountDepositAchTransactions;
    }

    public TransactionHistory(String accountId) {
        this.accountId = accountId;
    }
}
