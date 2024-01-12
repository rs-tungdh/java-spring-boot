package org.example.javaspringbootstudy.config;

import org.example.javaspringbootstudy.model.Account;
import org.example.javaspringbootstudy.model.Authority;
import org.example.javaspringbootstudy.model.Post;
import org.example.javaspringbootstudy.service.AccountService;
import org.example.javaspringbootstudy.service.AuthorityService;
import org.example.javaspringbootstudy.service.PostService;
import org.example.javaspringbootstudy.util.constants.Privillages;
import org.example.javaspringbootstudy.util.constants.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public void run(String... args) throws Exception {

        for (Privillages auth: Privillages.values()) {
            Authority authority = new Authority();
            authority.setId(auth.getId());
            authority.setName(auth.getPrivillage());
            authorityService.save(authority);
        }

        Account account01 = new Account();
        Account account02 = new Account();
        Account account03 = new Account();
        Account account04 = new Account();

        account01.setEmail("account01@gmail.com");
        account01.setPassword("password");
        account01.setFirstname("user01");
        account01.setLastname("lastname01");

        account02.setEmail("account02@gmail.com");
        account02.setPassword("password");
        account02.setFirstname("user02");
        account02.setLastname("lastname02");
        account02.setRole(Roles.ADMIN.getRole());

        account03.setEmail("account03@gmail.com");
        account03.setPassword("pass123");
        account03.setFirstname("user03");
        account03.setLastname("lastname03");
        account03.setRole(Roles.EDITOR.getRole());

        account04.setEmail("account04@gmail.com");
        account04.setPassword("pass123");
        account04.setFirstname("user04");
        account04.setLastname("lastname04");
        account04.setRole(Roles.EDITOR.getRole());
        Set<Authority> authorities = new HashSet<>();
        authorityService.findById(Privillages.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authorities::add);
        authorityService.findById(Privillages.ACCESS_ADMIN_PANEL.getId()).ifPresent(authorities::add);
        account04.setAuthorities(authorities);

        accountService.save(account01);
        accountService.save(account02);
        accountService.save(account03);
        accountService.save(account04);

        List<Post> posts = postService.getAll();

        if (posts.isEmpty()) {
            Post post01 = new Post();
            post01.setTitle("Post 01");
            post01.setBody("Post 01 body.........");
            post01.setAccount(account01);
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("Post 02");
            post02.setBody("Post 02 body.........");
            post02.setAccount(account02);
            postService.save(post02);
        }
    }
}
