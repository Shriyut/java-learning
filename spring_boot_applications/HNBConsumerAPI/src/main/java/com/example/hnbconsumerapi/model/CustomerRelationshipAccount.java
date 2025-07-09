package com.example.hnbconsumerapi.model;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerRelationshipAccount {

    private String customerId;
    private String nickname;
    private String relationshipTypeCode;
    private String relationshipTypeDescription;
    private String relationshipStatus;
    private boolean accountOwnershipIndicator;
    private String ownerDesignation;
    private String ownerDesignationTitle;
    private String originatingBankNumber;
    private boolean signerPresentAtAccountOpeningIndicator;
    private Date effectiveStartDate;
    private Date effectiveEndDate;
    private String accountId;
    private String externalAccountId;
    private String accountShortNickname;
    private String customerRelationshipsCustomerId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRelationshipTypeCode() {
        return relationshipTypeCode;
    }

    public void setRelationshipTypeCode(String relationshipTypeCode) {
        this.relationshipTypeCode = relationshipTypeCode;
    }

    public String getRelationshipTypeDescription() {
        return relationshipTypeDescription;
    }

    public void setRelationshipTypeDescription(String relationshipTypeDescription) {
        this.relationshipTypeDescription = relationshipTypeDescription;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public boolean isAccountOwnershipIndicator() {
        return accountOwnershipIndicator;
    }

    public void setAccountOwnershipIndicator(boolean accountOwnershipIndicator) {
        this.accountOwnershipIndicator = accountOwnershipIndicator;
    }

    public String getOwnerDesignation() {
        return ownerDesignation;
    }

    public void setOwnerDesignation(String ownerDesignation) {
        this.ownerDesignation = ownerDesignation;
    }

    public String getOwnerDesignationTitle() {
        return ownerDesignationTitle;
    }

    public void setOwnerDesignationTitle(String ownerDesignationTitle) {
        this.ownerDesignationTitle = ownerDesignationTitle;
    }

    public String getOriginatingBankNumber() {
        return originatingBankNumber;
    }

    public void setOriginatingBankNumber(String originatingBankNumber) {
        this.originatingBankNumber = originatingBankNumber;
    }

    public boolean isSignerPresentAtAccountOpeningIndicator() {
        return signerPresentAtAccountOpeningIndicator;
    }

    public void setSignerPresentAtAccountOpeningIndicator(boolean signerPresentAtAccountOpeningIndicator) {
        this.signerPresentAtAccountOpeningIndicator = signerPresentAtAccountOpeningIndicator;
    }

    public Date getEffectiveStartDate() {
        return effectiveStartDate;
    }

    public void setEffectiveStartDate(Date effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }

    public Date getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(Date effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getExternalAccountId() {
        return externalAccountId;
    }

    public void setExternalAccountId(String externalAccountId) {
        this.externalAccountId = externalAccountId;
    }

    public String getAccountShortNickname() {
        return accountShortNickname;
    }

    public void setAccountShortNickname(String accountShortNickname) {
        this.accountShortNickname = accountShortNickname;
    }

    public String getCustomerRelationshipsCustomerId() {
        return customerRelationshipsCustomerId;
    }

    public void setCustomerRelationshipsCustomerId(String customerRelationshipsCustomerId) {
        this.customerRelationshipsCustomerId = customerRelationshipsCustomerId;
    }

    public String getCustomerRelationshipsAccountId() {
        return customerRelationshipsAccountId;
    }

    public void setCustomerRelationshipsAccountId(String customerRelationshipsAccountId) {
        this.customerRelationshipsAccountId = customerRelationshipsAccountId;
    }

    private String customerRelationshipsAccountId;
}