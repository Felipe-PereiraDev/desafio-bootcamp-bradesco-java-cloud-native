package br.com.bootcamp.service;

import br.com.bootcamp.entity.Account;
import br.com.bootcamp.entity.User;
import br.com.bootcamp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.SecureRandom;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account findById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Account generateAccount(User user) {
        return new Account(generateAccountNumber(), user);
    }

    private String generateAccountNumber() {
        SecureRandom secureRandom = new SecureRandom();
        String accountNumber;
        int number = 0;
        do {
             number = secureRandom.nextInt(90000000) + 10000000;
             accountNumber = number + "-" + secureRandom.nextInt(10);
        } while(accountRepository.existsByNumber(accountNumber));

        return accountNumber;
    }
}
