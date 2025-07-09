package com.example.customerapi.service;


import com.example.customerapi.model.CustomerRelationshipAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class CustomerService {

    private List<CustomerRelationshipAccount> customers = new ArrayList<>();

    public CustomerService() {
        customers.add(createCustomer("1", "John Doe"));
        customers.add(createCustomer("2", "Jane Smith"));
        customers.add(createCustomer("3", "Alice Johnson"));
        customers.add(createCustomer("4", "Bob Brown"));
    }

    public CustomerRelationshipAccount getCustomerById(String customerId) {
        return customers.stream()
                .filter(customer -> customer.getCustomerId().equals(customerId))
                .findFirst()
                .orElse(null);
    }

    public String getAccountIdByCustomerId(String customerId) {
        CustomerRelationshipAccount customer = getCustomerById(customerId);
        if (customer != null) {
            return customer.getAccountId();
        }
        return null;
    }

    public CustomerRelationshipAccount getCustomerByAccountId(String accountId) {
        return customers.stream()
                .filter(customer -> customer.getAccountId().equals(accountId))
                .findFirst()
                .orElse(null);
    }

    private CustomerRelationshipAccount createCustomer(String id, String name) {

        CustomerRelationshipAccount customer = new CustomerRelationshipAccount();
        Random random = new Random();

        int randomFourDigits = 1000 + (int)(Math.random() * 9000);
        customer.setCustomerRelationshipsAccountId("CA" + id + randomFourDigits);

        customer.setCustomerRelationshipsAccountId(id);
        customer.setCustomerId(id);
        customer.setNickname(name);

        StringBuilder codeBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            // ASCII values for uppercase letters: 65-90
            char randomChar = (char)(65 + random.nextInt(26));
            codeBuilder.append(randomChar);
        }
        customer.setRelationshipTypeCode(codeBuilder.toString());

        List<String> relationshipDescriptions = List.of(
                "Primary checking account holder",
                "Joint savings account owner",
                "Business account signatory"
        );

        customer.setRelationshipTypeDescription(
                relationshipDescriptions.get(random.nextInt(relationshipDescriptions.size()))
        );

        customer.setRelationshipStatus("Active");

        List<String> designations = List.of("primary", "secondary");
        String designation = designations.get(random.nextInt(designations.size()));
        customer.setOwnerDesignation(designation);

        if ("primary".equals(designation)) {
            customer.setOwnerDesignationTitle("Primary Owner");
            customer.setAccountOwnershipIndicator(true);
        } else {
            customer.setOwnerDesignationTitle("Secondary Owner");
            customer.setAccountOwnershipIndicator(false);
        }

        int bankNumber = 10 + random.nextInt(90);
        customer.setOriginatingBankNumber(String.valueOf(bankNumber));

        customer.setSignerPresentAtAccountOpeningIndicator(true);
        customer.setEffectiveStartDate(new Date());
        customer.setEffectiveEndDate(null);
        customer.setAccountId("ACC"+id);

        int externalAccountNumber = 100 + random.nextInt(900);
        customer.setExternalAccountId(String.valueOf(externalAccountNumber));

        int randomShortNicknameNumbers = 1000 + random.nextInt(9000);
        customer.setAccountShortNickname("SN" + randomShortNicknameNumbers);

        int randomSixDigits = 100000 + random.nextInt(900000);
        customer.setCustomerRelationshipsCustomerId("IP-" + randomSixDigits);

        return customer;
    }


}
