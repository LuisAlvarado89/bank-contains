package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Bank {
    private String nameBank;
    private Map<String, Account> accountsByIban;
    private List<Customer> customers;

    public void deposit(String iban, double amount) {
        if (accountsByIban.containsKey(iban)) {
            Account account = accountsByIban.get(iban);
            account.deposit(amount);
        } else {
            System.out.printf("Error: No existe la cuenta");

        }
    }

    public List<Account> getCustomerAccounts(String nif) {
        Customer customer = findCustomer(nif);
        if (customer != null) {
            List<Account> customerAcounts = new ArrayList<>();
            for (Account account : accountsByIban.values()) {
                if (account.getNif().equals(nif)) {
                    customerAcounts.add(account);
                }
            }
            return customerAcounts;
        } else {
            System.out.printf("No se ha encontrado al cliente");
            return null;
        }
    }

    public Customer findCustomer(String nif) {
        for (Customer customer : customers) {
            if (customer.getNif().equals(nif)) {
                return customer;
            }
        }
        return null;
    }

    public void withdrawAmount(String iban, double amount) {
        if (accountsByIban.containsKey(iban)) {
            Account account = accountsByIban.get(iban);
            {
                account.withdraw(amount);

            }
        } else {
            System.out.println("No se ha encontrado la cuenta");

        }
    }

    public Customer customerZipCode(int zipcode) {
        for (Customer customer : customers) {
            if (customer.getZipCode() == zipcode) {
                return customer;
            }
        }
        return null;
    }

    public List<Account> accountProperty(int zipCode) {
        List<Account> accounts = new ArrayList<>();
        Customer customer = customerZipCode(zipCode);
        for (Account account : accountsByIban.values()) {
            if (account.getNif().equals(customer.getNif())) {
                accounts.add(account);

            }
        }
        return accounts;

    }

}


