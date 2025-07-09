package com.example.accountapi.controller;

import com.example.accountapi.model.AccountDepositAchTransactions;
import com.example.accountapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/ach-deposits")
public class AccountController {

    @Autowired
    private AccountService achDepositService;

    @GetMapping("/accounts/{accountId}")
    public List<AccountDepositAchTransactions> getAchDepositsByAccountId(@PathVariable String accountId) {
        return achDepositService.getAchDepositsByAccountId(accountId);
    }

    @GetMapping("/latest-transaction/{customerId}")
    public AccountDepositAchTransactions getLatestTransactionByCustomerId(@PathVariable String customerId) {
        return achDepositService.getLatestTransactionByCustomerId(customerId);
    }

    @GetMapping("/latest-account-transaction/{accountId}")
    public AccountDepositAchTransactions getLatestTransactionByAccountId(@PathVariable String accountId) {
        return achDepositService.getLatestTransactionByAccountId(accountId);
    }

    @GetMapping("/transaction-by-date/{accountId}/{date}")
    public List<AccountDepositAchTransactions> getAccountTransactionsFromDate(
            @PathVariable String accountId,
            @PathVariable String date) {
        return achDepositService.getAccountTransactionsFromDate(accountId, date);
    }

    @GetMapping("/transactions-by-date/{accountId}/{startDate}/{endDate}")
    public List<AccountDepositAchTransactions> getAchTransactionsFromDate(
            @PathVariable String accountId,
            @PathVariable String startDate,
            @PathVariable String endDate) throws ParseException {
        return achDepositService.getAchTransactionsFromStartDate(accountId, startDate, endDate);
    }

    @GetMapping("/past-2-days-transactions/{accountId}")
    public List<AccountDepositAchTransactions> getPast2DayAchTransactions(
            @PathVariable String accountId
    ) throws ParseException {
        return achDepositService.getPast2DayTransactionsByAccountId(accountId);
    }

}
