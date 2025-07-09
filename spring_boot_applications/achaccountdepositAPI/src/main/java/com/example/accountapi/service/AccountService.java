package com.example.accountapi.service;

import com.example.accountapi.model.AccountDepositAchTransactions;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private List<AccountDepositAchTransactions> depositTransactions = new ArrayList<>();

    public AccountService(){

        depositTransactions.add(createDepositTransactions("ACC1", "PEN-TRAN-1-ACC1"));
        depositTransactions.add(createDepositTransactions("ACC1", "PEN-TRAN-2-ACC1"));
        depositTransactions.add(createDepositTransactions("ACC1-1", "PEN-TRAN-1-ACC1-1"));
        depositTransactions.add(createDepositTransactions("ACC2", "PEN-TRAN-2-ACC2"));
        depositTransactions.addAll(createPast2DaysTransaction("ACC1", "PEN-TRAN-3-ACC1"));

    }

    public List<AccountDepositAchTransactions> createPast2DaysTransaction(String accountId, String pendingTransactionId) {

        List<AccountDepositAchTransactions> past2DayTransactions = new ArrayList<>();

        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<String> recentDates = new ArrayList<>();
        recentDates.add(formatter.format(today));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date yesterday = calendar.getTime();
        recentDates.add(formatter.format(yesterday));

        past2DayTransactions = recentDates.stream().map(
                date -> createDepositTransactions(accountId, pendingTransactionId, date)
        ).toList();
        return past2DayTransactions;

    }

    private AccountDepositAchTransactions createDepositTransactions(String accountId, String pendingTransactionId, String date) {

        AccountDepositAchTransactions transaction = createDepositTransactions(accountId, pendingTransactionId);
        transaction.setPostingDate(date);
        return transaction;
    }

    private AccountDepositAchTransactions createDepositTransactions(String accountId, String pendingTransactionId) {

        AccountDepositAchTransactions depositTransaction = new AccountDepositAchTransactions();
        Random random = new Random();

        depositTransaction.setAccountId(accountId);
        depositTransaction.setPendingTransactionId(pendingTransactionId);

        String uuid = UUID.randomUUID().toString().replace("-", "");
        String formattedUuid = uuid.substring(0, 6) + "-" +
                uuid.substring(6, 10) + "-" +
                uuid.substring(10, 14) + "-" +
                uuid.substring(14, 18) + "-" +
                uuid.substring(18, 28);
        depositTransaction.setAccountDepositAchTransactionId(formattedUuid);

        depositTransaction.setAccountDepositsAchBatchId("Batch-"+formattedUuid);
        depositTransaction.setAccountDepositsAchFileId("File-"+formattedUuid);

        long random15DigitNumber = (long) (Math.random() * 1000000000000000L);
        depositTransaction.setBankNumber(String.valueOf(random15DigitNumber));

        List<String> statusTypes = List.of("PENDING", "COMPLETED");
        String statusType = statusTypes.get((int) (Math.random() * statusTypes.size()));
        depositTransaction.setTransactionStatusType(statusType);

        int transactionCode = 1000 + random.nextInt(9000);
        depositTransaction.setSourceTransactionCode(String.valueOf(transactionCode));

        StringBuilder descBuilder = new StringBuilder("EQH-SourceTransDesc-");

        for (int i = 0; i < 3; i++) {
            char randomUpperChar = (char) ('A' + random.nextInt(26));
            descBuilder.append(randomUpperChar);
        }

        for (int i = 0; i < 7; i++) {
            char randomLowerChar = (char) ('a' + random.nextInt(26));
            descBuilder.append(randomLowerChar);
        }
        depositTransaction.setSourceTransactionDescription(descBuilder.toString());

        int wholeNumber = 1000 + random.nextInt(9000);
        int decimalPart = random.nextInt(1000000000);
        String formattedDecimal = String.format("%010d", decimalPart);
        String transactionAmount = wholeNumber + "." + formattedDecimal;
        depositTransaction.setTransactionAmount(transactionAmount);

        depositTransaction.setCurrencyCode("USD");
        List<String> amountTypes = List.of("CREDIT", "DEBIT");
        String amountType = amountTypes.get(random.nextInt(amountTypes.size()));
        depositTransaction.setTransactionAmountType(amountType);

        try {
            long start = new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01").getTime();
            long now = System.currentTimeMillis();
            long randomTimestamp = start + (long) (random.nextDouble() * (now - start));

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS-05:00");
            String transactionTimestamp = formatter.format(new Date(randomTimestamp));
            depositTransaction.setTransactionTimeStamp(transactionTimestamp);
        }catch(java.text.ParseException e){
            depositTransaction.setTransactionTimeStamp("2024-01-01T00:00:00.000000-05:00");
        }

        if (depositTransaction.getTransactionTimeStamp() != null &&
                depositTransaction.getTransactionTimeStamp().length() >= 10) {
            String postingDate = depositTransaction.getTransactionTimeStamp().substring(0, 10);
            depositTransaction.setPostingDate(postingDate);
        } else {
            depositTransaction.setPostingDate("2024-01-01");
        }

        List<String> shortDescriptions = List.of(
                "Electronic Deposit - Direct Deposit",
                "ACH Credit - Payroll Transfer",
                "Electronic Payment - Account Transfer"
        );
        String shortDescription = shortDescriptions.get(random.nextInt(shortDescriptions.size()));
        depositTransaction.setShortDescription(shortDescription);

        int minTraceNumber = 1000000000;
        int maxTraceNumber = 2147483647;
        int traceNumberValue = minTraceNumber + random.nextInt(maxTraceNumber - minTraceNumber);
        depositTransaction.setTraceNumber(String.valueOf(traceNumberValue));

        if (depositTransaction.getPostingDate() != null && depositTransaction.getPostingDate().length() >= 7) {
            String year = depositTransaction.getPostingDate().substring(0, 4);
            String month = depositTransaction.getPostingDate().substring(5, 7);
            String effectiveDate = year + "-" + month + "-01";
            depositTransaction.setEffectiveDate(effectiveDate);
        } else {
            depositTransaction.setEffectiveDate("2024-01-01");
        }

        int minNoteNumber = 100000;
        int maxNoteNumber = 999999;
        int noteValue = minNoteNumber + random.nextInt(maxNoteNumber - minNoteNumber + 1);
        depositTransaction.setTransactionNote(String.valueOf(noteValue));

        int sourceRefValue = minTraceNumber + random.nextInt(maxTraceNumber - minTraceNumber);
        depositTransaction.setSourceTransactionReference(String.valueOf(sourceRefValue));

        depositTransaction.setStandardEntryClassReference("PPD");

        if (shortDescription != null) {
            Map<String, String> addendaMapping = Map.of(
                    "Electronic Deposit - Direct Deposit", "PAYROLL PAYMENT FOR EMPLOYEE ID #" + (100000 + random.nextInt(900000)),
                    "ACH Credit - Payroll Transfer", "DEPOSIT FROM ABC CORP REF #" + (2000 + random.nextInt(8000)),
                    "Electronic Payment - Account Transfer", "TRANSFER FROM ACCOUNT ENDING " + (1000 + random.nextInt(9000))
            );
            String addendaText = addendaMapping.getOrDefault(shortDescription,
                    "DEPOSIT REF #" + (10000 + random.nextInt(90000)));
            depositTransaction.setAddendaText(addendaText);
        } else {
            depositTransaction.setAddendaText("STANDARD ACH TRANSACTION");
        }

        StringBuilder externalAccountNumberBuilder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            char randomLetter = (char) ('A' + random.nextInt(26));
            externalAccountNumberBuilder.append(randomLetter);
        }
        for (int i = 0; i < 23; i++) {
            externalAccountNumberBuilder.append(random.nextInt(10));
        }
        depositTransaction.setExternalAccountNumber(externalAccountNumberBuilder.toString());

        try {
            String postingDateStr = depositTransaction.getPostingDate();
            String day1 = postingDateStr.substring(0, 2);
            String month1 = postingDateStr.substring(2, 4);
            String year1 = postingDateStr.substring(4);
            depositTransaction.setStartDate(day1 + "-" + month1 + "-" + year1);
        } catch (Exception e) {
            depositTransaction.setStartDate("01-01-2024"); // default
        }
        depositTransaction.setStartDate(depositTransaction.getPostingDate());

        try {
            String postingDateStr = depositTransaction.getPostingDate();
            Calendar endDateCal = Calendar.getInstance();

            int dayNew = Integer.parseInt(postingDateStr.substring(0, 2));
            int monthNew = Integer.parseInt(postingDateStr.substring(2, 4)) - 1;
            int yearNew = Integer.parseInt(postingDateStr.substring(4));

            endDateCal.set(yearNew, monthNew, dayNew);

            int daysToAdd = random.nextInt(3) + 1;
            endDateCal.add(Calendar.DAY_OF_MONTH, daysToAdd);

            String endDateStr = String.format("%02d-%02d-%04d",
                    endDateCal.get(Calendar.DAY_OF_MONTH),
                    endDateCal.get(Calendar.MONTH) + 1,
                    endDateCal.get(Calendar.YEAR));

            depositTransaction.setEndDate(endDateStr);
        } catch (Exception e) {
            depositTransaction.setEndDate(depositTransaction.getPostingDate());
        }

        return depositTransaction;
    }

    public List<AccountDepositAchTransactions> getAchDepositsByAccountId(String accountId) {
        List<AccountDepositAchTransactions> filteredTransactions = new ArrayList<>();
        for (AccountDepositAchTransactions transaction : depositTransactions) {
            if (transaction.getAccountId().equals(accountId)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public AccountDepositAchTransactions getLatestTransactionByCustomerId(String customerId) {

        Map<String, String> customerToAccountMap = Map.of(
                "1", "ACC1",
                "2", "ACC2",
                "3", "ACC3",
                "4", "ACC4"
        );
        List<AccountDepositAchTransactions> accountTransactions = getAchDepositsByAccountId(customerToAccountMap.getOrDefault(customerId, null));

        if (accountTransactions.isEmpty()) {
            return null;
        }

        return accountTransactions.stream()
                .max(Comparator.comparing(transaction -> {
                    try {
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS-05:00");
                        return formatter.parse(transaction.getTransactionTimeStamp()).getTime();
                    } catch (Exception e) {
                        return 0L;
                    }
                }))
                .orElse(null);
    }

    public AccountDepositAchTransactions getLatestTransactionByAccountId(String accountId) {

        List<AccountDepositAchTransactions> accountTransactions = getAchDepositsByAccountId(accountId);

        if (accountTransactions.isEmpty()) {
            return null;
        }

        return accountTransactions.stream()
                .max(Comparator.comparing(transaction -> {
                    try {
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS-05:00");
                        return formatter.parse(transaction.getTransactionTimeStamp()).getTime();
                    } catch (Exception e) {
                        return 0L;
                    }
                }))
                .orElse(null);
    }

    public List<AccountDepositAchTransactions> getAccountTransactionsFromDate(String accountId, String date) {
        List<AccountDepositAchTransactions> filteredTransactions = new ArrayList<>();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date givenDate = dateFormat.parse(date);

            for (AccountDepositAchTransactions transaction : depositTransactions) {
                if (!transaction.getAccountId().equals(accountId)) {
                    continue;
                }
                Date transactionDate;
                try {
                    if (transaction.getPostingDate().contains("-")) {
                        transactionDate = new SimpleDateFormat("yyyy-MM-dd").parse(transaction.getPostingDate());
                    } else {
                        transactionDate = new SimpleDateFormat("ddMMyyyy").parse(transaction.getPostingDate());
                    }
                    if (transactionDate.compareTo(givenDate) >= 0) {
                        filteredTransactions.add(transaction);
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (Exception e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }

        return filteredTransactions;
    }

    public List<AccountDepositAchTransactions> getAchTransactionsFromStartDate(String accountId, String startDate, String endDate) throws ParseException {

        List<AccountDepositAchTransactions> filteredTransactions = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date givenStartDate = dateFormat.parse(startDate);
        Date givenEndDate = dateFormat.parse(endDate);

        for (AccountDepositAchTransactions achTransaction : depositTransactions) {
            if (achTransaction.getAccountId().equals(accountId)) {
                String startDateStr = achTransaction.getPostingDate();
                Date transactionDate = dateFormat.parse(startDateStr);
                if (transactionDate.compareTo(givenStartDate) >= 0 && transactionDate.compareTo(givenEndDate) < 0) {
                    filteredTransactions.add(achTransaction);
                }

//                if (transactionDate.equals(givenDate)) {
//                    filteredTransactions.add(achTransaction);
//                }
            }
        }
        return filteredTransactions;
    }

    public List<AccountDepositAchTransactions> getPast2DayTransactionsByAccountId(String accountId) throws ParseException {

        List<AccountDepositAchTransactions> filteredTransactions = new ArrayList<>();
        for ( AccountDepositAchTransactions achTransaction : depositTransactions) {
            if (achTransaction.getAccountId().equals(accountId)) {

                LocalDate transactionDate = LocalDate.parse(achTransaction.getPostingDate());
                LocalDate today = LocalDate.now();
                LocalDate yesterday = today.minusDays(1);

                if (transactionDate.isEqual(today) || transactionDate.isEqual(yesterday)) {
                    filteredTransactions.add(achTransaction);
                }

            }
        }
        return filteredTransactions;
    }
}
