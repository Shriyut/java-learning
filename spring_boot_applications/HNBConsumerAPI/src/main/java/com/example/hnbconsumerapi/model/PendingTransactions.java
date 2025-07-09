package com.example.hnbconsumerapi.model;

import lombok.Data;

@Data
public class PendingTransactions {

    private String pendingTransactionId;
    private String accountId;
    private String transactionAmountType;
    private String postingDate;
    private String customerId;

    private String sicCode;
    private Boolean forcedIndicator;
    private String transactionCurrency;
    private String transactionAmount;
    private String cashAmount;
    private String checkAmount;
    private String feeAmount;
    private String description;
    private String availableBalanceCurrency;
    private String availableBalanceAmount;
    private Boolean additionalFundingUsedIndicator;
    private String originalDepositAmount;

    private String sourceSystemReference;
    private String sourceTransactionCode;
    private String sourceTransactionReference;
    private String sourceSequenceNumber;
    private String sourceTransactionDate;
    private String sourceTransactionTime;
    private String transactionRecordedTimestamp;
    private String isoTransactionCode;
    private String transactionCity;
    private String transactionState;
    private String transactionAuthorizationCode;
    private String pendingPenaltyFeeAmount;
    private Boolean carryoverIndicator;
    private String additionalFundingUsedAmount;
    private String loginType;
    private String loginId;
    private String sourceTransactionType;

    private String startDate;
    private String endDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPendingPenaltyFeeAmount() {
        return pendingPenaltyFeeAmount;
    }

    public void setPendingPenaltyFeeAmount(String pendingPenaltyFeeAmount) {
        this.pendingPenaltyFeeAmount = pendingPenaltyFeeAmount;
    }

    public String getSourceSystemReference() {
        return sourceSystemReference;
    }

    public void setSourceSystemReference(String sourceSystemReference) {
        this.sourceSystemReference = sourceSystemReference;
    }

    public String getSourceTransactionCode() {
        return sourceTransactionCode;
    }

    public void setSourceTransactionCode(String sourceTransactionCode) {
        this.sourceTransactionCode = sourceTransactionCode;
    }

    public String getSourceTransactionReference() {
        return sourceTransactionReference;
    }

    public void setSourceTransactionReference(String sourceTransactionReference) {
        this.sourceTransactionReference = sourceTransactionReference;
    }

    public String getSourceSequenceNumber() {
        return sourceSequenceNumber;
    }

    public void setSourceSequenceNumber(String sourceSequenceNumber) {
        this.sourceSequenceNumber = sourceSequenceNumber;
    }

    public String getSourceTransactionDate() {
        return sourceTransactionDate;
    }

    public void setSourceTransactionDate(String sourceTransactionDate) {
        this.sourceTransactionDate = sourceTransactionDate;
    }

    public String getSourceTransactionTime() {
        return sourceTransactionTime;
    }

    public void setSourceTransactionTime(String sourceTransactionTime) {
        this.sourceTransactionTime = sourceTransactionTime;
    }

    public String getTransactionRecordedTimestamp() {
        return transactionRecordedTimestamp;
    }

    public void setTransactionRecordedTimestamp(String transactionRecordedTimestamp) {
        this.transactionRecordedTimestamp = transactionRecordedTimestamp;
    }

    public String getIsoTransactionCode() {
        return isoTransactionCode;
    }

    public void setIsoTransactionCode(String isoTransactionCode) {
        this.isoTransactionCode = isoTransactionCode;
    }

    public String getTransactionCity() {
        return transactionCity;
    }

    public void setTransactionCity(String transactionCity) {
        this.transactionCity = transactionCity;
    }

    public String getTransactionState() {
        return transactionState;
    }

    public void setTransactionState(String transactionState) {
        this.transactionState = transactionState;
    }

    public String getTransactionAuthorizationCode() {
        return transactionAuthorizationCode;
    }

    public void setTransactionAuthorizationCode(String transactionAuthorizationCode) {
        this.transactionAuthorizationCode = transactionAuthorizationCode;
    }

    public Boolean getCarryoverIndicator() {
        return carryoverIndicator;
    }

    public void setCarryoverIndicator(Boolean carryoverIndicator) {
        this.carryoverIndicator = carryoverIndicator;
    }

    public String getAdditionalFundingUsedAmount() {
        return additionalFundingUsedAmount;
    }

    public void setAdditionalFundingUsedAmount(String additionalFundingUsedAmount) {
        this.additionalFundingUsedAmount = additionalFundingUsedAmount;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getSourceTransactionType() {
        return sourceTransactionType;
    }

    public void setSourceTransactionType(String sourceTransactionType) {
        this.sourceTransactionType = sourceTransactionType;
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(String cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String getCheckAmount() {
        return checkAmount;
    }

    public void setCheckAmount(String checkAmount) {
        this.checkAmount = checkAmount;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvailableBalanceCurrency() {
        return availableBalanceCurrency;
    }

    public void setAvailableBalanceCurrency(String availableBalanceCurrency) {
        this.availableBalanceCurrency = availableBalanceCurrency;
    }

    public String getAvailableBalanceAmount() {
        return availableBalanceAmount;
    }

    public void setAvailableBalanceAmount(String availableBalanceAmount) {
        this.availableBalanceAmount = availableBalanceAmount;
    }

    public Boolean getAdditionalFundingUsedIndicator() {
        return additionalFundingUsedIndicator;
    }

    public void setAdditionalFundingUsedIndicator(Boolean additionalFundingUsedIndicator) {
        this.additionalFundingUsedIndicator = additionalFundingUsedIndicator;
    }

    public String getOriginalDepositAmount() {
        return originalDepositAmount;
    }

    public void setOriginalDepositAmount(String originalDepositAmount) {
        this.originalDepositAmount = originalDepositAmount;
    }



    public Boolean getForcedIndicator() {
        return forcedIndicator;
    }

    public void setForcedIndicator(Boolean forcedIndicator) {
        this.forcedIndicator = forcedIndicator;
    }

    public String getSicCode() {
        return sicCode;
    }

    public void setSicCode(String sicCode) {
        this.sicCode = sicCode;
    }

    public String getPendingTransactionId() {
        return pendingTransactionId;
    }

    public void setPendingTransactionId(String pendingTransactionId) {
        this.pendingTransactionId = pendingTransactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTransactionAmountType() {
        return transactionAmountType;
    }

    public void setTransactionAmountType(String transactionAmountType) {
        this.transactionAmountType = transactionAmountType;
    }

    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
