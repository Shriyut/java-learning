package com.example.hnbconsumerapi.service;


import com.example.hnbconsumerapi.model.AccountDepositAchTransactions;
import com.example.hnbconsumerapi.model.AccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountDepositAchTransactionService {

    @Autowired
    private RestTemplate restTemplate;

    public List<AccountDepositAchTransactions> getAccountDepositAchTransactionsByAccountId(String accountId){

        return restTemplate.exchange(
                "http://localhost:8082/ach-deposits/accounts/" + accountId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AccountDepositAchTransactions>>() {
                }).getBody();

    }

    public List<AccountDepositAchTransactions> getLatestAchDepositAchTransactionsByAccountId(String accountId){

        List<AccountDepositAchTransactions> latestTransaction = restTemplate.exchange(
                "http://localhost:8082/ach-deposits/latest-account-transaction/" + accountId + "/latest",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AccountDepositAchTransactions>>() {
                }).getBody();
        
        return null;

    }

    public List<AccountDepositAchTransactions> getAchDepositAchTransactionsByDate(String accountId, String startDate, String endDate){

        return restTemplate.exchange(
                "http://localhost:8082/ach-deposits/transactions-by-date/" + accountId + "/" + startDate + "/" + endDate,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AccountDepositAchTransactions>>() {
                }).getBody();

    }

    public List<AccountInfo> getAccountInfoByCustomerId(String customerId) {

        AccountInfo accountInfo = new AccountInfo();
        String accountId = restTemplate.getForObject("http://localhost:8081/customer-relationship-accounts/getCustomerAccount/" + customerId, String.class);
        accountInfo.setAccountId(accountId);
        accountInfo.setBalance(restTemplate.getForObject("http://localhost:8083/pending-transactions/balance/{accountId}", String.class, accountId));
        AccountDepositAchTransactions latestTransactionRecord = restTemplate.getForObject("http://localhost:8082/ach-deposits/latest-account-transaction/{accountId}", AccountDepositAchTransactions.class, accountId);
        accountInfo.setLatestTransaction(latestTransactionRecord);
        List<AccountInfo> accountInfoList = new ArrayList<>();
        accountInfoList.add(accountInfo);
        return accountInfoList;
    }

    public List<AccountDepositAchTransactions> getPast2DaysAchTransactionsByAccountId(String accountId) {

        return restTemplate.exchange(
                "http://localhost:8082/ach-deposits/past-2-days-transactions/" + accountId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AccountDepositAchTransactions>>() {
                }).getBody();

    }
}
