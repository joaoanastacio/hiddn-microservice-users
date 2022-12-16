package com.hiddn.users.domain.ports;

import com.hiddn.users.domain.entities.Chat;
import com.hiddn.users.infrastructure.jpa.models.ChatModel;

import java.util.Set;
import java.util.UUID;

public interface ChatPort {
    ChatModel createChat(Chat chat);
    Set<ChatModel> getAllChatFromUser(UUID userIdentifier);
}
