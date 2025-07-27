package com.cognizant.account;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Account {
    private String number;
    private String type;
    private double balance;

}
