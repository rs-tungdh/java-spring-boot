package org.example.javaspringbootstudy.util.constants;

import lombok.Getter;

@Getter
public enum Privillages {
    RESET_ANY_USER_PASSWORD(1l, "RESET_ANY_USER_PASSWORD"),
    ACCESS_ADMIN_PANEL(2l, "ACCESS_ADMIN_PANEL");

    private final Long id;
    private final String privillage;
    private Privillages(Long id, String privillage) {
        this.id = id;
        this.privillage = privillage;
    }
}
