package com.hiddn.users.infrastructure.jpa.adapters;

import com.hiddn.users.domain.adapters.ChatAdapter;
import com.hiddn.users.domain.entities.Chat;
import com.hiddn.users.domain.exceptions.IncorrectChatNameException;
import com.hiddn.users.domain.ports.ChatPort;
import com.hiddn.users.domain.viewobjects.ChatVO;
import com.hiddn.users.infrastructure.jpa.models.ChatModel;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class ChatAdapterImplementation implements ChatAdapter {

    private ChatPort chatPort;

    public ChatAdapterImplementation(ChatPort chatPort) {
        this.chatPort = chatPort;
    }

    @Override
    public ChatModel createChat(ChatVO chat) throws IncorrectChatNameException {
        return chatPort.createChat(new Chat(chat.getChatName(), chat.getChatPicture(), chat.getChatUsersIdentifiers()));
    }

    @Override
    public Set<ChatModel> getAllChatFromUser(UUID userIdentifier) {
        return chatPort.getAllChatFromUser(userIdentifier);
    }
}
