package com.hiddn.users.infrastructure.jpa.ports;

import com.hiddn.users.domain.entities.User;
import com.hiddn.users.domain.ports.UserPort;
import com.hiddn.users.infrastructure.jpa.models.UserModel;
import com.hiddn.users.infrastructure.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserPortImplementation implements UserPort {

    private UserRepository userRepository;

    public UserPortImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel createUser(User user) {
        UserModel userModel =
                new UserModel(
                        user.getUserFirstName(),
                        user.getUserLastName(),
                        user.getUserPicture(),
                        user.getUserEmail(),
                        user.getUserKeycloakIdentifier(),
                        new HashSet<>(),
                        new HashSet<>());

        return userRepository.save(userModel);
    }

    @Override
    public UserModel getUserByKeycloakIdentifier(UUID userKeycloakIdentifier) {
        List<UserModel> users = userRepository.findAll();

        for (UserModel user : users) {
            if(user.getUserKeycloakIdentifier().compareTo(userKeycloakIdentifier) == 0) {
                return user;
            }
        }
        return null;
    }

    @Override
    public Boolean userExists(UUID userIdentifier) {
        List<Optional<UserModel>> user =
                Collections.singletonList(userRepository.findByUserKeycloakIdentifier(userIdentifier));

        if(user.get(0).isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
