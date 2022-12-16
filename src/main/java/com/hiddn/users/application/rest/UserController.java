package com.hiddn.users.application.rest;

import com.hiddn.users.domain.adapters.UserAdapter;
import com.hiddn.users.domain.exceptions.IncorrectUserNameException;
import com.hiddn.users.domain.exceptions.NotValidEmailException;
import com.hiddn.users.domain.viewobjects.UserVO;
import com.hiddn.users.infrastructure.jpa.models.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/user")
@Api(tags = "Controller responsible to manage all user operations")
public class UserController {

    private UserAdapter userAdapter;

    public UserController(UserAdapter userAdapter) {
        this.userAdapter = userAdapter;
    }

    @PostMapping
    @ApiOperation(value = "Create a new user")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "User successfully created"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            }
    )
    public ResponseEntity<UserModel> createUser(@RequestBody UserVO user) throws NotValidEmailException, IncorrectUserNameException {
        UserModel createdUser = userAdapter.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping(path = "/keycloak/{keycloakIdentifier}")
    @ApiOperation(value = "Get user by Keycloak identifier")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "User successfully found"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            }
    )
    public ResponseEntity<UserModel> getUserByKeycloakIdentifier(@PathVariable UUID keycloakIdentifier) {
        UserModel foundUser = userAdapter.getUserByKeycloakIdentifier(keycloakIdentifier);
        return ResponseEntity.status(HttpStatus.FOUND).body(foundUser);
    }

    @GetMapping(path = "/{userIdentifier}")
    @ApiOperation(value = "Check if user already exists")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "User already exists"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            }
    )
    public ResponseEntity<Boolean> userExists(@PathVariable UUID userIdentifier) {
        return ResponseEntity.status(HttpStatus.OK).body(userAdapter.userExists(userIdentifier));
    }
}
