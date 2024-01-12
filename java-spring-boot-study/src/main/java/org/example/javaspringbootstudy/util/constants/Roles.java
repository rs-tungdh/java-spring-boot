package org.example.javaspringbootstudy.util.constants;

import lombok.Getter;

@Getter
public enum Roles {
    USER("ROLE_USER"),ADMIN("ROLE_ADMIN"),EDITOR("ROLE_EDITOR");

    private final String role;
    private Roles(String role) {
        this.role = role;
    }
}
