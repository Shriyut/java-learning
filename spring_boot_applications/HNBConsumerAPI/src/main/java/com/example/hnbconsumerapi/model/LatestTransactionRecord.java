package com.example.hnbconsumerapi.model;

public class LatestTransactionRecord {

    private CustomerRelationshipAccount customerDetails;
    private AccountInfo accounts;

    public CustomerRelationshipAccount getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerRelationshipAccount customerDetails) {
        this.customerDetails = customerDetails;
    }

    public AccountInfo getAccounts() {
        return accounts;
    }

    public void setAccounts(AccountInfo accounts) {
        this.accounts = accounts;
    }

//    public String getCustomerId() {
//        return customerDetails.getCustomerId();
//    }
}
