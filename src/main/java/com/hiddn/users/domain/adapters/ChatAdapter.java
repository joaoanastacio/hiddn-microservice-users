package com.hiddn.users.domain.adapters;

import com.hiddn.users.domain.exceptions.IncorrectChatNameException;
import com.hiddn.users.domain.exceptions.IncorrectUserNameException;
import com.hiddn.users.domain.exceptions.NotValidEmailException;
import com.hiddn.users.domain.viewobjects.ChatVO;
import com.hiddn.users.infrastructure.jpa.models.ChatModel;

import java.util.Set;
import java.util.UUID;

public interface ChatAdapter {
    ChatModel createChat(ChatVO chat) throws NotValidEmailException, IncorrectUserNameException, IncorrectChatNameException;
    Set<ChatModel> getAllChatFromUser(UUID userIdentifier);
}
