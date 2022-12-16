package com.hiddn.users.domain.viewobjects;

import java.util.Set;
import java.util.UUID;

public class ChatVO {

    private String chatName;
    private String chatPicture;
    private Set<UUID> chatUsersIdentifiers;

    public ChatVO(String chatName, String chatPicture, Set<UUID> chatUsers) {
        this.chatName = chatName;
        this.chatPicture = chatPicture;
        this.chatUsersIdentifiers = chatUsers;
    }

    public String getChatName() {
        return chatName;
    }

    public String getChatPicture() {
        return chatPicture;
    }

    public Set<UUID> getChatUsersIdentifiers() {
        return chatUsersIdentifiers;
    }
}
