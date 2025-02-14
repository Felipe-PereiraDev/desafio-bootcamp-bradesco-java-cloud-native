package br.com.bootcamp.dto.account;

import br.com.bootcamp.entity.Account;

import java.math.BigDecimal;

public record AccountResponseDTO(
        String agency,
        String number,
        BigDecimal balance,
        BigDecimal limit
) {
    public AccountResponseDTO(Account account) {
        this(
                account.getAgency(),
                account.getNumber(),
                account.getBalance(),
                account.getLimit()
        );
    }
}
