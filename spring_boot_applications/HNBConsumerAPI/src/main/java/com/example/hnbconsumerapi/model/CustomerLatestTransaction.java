package com.example.hnbconsumerapi.model;

import java.util.List;

public class CustomerLatestTransaction {

    private CustomerRelationshipAccount customerDetails;
    private AccountDetails accounts;

    public CustomerRelationshipAccount getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerRelationshipAccount customerDetails) {
        this.customerDetails = customerDetails;
    }

    public AccountDetails getAccounts() {
        return accounts;
    }

    public void setAccounts(AccountDetails accounts) {
        this.accounts = accounts;
    }


}
