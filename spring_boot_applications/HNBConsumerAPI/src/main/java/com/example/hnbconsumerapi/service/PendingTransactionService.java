package com.example.hnbconsumerapi.service;

import com.example.hnbconsumerapi.model.AccountDepositAchTransactions;
import com.example.hnbconsumerapi.model.CustomerRelationshipAccount;
import com.example.hnbconsumerapi.model.LatestTransactionRecord;
import com.example.hnbconsumerapi.model.PendingTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class PendingTransactionService {

    @Autowired
    private RestTemplate restTemplate;

    public List<PendingTransactions> getPendingTransactionDetailsByCustomerId(String customerId){

        return restTemplate.exchange(
                "http://localhost:8083/pending-transactions/customer/" + customerId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PendingTransactions>>() {
                }).getBody();

    }

    public List<PendingTransactions> getPendingTransactionsByAccountId(String accountId){

        return restTemplate.exchange(
                "http://localhost:8083/pending-transactions/account/" + accountId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PendingTransactions>>() {
                }).getBody();

    }

    public LatestTransactionRecord getLatestTransactionByCustomerId(String customerId){

        LatestTransactionRecord latestTransaction = new LatestTransactionRecord();
        latestTransaction.setCustomerDetails(restTemplate.getForObject("http://localhost:8081/customer-relationship-accounts/getCustomer/{customerId}", CustomerRelationshipAccount.class, customerId));
        return latestTransaction;

    }

    public List<PendingTransactions> getMemopostTransactionsByDate(String accountId, String startDate, String endDate){

        return restTemplate.exchange(
                "http://localhost:8083/pending-transactions/transactions-by-date/" + accountId + "/" + startDate + "/" + endDate,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PendingTransactions>>() {
                }).getBody();

    }
}
