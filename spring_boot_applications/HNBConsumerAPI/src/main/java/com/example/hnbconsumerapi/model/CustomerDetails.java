package com.example.hnbconsumerapi.model;

public class CustomerDetails {

    private String customerId;
    private AccountInfo accounts;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public AccountInfo getAccounts() {
        return accounts;
    }

    public void setAccounts(AccountInfo accounts) {
        this.accounts = accounts;
    }
}
