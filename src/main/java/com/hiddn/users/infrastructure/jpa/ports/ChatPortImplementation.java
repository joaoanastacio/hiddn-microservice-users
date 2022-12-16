package com.hiddn.users.infrastructure.jpa.ports;

import com.hiddn.users.domain.entities.Chat;
import com.hiddn.users.domain.ports.ChatPort;
import com.hiddn.users.infrastructure.jpa.models.ChatModel;
import com.hiddn.users.infrastructure.jpa.models.UserModel;
import com.hiddn.users.infrastructure.jpa.repositories.ChatRepository;
import com.hiddn.users.infrastructure.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ChatPortImplementation implements ChatPort {

    private ChatRepository chatRepository;
    private UserRepository userRepository;

    public ChatPortImplementation(ChatRepository chatRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ChatModel createChat(Chat chat) {
        Set<UserModel> chatUsers =
                chat.getChatUsers()
                        .stream()
                        .map(userIdentifier -> userRepository.findById(userIdentifier).get())
                        .collect(Collectors.toSet());

        ChatModel chatModel = new ChatModel(chat.getChatName(), chat.getChatPicture(), chatUsers);
        return chatRepository.saveAndFlush(chatModel);
    }

    @Override
    public Set<ChatModel> getAllChatFromUser(UUID userIdentifier) {
        UserModel user = userRepository.findById(userIdentifier).get();
        Set<UserModel> targetUser = new HashSet<>();
        targetUser.add(user);
        // Repository not working
        return new HashSet<>(chatRepository.findAllByChatUsersIn(targetUser));
    }
}
