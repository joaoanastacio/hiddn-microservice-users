package com.hiddn.users.infrastructure.jpa.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_CHAT")
@ApiModel(value = "ChatModel", description = "Model who represents a chat entity")
public class ChatModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chat_identifier")
    @ApiModelProperty(value = "Chat's identifier")
    private UUID chatIdentifier;

    @Column(name = "chat_name")
    @ApiModelProperty(value = "Chat's name", required = true)
    private String chatName;

    @Column(name = "chat_photo_url")
    @ApiModelProperty(value = "Chat's picture path", required = true)
    private String chatPicture;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, mappedBy = "userChats")
    private Set<UserModel> chatUsers;

    @Column(name = "chat_created_date")
    @ApiModelProperty(value = "Chat's creation date", required = true)
    private LocalDateTime chatCreatedDate;

    @Column(name = "chat_updated_date")
    @ApiModelProperty(value = "Chat's change date")
    private LocalDateTime chatUpdatedDate;

    public ChatModel(String chatName, String chatPicture, Set<UserModel> chatUsers) {
        this.chatName = chatName;
        this.chatPicture = chatPicture;
        this.chatUsers = chatUsers;
        this.chatCreatedDate = LocalDateTime.now();
        this.chatUpdatedDate = LocalDateTime.now();
    }
}
