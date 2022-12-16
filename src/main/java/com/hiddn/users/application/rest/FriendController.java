package com.hiddn.users.application.rest;

import com.hiddn.users.domain.adapters.FriendAdapter;
import com.hiddn.users.infrastructure.jpa.models.UserModel;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/friend")
@Api(tags = "Controller responsible to manage all operations between an user and friends")
public class FriendController {

    private FriendAdapter friendAdapter;

    public FriendController(FriendAdapter friendAdapter) {
        this.friendAdapter = friendAdapter;
    }

    @PostMapping(path = "/{userIdentifier}/{friendIdentifier}")
    @ApiOperation(value = "Add a new friend")
    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Added friend object returned"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Something went wrong")
        }
    )
    public ResponseEntity<UserModel> addFriend(@PathVariable UUID userIdentifier,
                                               @PathVariable UUID friendIdentifier) {
        UserModel addedFriend = friendAdapter.addFriend(userIdentifier, friendIdentifier);
        return ResponseEntity.status(HttpStatus.OK).body(addedFriend);
    }

    @GetMapping(path = "/{userIdentifier}")
    @ApiOperation(value = "Get all friends from an user")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "List of friends"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            }
    )
    public ResponseEntity<Set<UserModel>> getAllFriend(@PathVariable UUID userIdentifier) {
        Set<UserModel> userFriends = friendAdapter.getAllFriend(userIdentifier);
        return ResponseEntity.status(HttpStatus.OK).body(userFriends);
    }

    @GetMapping(value = "/filter/{userIdentifier}")
    @ApiOperation(value = "Get all friends by similar email")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "List of friends"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            }
    )
    public ResponseEntity<Set<UserModel>> getAllFriendWithEmailLike(@PathVariable UUID userIdentifier,
                                                                    @RequestParam String baseEmail) {
        Set<UserModel> userFriends = friendAdapter.getAllFriendWithEmailLike(userIdentifier, baseEmail);
        return ResponseEntity.status(HttpStatus.OK).body(userFriends);
    }

    @DeleteMapping(path = "/{userIdentifier}/{friendIdentifier}")
    @ApiOperation(value = "Delete a friend")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Deleted friend object returned"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            }
    )
    public ResponseEntity<UserModel> deleteFriend(@PathVariable UUID userIdentifier,
                                                  @PathVariable UUID friendIdentifier) {
        UserModel deletedFriend = friendAdapter.deleteFriend(userIdentifier, friendIdentifier);
        return ResponseEntity.status(HttpStatus.OK).body(deletedFriend);
    }
}
