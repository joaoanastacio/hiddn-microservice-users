package com.hiddn.users.domain.adapters;

import com.hiddn.users.domain.exceptions.IncorrectUserNameException;
import com.hiddn.users.domain.exceptions.NotValidEmailException;
import com.hiddn.users.domain.viewobjects.UserVO;
import com.hiddn.users.infrastructure.jpa.models.UserModel;

import java.util.UUID;

public interface UserAdapter {
    UserModel createUser(UserVO user) throws NotValidEmailException, IncorrectUserNameException;
    UserModel getUserByKeycloakIdentifier(UUID userKeycloakIdentifier);
    Boolean userExists(UUID userIdentifier);
}
