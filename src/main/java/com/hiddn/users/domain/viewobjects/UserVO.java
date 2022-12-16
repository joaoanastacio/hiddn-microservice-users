package com.hiddn.users.domain.viewobjects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UserVO {

    @JsonProperty(value = "userFirstName")
    private String userFirstName;

    @JsonProperty(value = "userLastName")
    private String userLastName;

    @JsonProperty(value = "userPicture")
    private String userPicture;

    @JsonProperty(value = "userEmail")
    private String userEmail;

    @JsonProperty(value = "userKeycloakIdentifier")
    private UUID userKeycloakIdentifier;

    public UserVO() {}

    public UserVO(String userFirstName, String userLastName, String userPicture, String userEmail,
                  UUID userKeycloakIdentifier) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPicture = userPicture;
        this.userEmail = userEmail;
        this.userKeycloakIdentifier = userKeycloakIdentifier;
    }

    public String getUserFistName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public UUID getUserKeycloakIdentifier() {
        return userKeycloakIdentifier;
    }
}
