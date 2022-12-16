package com.hiddn.users.domain.entities;

import com.hiddn.users.domain.exceptions.IncorrectUserNameException;
import com.hiddn.users.domain.exceptions.NotValidEmailException;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.List;
import java.util.UUID;

public class User {

    private String userFirstName;
    private String userLastName;
    private String userPicture;
    private String userEmail;
    private UUID userKeycloakIdentifier;
    private List<User> userFriends;

    public User(String userFirstName, String userLastName, String userPicture, String userEmail, UUID userKeycloakIdentifier)
            throws IncorrectUserNameException, NotValidEmailException {
        setUserFirstName(userFirstName);
        setUserLastName(userLastName);
        setUserPicture(userPicture);
        setUserEmail(userEmail);
        setUserKeycloakIdentifier(userKeycloakIdentifier);
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) throws IncorrectUserNameException {
        if(userFirstName.isEmpty() || userFirstName.isBlank()) {
            throw new IncorrectUserNameException("First name cannot be empty or blank");
        } else {
            this.userFirstName = userFirstName;
        }
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) throws IncorrectUserNameException {
        if(userLastName.isEmpty() || userLastName.isBlank()) {
            throw new IncorrectUserNameException("Last name cannot be empty or blank");
        } else {
            this.userLastName = userLastName;
        }
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        if (userPicture.isEmpty() || userPicture.isBlank()) {
            this.userPicture = "https://picsum.photos/50";
        } else {
            this.userPicture = userPicture;
        }
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) throws NotValidEmailException {
        EmailValidator emailValidator = EmailValidator.getInstance();

        if(!emailValidator.isValid(userEmail)) {
            throw new NotValidEmailException("Email must be valid");
        } else {
            this.userEmail = userEmail;
        }
    }

    public UUID getUserKeycloakIdentifier() {
        return userKeycloakIdentifier;
    }

    public void setUserKeycloakIdentifier(UUID userKeycloakIdentifier) {
        this.userKeycloakIdentifier = userKeycloakIdentifier;
    }

    public List<User> getUserFriends() {
        return userFriends;
    }

    public void setUserFriends(List<User> userFriends) {
        if(!userFriends.isEmpty()) {
            this.userFriends = userFriends;
        }
    }
}
