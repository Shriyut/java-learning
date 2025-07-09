package com.example.hnbconsumerapi.model;

public class AccountDetails {

    private String accountId;
    private AccountDepositAchTransactions latestTransaction;
    private String balance;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public AccountDepositAchTransactions getLatestTransaction() {
        return latestTransaction;
    }

    public void setLatestTransaction(AccountDepositAchTransactions latestTransaction) {
        this.latestTransaction = latestTransaction;
    }


}
