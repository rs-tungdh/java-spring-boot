package org.example.javaspringbootstudy.service;

import org.example.javaspringbootstudy.model.Account;
import org.example.javaspringbootstudy.model.Authority;
import org.example.javaspringbootstudy.repository.AccountRepository;
import org.example.javaspringbootstudy.repository.AuthorityRepository;
import org.example.javaspringbootstudy.util.constants.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    public Authority save(Authority authority) {
        return authorityRepository.save(authority);
    }

    public Optional<Authority> findById(Long id) {
        return authorityRepository.findById(id);
    }
}
