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
@Table(name = "TB_PROFILE")
@ApiModel(value = "User Model", description = "Model who represents an user entity")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_identifier")
    @ApiModelProperty(value = "User's identifier")
    private UUID userIdentifier;

    @Column(name = "profile_firstname")
    @ApiModelProperty(value = "User's first name", required = true)
    private String userFirstName;

    @Column(name = "profile_lastname")
    @ApiModelProperty(value = "User's last name", required = true)
    private String userLastName;

    @Column(name = "profile_photo_url")
    @ApiModelProperty(value = "User's picture path", required = true)
    private String userPicture;

    @Column(name = "profile_email")
    @ApiModelProperty(value = "User's email", required = true)
    private String userEmail;

    @Column(name = "profile_keycloak_identifier")
    @ApiModelProperty(value = "User's identifier on Keycloak Authentication Server")
    private UUID userKeycloakIdentifier;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "TB_PROFILE_FOLLOWER",
               joinColumns = {@JoinColumn(name = "profile_identifier")},
               inverseJoinColumns = {@JoinColumn(name = "follower_identifier")})
    private Set<UserModel> userFriends;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "TB_PROFILE_CHAT",
            joinColumns = {@JoinColumn(name = "profile_identifier")},
            inverseJoinColumns = {@JoinColumn(name = "chat_identifier")})
    private Set<ChatModel> userChats;

    @Column(name = "profile_created_date")
    @ApiModelProperty(value = "User's creation date", required = true)
    private LocalDateTime userCreatedDate;

    @Column(name = "profile_updated_date")
    @ApiModelProperty(value = "User's change date")
    private LocalDateTime userUpdatedDate;

    public UserModel(String userFirstName,
                     String userLastName,
                     String userPicture,
                     String userEmail,
                     UUID userKeycloakIdentifier,
                     Set<ChatModel> userChats,
                     Set<UserModel> userFriends) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPicture = userPicture;
        this.userEmail = userEmail;
        this.userKeycloakIdentifier = userKeycloakIdentifier;
        this.userChats = userChats;
        this.userFriends = userFriends;
        this.userCreatedDate = LocalDateTime.now();
        this.userUpdatedDate = LocalDateTime.now();
    }
}
