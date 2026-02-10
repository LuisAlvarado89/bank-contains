package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Bank {
    private String nameBank;
    private Map<String, AccountsByIban> accountsByIban;
    private List<Customers> customers;

}
