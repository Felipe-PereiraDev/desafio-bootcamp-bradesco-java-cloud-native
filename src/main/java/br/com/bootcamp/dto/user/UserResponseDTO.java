package br.com.bootcamp.dto.user;

import br.com.bootcamp.dto.account.AccountResponseDTO;
import br.com.bootcamp.entity.User;

public record UserResponseDTO(
        String name,
        AccountResponseDTO account
) {
    public UserResponseDTO(User user) {
        this(
                user.getName(),
                new AccountResponseDTO(user.getAccount())
        );
    }
}
