package com.hiddn.users.infrastructure.jpa.repositories;

import com.hiddn.users.infrastructure.jpa.models.ChatModel;
import com.hiddn.users.infrastructure.jpa.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface ChatRepository extends JpaRepository<ChatModel, UUID> {
    List<ChatModel> findAllByChatUsersIn(Set<UserModel> chatUsers);
}
