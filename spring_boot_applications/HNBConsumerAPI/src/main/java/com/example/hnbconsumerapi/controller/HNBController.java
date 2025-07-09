package com.example.hnbconsumerapi.controller;

import com.example.hnbconsumerapi.model.*;
import com.example.hnbconsumerapi.service.AccountDepositAchTransactionService;
import com.example.hnbconsumerapi.service.CustomerService;
import com.example.hnbconsumerapi.service.PendingTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class HNBController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountDepositAchTransactionService accountDepositAchTransactionService;

    @Autowired
    private PendingTransactionService pendingTransactionService;

    @QueryMapping
    public CustomerAccountInfo getCustomerAccountInfo(@Argument String customerId) {
        return customerService.getCustomerDetailsById(customerId);
    }

    @SchemaMapping
    public Collection<PendingTransactions> pendingTransactions(CustomerAccountInfo customerAccountInfo) {
        return pendingTransactionService.getPendingTransactionDetailsByCustomerId(customerAccountInfo.getCustomerRelationshipAccount().getCustomerId());
    }

    @SchemaMapping
    public Collection<AccountDepositAchTransactions> accountDepositAchTransactions(CustomerAccountInfo customerAccountInfo) {
        return accountDepositAchTransactionService.getAccountDepositAchTransactionsByAccountId(customerAccountInfo.getCustomerRelationshipAccount().getAccountId());
    }

    @QueryMapping
    public TransactionHistory getTransactionHistory(@Argument String accountId) {
        return new TransactionHistory(accountId);
    }

    @SchemaMapping
    public Collection<PendingTransactions> pendingTransactions(TransactionHistory transactionHistory) {
        return pendingTransactionService.getPendingTransactionsByAccountId(transactionHistory.getAccountId());
    }

    @SchemaMapping
    public Collection<AccountDepositAchTransactions> accountDepositAchTransactions(TransactionHistory transactionHistory) {
        return accountDepositAchTransactionService.getAccountDepositAchTransactionsByAccountId(transactionHistory.getAccountId());
    }

    @QueryMapping
    public CustomerLatestTransaction getCustomerLatestTransaction(@Argument String customerId) {
        return customerService.getCustomerLatestTransaction(customerId);
    }

    @QueryMapping
    public LatestTransactionRecord getLatestTransactionForCustomer(@Argument String customerId) {
        return pendingTransactionService.getLatestTransactionByCustomerId(customerId);
    }

    @SchemaMapping
    public Collection<AccountInfo> accounts(LatestTransactionRecord latestTransactionRecord) {
        return accountDepositAchTransactionService.getAccountInfoByCustomerId(latestTransactionRecord.getCustomerDetails().getCustomerId());
    }

    @QueryMapping
    public AggregatedTransactions getAggregatedTransactions(@Argument String accountId, @Argument String startDate, @Argument String endDate) {
        return new AggregatedTransactions(accountId, startDate, endDate);
    }

    @SchemaMapping
    public Collection<PendingTransactions> mpTransactions(AggregatedTransactions aggregatedTransactions) {
        return pendingTransactionService.getMemopostTransactionsByDate(aggregatedTransactions.getAccountId(), aggregatedTransactions.getStartDate(), aggregatedTransactions.getEndDate());
    }

    @SchemaMapping
    public Collection<AccountDepositAchTransactions> achTransactions(AggregatedTransactions aggregatedTransactions) {
        return accountDepositAchTransactionService.getAchDepositAchTransactionsByDate(aggregatedTransactions.getAccountId(), aggregatedTransactions.getStartDate(), aggregatedTransactions.getEndDate());
    }

    @QueryMapping
    public Past2DayTransactions getPast2DayTransactionsByAccountId(@Argument String accountId) {
        return new Past2DayTransactions(accountId);
    }

    @SchemaMapping
    public Collection<AccountDepositAchTransactions> accounts(Past2DayTransactions past2DayTransactions) {
        return accountDepositAchTransactionService.getPast2DaysAchTransactionsByAccountId(past2DayTransactions.getAccountId());
    }

    @SchemaMapping
    public CustomerRelationshipAccount customer(Past2DayTransactions past2DayTransactions) {
        return customerService.getCustomerDetailsByAccountId(past2DayTransactions.getAccountId());
    }

}
