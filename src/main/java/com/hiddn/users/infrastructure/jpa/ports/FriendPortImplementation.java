package com.hiddn.users.infrastructure.jpa.ports;

import com.hiddn.users.domain.ports.FriendPort;
import com.hiddn.users.infrastructure.jpa.models.UserModel;
import com.hiddn.users.infrastructure.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FriendPortImplementation implements FriendPort {

    private UserRepository userRepository;

    public FriendPortImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel addFriend(UUID userIdentifier, UUID friendIdentifier) {
        UserModel user = userRepository.findById(userIdentifier).get();
        UserModel friend = userRepository.findById(friendIdentifier).get();
        user.getUserFriends().add(friend);
        userRepository.save(user);
        return friend;
    }

    @Override
    public Set<UserModel> getAllFriend(UUID userIdentifier) {
        UserModel user = userRepository.findById(userIdentifier).get();
        return user.getUserFriends();
    }

    @Override
    public Set<UserModel> getAllFriendWithEmailLike(UUID userIdentifier, String email) {
        UserModel user = userRepository.findById(userIdentifier).get();
        return user.getUserFriends()
                .stream()
                .filter(friend -> friend.getUserEmail().contains(email))
                .collect(Collectors.toSet());
    }

    @Override
    public UserModel deleteFriend(UUID userIdentifier, UUID friendIdentifier) {
        UserModel user = userRepository.findById(userIdentifier).get();
        UserModel friend = userRepository.findById(friendIdentifier).get();
        user.getUserFriends().remove(friend);
        userRepository.save(user);
        return friend;
    }
}
