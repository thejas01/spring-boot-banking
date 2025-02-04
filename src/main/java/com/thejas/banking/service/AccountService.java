package com.thejas.banking.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.thejas.banking.entity.Account;
import com.thejas.banking.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AuthService authService;

    // Method to create a new account
    public Account createAccount(Account account, Authentication authentication) {
        String username = authService.getAuthenticatedUsername(authentication); // Get user info from OAuth2 token
        account.setOwner(username); // Set account owner as authenticated user
        account.setAccountNumber(UUID.randomUUID().toString()); // Generate unique account number

        return accountRepository.save(account); // Save and return account
    }

    // Method to retrieve account by ID
    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    // Method to get account by user
    public Optional<Account> getAccountByUser(String username) {
        return accountRepository.findByOwner(username); // Retrieve account by owner's username
    }

}