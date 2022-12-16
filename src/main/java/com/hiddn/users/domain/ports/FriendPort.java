package com.hiddn.users.domain.ports;

import com.hiddn.users.infrastructure.jpa.models.UserModel;

import java.util.Set;
import java.util.UUID;

public interface FriendPort {
    UserModel addFriend(UUID userIdentifier, UUID friendIdentifier);
    Set<UserModel> getAllFriend(UUID userIdentifier);
    Set<UserModel> getAllFriendWithEmailLike(UUID userIdentifier, String email);
    UserModel deleteFriend(UUID userIdentifier, UUID friendIdentifier);
}
