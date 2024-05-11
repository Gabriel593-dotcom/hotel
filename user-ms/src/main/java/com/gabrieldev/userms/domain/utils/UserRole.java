package com.gabrieldev.userms.domain.utils;

import com.gabrieldev.userms.domain.exception.RoleDoesNotExistsException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {

    ADMIN ("ADMIN"),
    USER ("USER");

    private String roleName;

    public static String findRoleName(String roleName) {
        for (UserRole ur : UserRole.values()) {
            if (ur.roleName.equalsIgnoreCase(roleName))
                return ur.getRoleName();
        }

        throw new RoleDoesNotExistsException("Role " + roleName + " does not exists.");
    }
}
