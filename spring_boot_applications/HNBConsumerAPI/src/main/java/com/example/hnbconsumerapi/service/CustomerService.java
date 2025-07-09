package com.example.hnbconsumerapi.service;

import com.example.hnbconsumerapi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
   private RestTemplate restTemplate;

    public CustomerAccountInfo getCustomerDetailsById(String customerId) {
        CustomerAccountInfo customerInfo = new CustomerAccountInfo();
        customerInfo.setCustomerRelationshipAccount(restTemplate.getForObject("http://localhost:8081/customer-relationship-accounts/getCustomer/{customerId}", CustomerRelationshipAccount.class, customerId));
        return customerInfo;

    }

    public String getAccountIdByCustomerId(String customerId){

        CustomerRelationshipAccount custAccount =  restTemplate.getForObject("http://localhost:8081/customer-relationship-accounts/getCustomer/{customerId}", CustomerRelationshipAccount.class, customerId);
        return custAccount.getAccountId();

    }

    public CustomerLatestTransaction getCustomerLatestTransaction(String customerId){

        String accountId = getAccountIdByCustomerId(customerId);
        CustomerLatestTransaction customerDetails = new CustomerLatestTransaction();

        AccountDetails accDetails = new AccountDetails();
        accDetails.setAccountId(accountId);
        accDetails.setBalance(restTemplate.getForObject("http://localhost:8083/pending-transactions/balance/{accountId}", String.class, accountId));
        AccountDepositAchTransactions latestTransactionRecord = restTemplate.getForObject("http://localhost:8082/ach-deposits/latest-account-transaction/{accountId}", AccountDepositAchTransactions.class, accountId);
        accDetails.setLatestTransaction(latestTransactionRecord);

        customerDetails.setAccounts(accDetails);
        customerDetails.setCustomerDetails(restTemplate.getForObject("http://localhost:8081/customer-relationship-accounts/getCustomer/{customerId}", CustomerRelationshipAccount.class, customerId));

        return customerDetails;
    }

    public CustomerRelationshipAccount getCustomerDetailsByAccountId(String accountId) {
        return restTemplate.getForObject("http://localhost:8081/customer-relationship-accounts/getCustomerFromAccountId/{accountId}", CustomerRelationshipAccount.class, accountId);
    }
}
