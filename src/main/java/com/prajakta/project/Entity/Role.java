package com.prajakta.project.Entity;

import lombok.Getter;

import java.util.Set;

import static com.prajakta.project.Entity.Permissions.*;
@Getter
public enum Role {
    ROLE_USER(Set.of(TASK_UPDATE, TASK_VIEW)),
    ROLE_ADMIN(Set.of(TASK_CREATE, TASK_UPDATE, TASK_VIEW, TASK_DELETE));

    private final Set<com.prajakta.project.Entity.Permissions> permissions;

    Role(Set<Permissions> permissions){
        this.permissions = permissions;
    }


}
