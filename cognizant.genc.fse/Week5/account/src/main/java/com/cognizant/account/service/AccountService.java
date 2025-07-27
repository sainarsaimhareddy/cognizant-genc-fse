package com.cognizant.account.service;

import org.springframework.stereotype.Service;

import com.cognizant.account.Account;
@Service
public class AccountService {
    public Account getAccountDetails(String number){
        return new Account("32e0","debit",30000.00);
        
    }
}
