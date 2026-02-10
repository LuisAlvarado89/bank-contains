package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountsByIban {
    private String iban;
    private String nif;
    private double balance;
}
