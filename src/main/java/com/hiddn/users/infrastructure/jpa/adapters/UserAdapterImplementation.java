package com.hiddn.users.infrastructure.jpa.adapters;

import com.hiddn.users.domain.adapters.UserAdapter;
import com.hiddn.users.domain.entities.User;
import com.hiddn.users.domain.exceptions.IncorrectUserNameException;
import com.hiddn.users.domain.exceptions.NotValidEmailException;
import com.hiddn.users.domain.ports.UserPort;
import com.hiddn.users.domain.viewobjects.UserVO;
import com.hiddn.users.infrastructure.jpa.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserAdapterImplementation implements UserAdapter {

    private UserPort userPort;

    public UserAdapterImplementation(UserPort userPort) {
        this.userPort = userPort;
    }

    @Override
    public UserModel createUser(UserVO user) throws NotValidEmailException, IncorrectUserNameException {
        return userPort.createUser(new User(user.getUserFistName(),
                                            user.getUserLastName(),
                                            user.getUserPicture(),
                                            user.getUserEmail(),
                                            user.getUserKeycloakIdentifier()));
    }

    @Override
    public UserModel getUserByKeycloakIdentifier(UUID userKeycloakIdentifier) {
        return userPort.getUserByKeycloakIdentifier(userKeycloakIdentifier);
    }

    @Override
    public Boolean userExists(UUID userIdentifier) {
        return userPort.userExists(userIdentifier);
    }
}
