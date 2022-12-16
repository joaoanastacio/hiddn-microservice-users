package com.hiddn.users.domain.ports;

import com.hiddn.users.domain.entities.User;
import com.hiddn.users.infrastructure.jpa.models.UserModel;

import java.util.UUID;

public interface UserPort {
    UserModel createUser(User user);
    UserModel getUserByKeycloakIdentifier(UUID userKeycloakIdentifier);
    Boolean userExists(UUID userIdentifier);
}
