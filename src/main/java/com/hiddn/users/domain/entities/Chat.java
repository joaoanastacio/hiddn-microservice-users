package com.hiddn.users.domain.entities;

import com.hiddn.users.domain.exceptions.IncorrectChatNameException;
import com.hiddn.users.domain.exceptions.IncorrectUserNameException;
import com.hiddn.users.domain.exceptions.NotValidEmailException;
import java.util.Set;
import java.util.UUID;

public class Chat {

    private String chatName;
    private String chatPicture;
    private Set<UUID> chatUsersIdentifiers;

    private Chat() {}

    public Chat(String chatName, String chatPicture, Set<UUID> chatUsersIdentifiers) throws IncorrectChatNameException {
        setChatName(chatName);
        setChatPicture(chatPicture);
        setChatUsers(chatUsersIdentifiers);
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) throws IncorrectChatNameException {
        if(chatName.isEmpty() || chatName.isBlank()) {
            throw new IncorrectChatNameException("Chat name cannot be empty or blank");
        } else {
            this.chatName = chatName;
        }
    }

    public String getChatPicture() {
        return chatPicture;
    }

    public void setChatPicture(String chatPicture) {
        if(chatPicture.isEmpty() || chatPicture.isBlank()) {
            this.chatPicture = "https://picsum.photos/50";
        } else {
            this.chatPicture = chatPicture;
        }
    }

    public Set<UUID> getChatUsers() {
        return chatUsersIdentifiers;
    }

    public void setChatUsers(Set<UUID> chatUsersIdentifiers) {
        this.chatUsersIdentifiers = chatUsersIdentifiers;
    }
}
