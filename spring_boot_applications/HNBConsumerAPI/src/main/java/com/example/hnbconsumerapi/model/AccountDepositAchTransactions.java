package com.example.hnbconsumerapi.model;

import lombok.Data;

@Data
public class AccountDepositAchTransactions {

    private String accountDepositAchTransactionId;
    private String pendingTransactionId;
    private String accountId;
    private String bankNumber;
    private String accountDepositsAchFileId;
    private String accountDepositsAchBatchId;

    private String transactionStatusType;
    private String sourceTransactionCode;
    private String sourceTransactionDescription;
    private String transactionAmount;
    private String transactionTimeStamp;
    private String transactionAmountType;
    private String currencyCode;
    private String postingDate;
    private String shortDescription;
    private String traceNumber;
    private String effectiveDate;
    private String transactionNote;
    private String sourceTransactionReference;
    private String standardEntryClassReference;
    private String addendaText;
    private String externalAccountNumber;

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

    public String getTransactionStatusType() {
        return transactionStatusType;
    }

    public void setTransactionStatusType(String transactionStatusType) {
        this.transactionStatusType = transactionStatusType;
    }

    public String getSourceTransactionCode() {
        return sourceTransactionCode;
    }

    public void setSourceTransactionCode(String sourceTransactionCode) {
        this.sourceTransactionCode = sourceTransactionCode;
    }

    public String getSourceTransactionDescription() {
        return sourceTransactionDescription;
    }

    public void setSourceTransactionDescription(String sourceTransactionDescription) {
        this.sourceTransactionDescription = sourceTransactionDescription;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionTimeStamp() {
        return transactionTimeStamp;
    }

    public void setTransactionTimeStamp(String transactionTimeStamp) {
        this.transactionTimeStamp = transactionTimeStamp;
    }

    public String getTransactionAmountType() {
        return transactionAmountType;
    }

    public void setTransactionAmountType(String transactionAmountType) {
        this.transactionAmountType = transactionAmountType;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(String traceNumber) {
        this.traceNumber = traceNumber;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getTransactionNote() {
        return transactionNote;
    }

    public void setTransactionNote(String transactionNote) {
        this.transactionNote = transactionNote;
    }

    public String getSourceTransactionReference() {
        return sourceTransactionReference;
    }

    public void setSourceTransactionReference(String sourceTransactionReference) {
        this.sourceTransactionReference = sourceTransactionReference;
    }

    public String getStandardEntryClassReference() {
        return standardEntryClassReference;
    }

    public void setStandardEntryClassReference(String standardEntryClassReference) {
        this.standardEntryClassReference = standardEntryClassReference;
    }

    public String getAddendaText() {
        return addendaText;
    }

    public void setAddendaText(String addendaText) {
        this.addendaText = addendaText;
    }

    public String getExternalAccountNumber() {
        return externalAccountNumber;
    }

    public void setExternalAccountNumber(String externalAccountNumber) {
        this.externalAccountNumber = externalAccountNumber;
    }





    public String getPendingTransactionId() {
        return pendingTransactionId;
    }

    public void setPendingTransactionId(String pendingTransactionId) {
        this.pendingTransactionId = pendingTransactionId;
    }

    public String getAccountDepositAchTransactionId() {
        return accountDepositAchTransactionId;
    }

    public void setAccountDepositAchTransactionId(String accountDepositAchTransactionId) {
        this.accountDepositAchTransactionId = accountDepositAchTransactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getAccountDepositsAchFileId() {
        return accountDepositsAchFileId;
    }

    public void setAccountDepositsAchFileId(String accountDepositsAchFileId) {
        this.accountDepositsAchFileId = accountDepositsAchFileId;
    }

    public String getAccountDepositsAchBatchId() {
        return accountDepositsAchBatchId;
    }

    public void setAccountDepositsAchBatchId(String accountDepositsAchBatchId) {
        this.accountDepositsAchBatchId = accountDepositsAchBatchId;
    }


}
