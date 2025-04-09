package com.hsk.restapi.HSKSite.data.enumSet;

import lombok.Getter;

@Getter
public enum UserType {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String role;
    UserType(String role) {
        this.role = role;
    }
}
