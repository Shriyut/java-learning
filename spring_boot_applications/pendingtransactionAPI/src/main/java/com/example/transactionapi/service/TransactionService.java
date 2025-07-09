package com.example.transactionapi.service;

import org.springframework.stereotype.Service;
import com.example.transactionapi.model.PendingTransactions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TransactionService {
    private List<PendingTransactions> pendingTransactionsList = new ArrayList<>();

    public TransactionService() {
        pendingTransactionsList.add(createPendingTransactions("1", "ACC1"));
        pendingTransactionsList.add(createPendingTransactions("1", "ACC1-1"));
        pendingTransactionsList.add(createPendingTransactions("2", "ACC2"));
        pendingTransactionsList.add(createPendingTransactions("2", "ACC2-2"));
        pendingTransactionsList.add(createPendingTransactions("3", "ACC3"));
        pendingTransactionsList.add(createPendingTransactions("4", "ACC4"));
    }

    private PendingTransactions createPendingTransactions(String customerId, String accountId) {
        PendingTransactions pt = new PendingTransactions();

        List<String> transactionTypes = List.of("Deposit", "Debit", "Credit");
        Random random = new Random();
        int randomIndex = random.nextInt(transactionTypes.size());
        pt.setTransactionAmountType(transactionTypes.get(randomIndex));

        pt.setCustomerId(customerId);
        pt.setAccountId(accountId);
        pt.setPendingTransactionId("PEN-TRAN-"+customerId+"-"+accountId);

        Calendar startDate = Calendar.getInstance();
        startDate.set(2024, Calendar.JANUARY, 1);
        long startMillis = startDate.getTimeInMillis();

        Calendar endDate = Calendar.getInstance();
        endDate.set(2025, Calendar.APRIL, 14);
        long endMillis = endDate.getTimeInMillis();

        long randomMillis = startMillis + (long) (Math.random() * (endMillis - startMillis));
        Date randomDate = new Date(randomMillis);
        pt.setPostingDate(String.format("%1$tY-%1$tm-%1$td", randomDate));

        int sicCode = 1000 + random.nextInt(9999);
        pt.setSicCode(String.valueOf(sicCode));

        pt.setForcedIndicator(random.nextBoolean());

        List<String> currencies = List.of("USD", "EUR", "PND", "INR", "YEN");
        pt.setTransactionCurrency(currencies.get(random.nextInt(currencies.size())));

        int digitCount = random.nextInt(3) + 3;
        double minAmount = Math.pow(10, digitCount - 1);
        double maxAmount = Math.pow(10, digitCount) - 0.01;
        double amount = minAmount + (random.nextDouble() * (maxAmount - minAmount));
        String formattedAmount = String.format("%.2f", amount);
        pt.setTransactionAmount(formattedAmount);

        boolean dividedTransaction = random.nextDouble() < 0.2; // 20% chance to have divided amounts
        double cashPercentage;
        double checkAmount = 0.0;
        double feeAmount = 0.0;

        if (dividedTransaction) {
            // Cash gets 70-90% of the total amount
            cashPercentage = 0.7 + (random.nextDouble() * 0.2); // Random between 70-90%
            double cashAmount = amount * cashPercentage;

            // Remaining amount is split: 90% to check, 10% to fee
            double remainingAmount = amount - cashAmount;
            checkAmount = remainingAmount * 0.9;
            feeAmount = remainingAmount * 0.1;

            pt.setCashAmount(String.format("%.2f", cashAmount));
            pt.setCheckAmount(String.format("%.2f", checkAmount));
            pt.setFeeAmount(String.format("%.2f", feeAmount));
        } else {
            // Cash gets 100% of the amount, check and fee are zero
            pt.setCashAmount(formattedAmount);
            pt.setCheckAmount("0.00");
            pt.setFeeAmount("0.00");
        }

        String index = String.valueOf(random.nextInt(3) + 1);;
        String description = "AUTOMATION:HappyPathScn" + pt.getPendingTransactionId() + "_MSG_PSTONLY:index:" + index;
        pt.setDescription(description);

        double balance = Double.parseDouble(formattedAmount);
        double availableBalanceAmount = balance + (random.nextDouble() * balance * 0.5);
        pt.setAvailableBalanceAmount(String.format("%.2f", availableBalanceAmount));
        pt.setAvailableBalanceCurrency(pt.getTransactionCurrency());
        pt.setAdditionalFundingUsedIndicator(random.nextBoolean());
        pt.setOriginalDepositAmount(formattedAmount);
        pt.setSourceSystemReference("NET");

        StringBuilder codeBuilder = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            char randomChar = (char) (65 + random.nextInt(26)); // ASCII 65-90 (A-Z)
            codeBuilder.append(randomChar);
        }

        for (int i = 0; i < 2; i++) {
            codeBuilder.append(random.nextInt(10)); // Digits 0-9
        }
        pt.setSourceTransactionCode(codeBuilder.toString());

        StringBuilder refBuilder = new StringBuilder();
        String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < 10; i++) {
            int index1 = random.nextInt(alphanumeric.length());
            refBuilder.append(alphanumeric.charAt(index1));
        }
        pt.setSourceTransactionReference(refBuilder.toString());

        StringBuilder seqBuilder = new StringBuilder("H");
        for (int i = 0; i < 2; i++) {
            char randomChar = (char) (65 + random.nextInt(26)); // ASCII 65-90 (A-Z)
            seqBuilder.append(randomChar);
        }
        for (int i = 0; i < 5; i++) {
            seqBuilder.append(random.nextInt(10)); // Digits 0-9
        }
        pt.setSourceSequenceNumber(seqBuilder.toString());

        String postingDate = pt.getPostingDate();
        pt.setSourceTransactionDate(postingDate);

        int hour = random.nextInt(24);    // 0-23 hours
        int minute = random.nextInt(60);  // 0-59 minutes
        int second = random.nextInt(60);  // 0-59 seconds
        String sourceTransactionTime = String.format("%02d:%02d:%02d", hour, minute, second);
        pt.setSourceTransactionTime(sourceTransactionTime);

        String sourceDate = pt.getSourceTransactionDate();
        String sourceTime = pt.getSourceTransactionTime();
        String timestamp = sourceDate + "T" + sourceTime + ".000000Z";
        pt.setTransactionRecordedTimestamp(timestamp);

        int isoCode = 100 + random.nextInt(900);
        pt.setIsoTransactionCode(String.valueOf(isoCode));

        Map<String, List<String>> stateCityMap = new HashMap<>();
        stateCityMap.put("CAL", List.of("Los Angeles", "San Francisco", "San Diego"));
        stateCityMap.put("NY", List.of("New York City", "Buffalo", "Rochester"));
        stateCityMap.put("TXS", List.of("Houston", "Austin", "Dallas"));

        List<String> states = new ArrayList<>(stateCityMap.keySet());
        String randomState = states.get(random.nextInt(states.size()));

        List<String> cities = stateCityMap.get(randomState);
        String randomCity = cities.get(random.nextInt(cities.size()));

        pt.setTransactionState(randomState);
        pt.setTransactionCity(randomCity);

        int authCode = 1000000 + random.nextInt(9000000);
        pt.setTransactionAuthorizationCode(String.valueOf(authCode));

        if (random.nextBoolean()) {
            double penaltyFee = random.nextDouble() * 25.0;
            pt.setPendingPenaltyFeeAmount(String.format("%.2f", penaltyFee));
        } else {
            pt.setPendingPenaltyFeeAmount("0.00");
        }

        pt.setCarryoverIndicator(random.nextBoolean());
        pt.setAdditionalFundingUsedAmount("11.00");

        List<String> loginTypes = List.of("colleague", "corporate");
        pt.setLoginType(loginTypes.get(random.nextInt(loginTypes.size())));

        StringBuilder loginIdBuilder = new StringBuilder("H");
        for (int i = 0; i < 7; i++) {
            loginIdBuilder.append(random.nextInt(10));
        }
        pt.setLoginId(loginIdBuilder.toString());
        pt.setSourceTransactionType("200");

        pt.setStartDate(pt.getPostingDate());

        try {
            String postingDateStr = pt.getPostingDate();
            Calendar endDateCal = Calendar.getInstance();

            int dayNew = Integer.parseInt(postingDateStr.substring(0, 2));
            int monthNew = Integer.parseInt(postingDateStr.substring(2, 4)) - 1;
            int yearNew = Integer.parseInt(postingDateStr.substring(4));

            endDateCal.set(yearNew, monthNew, dayNew);

            int daysToAdd = random.nextInt(3) + 1;
            endDateCal.add(Calendar.DAY_OF_MONTH, daysToAdd);

            String endDateStr = String.format("%04d-%02d-%02d",
                    endDateCal.get(Calendar.YEAR),
                    endDateCal.get(Calendar.MONTH) + 1,
                    endDateCal.get(Calendar.DAY_OF_MONTH));

            pt.setEndDate(endDateStr);
        } catch (Exception e) {
            pt.setEndDate(pt.getPostingDate());
        }

        return pt;
    }

    public List<PendingTransactions> getPendingTransactionsByCustomerId(String customerId) {
        List<PendingTransactions> result = new ArrayList<>();
        for (PendingTransactions pt : pendingTransactionsList) {
            if (pt.getCustomerId().equals(customerId)) {
                result.add(pt);
            }
        }
        return result;
    }

    public List<PendingTransactions> getPendingTransactionsByAccountId(String accountId) {
        List<PendingTransactions> result = new ArrayList<>();
        for (PendingTransactions pt : pendingTransactionsList) {
            if (pt.getAccountId().equals(accountId)) {
                result.add(pt);
            }
        }
        return result;
    }

    public String getAvailableBalanceForAccount(String accountId) {
        List<PendingTransactions> accountTransactions = getPendingTransactionsByAccountId(accountId);

        if (accountTransactions.isEmpty()) {
            return null;
        }

        return accountTransactions.stream()
                .map(PendingTransactions::getAvailableBalanceAmount)
                .map(amount -> {
                    try {
                        return Double.parseDouble(amount);
                    } catch (NumberFormatException e) {
                        return 0.0;
                    }
                })
                .max(Double::compare)
                .map(amount -> String.format("%.2f", amount))
                .orElse(null);
    }

    public List<PendingTransactions> getPendingTransactionsFromStartDate(String accountId, String startDate, String endDate) throws ParseException {

        List<PendingTransactions> filteredTransactions = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date givenStartDate = dateFormat.parse(startDate);
        Date givenEndDate = dateFormat.parse(endDate);

        for (PendingTransactions mpTransaction : pendingTransactionsList) {
            if (mpTransaction.getAccountId().equals(accountId)) {
                String postingDate = mpTransaction.getPostingDate();
                Date transactionDate = dateFormat.parse(postingDate);
                if (transactionDate.compareTo(givenStartDate) >= 0 && transactionDate.compareTo(givenEndDate) < 0) {
                    filteredTransactions.add(mpTransaction);
                }

//                if ( transactionDate.equals(givenDate)){
//                    filteredTransactions.add(mpTransaction);
//                }
            }
        }
        return filteredTransactions;
    }

}
