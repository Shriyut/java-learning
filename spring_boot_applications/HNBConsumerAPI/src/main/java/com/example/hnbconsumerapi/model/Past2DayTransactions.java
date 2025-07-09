package com.example.hnbconsumerapi.model;

import java.util.List;

public class Past2DayTransactions {

    private List<AccountDepositAchTransactions> accounts;
    private String accountId;
    private CustomerRelationshipAccount customer;

    public Past2DayTransactions(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public List<AccountDepositAchTransactions> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDepositAchTransactions> accounts) {
        this.accounts = accounts;
    }

    public CustomerRelationshipAccount getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerRelationshipAccount customer) {
        this.customer = customer;
    }

}
