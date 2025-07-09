package com.example.hnbconsumerapi.model;

import lombok.Data;

import java.util.List;

@Data
public class CustomerAccountInfo {

    private CustomerRelationshipAccount customerRelationshipAccount;
    private List<PendingTransactions> pendingTransactions;
    private List<AccountDepositAchTransactions> accountDepositAchTransactions;

    public CustomerRelationshipAccount getCustomerRelationshipAccount() {
        return customerRelationshipAccount;
    }

    public void setCustomerRelationshipAccount(CustomerRelationshipAccount customerRelationshipAccount) {
        this.customerRelationshipAccount = customerRelationshipAccount;
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
}
