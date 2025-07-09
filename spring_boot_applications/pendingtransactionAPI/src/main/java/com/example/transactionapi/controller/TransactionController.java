package com.example.transactionapi.controller;

import com.example.transactionapi.model.PendingTransactions;
import com.example.transactionapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/pending-transactions")
public class TransactionController {

    @Autowired
    private TransactionService pendingTransactionService;

    @GetMapping("/customer/{customerId}")
    public List<PendingTransactions> getAllPendingTransactions(@PathVariable String customerId) {
        return pendingTransactionService.getPendingTransactionsByCustomerId(customerId);
    }

    @GetMapping("/account/{accountId}")
    public List<PendingTransactions> getAllPendingTransactionsByAccountId(@PathVariable String accountId) {
        return pendingTransactionService.getPendingTransactionsByAccountId(accountId);
    }

    @GetMapping("/balance/{accountId}")
    public String getBalanceAmount(@PathVariable String accountId) {
        return pendingTransactionService.getAvailableBalanceForAccount(accountId);
    }

    @GetMapping("/transactions-by-date/{accountId}/{startDate}/{endDate}")
    public List<PendingTransactions> getMemoPostTransactionsFromDate(
            @PathVariable String accountId,
            @PathVariable String startDate,
            @PathVariable String endDate) throws ParseException {
        return pendingTransactionService.getPendingTransactionsFromStartDate(accountId, startDate, endDate);
    }
}
