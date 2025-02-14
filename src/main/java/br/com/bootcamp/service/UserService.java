package br.com.bootcamp.service;

import br.com.bootcamp.dto.user.UserCreateDTO;
import br.com.bootcamp.entity.Account;
import br.com.bootcamp.entity.User;
import br.com.bootcamp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountService accountService;

    public User findById(String uuid) {
        return userRepository.findById(UUID.fromString(uuid))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public User create(UserCreateDTO data) {
        User user = new User();
        user.setName(data.name());

        Account account = accountService.generateAccount(user);

        user.setAccount(account);

        return userRepository.save(user);
    }

}
