package com.hiddn.users.infrastructure.jpa.adapters;

import com.hiddn.users.domain.adapters.FriendAdapter;
import com.hiddn.users.domain.ports.FriendPort;
import com.hiddn.users.infrastructure.jpa.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class FriendAdapterImplementation implements FriendAdapter {

    private FriendPort friendPort;

    public FriendAdapterImplementation(FriendPort friendPort) {
        this.friendPort = friendPort;
    }

    @Override
    public UserModel addFriend(UUID userIdentifier, UUID friendIdentifier) {
        return friendPort.addFriend(userIdentifier, friendIdentifier);
    }

    @Override
    public Set<UserModel> getAllFriend(UUID userIdentifier) {
        return friendPort.getAllFriend(userIdentifier);
    }

    @Override
    public Set<UserModel> getAllFriendWithEmailLike(UUID userIdentifier, String email) {
        return friendPort.getAllFriendWithEmailLike(userIdentifier, email);
    }

    @Override
    public UserModel deleteFriend(UUID userIdentifier, UUID friendIdentifier) {
        return friendPort.deleteFriend(userIdentifier, friendIdentifier);
    }
}
