package com.hiddn.users.application.rest;

import com.hiddn.users.domain.adapters.ChatAdapter;
import com.hiddn.users.domain.exceptions.IncorrectChatNameException;
import com.hiddn.users.domain.exceptions.IncorrectUserNameException;
import com.hiddn.users.domain.exceptions.NotValidEmailException;
import com.hiddn.users.domain.viewobjects.ChatVO;
import com.hiddn.users.infrastructure.jpa.models.ChatModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/chat")
@Api(tags = "Controller responsible to manage all operations between an user and chats")
public class ChatController {

    private ChatAdapter chatAdapter;

    public ChatController(ChatAdapter chatAdapter) {
        this.chatAdapter = chatAdapter;
    }

    @PostMapping
    @ApiOperation(value = "Create a new chat")
    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Chat successfully created"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Something went wrong")
        }
    )
    public ResponseEntity<ChatModel> createChat(@RequestBody ChatVO chat)
            throws NotValidEmailException, IncorrectUserNameException, IncorrectChatNameException {
        ChatModel createdChat = chatAdapter.createChat(chat);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdChat);
    }

    @GetMapping(path = "/{userIdentifier}")
    @ApiOperation(value = "Get all chats from an user")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "List of chats"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            }
    )
    public ResponseEntity<Set<ChatModel>> getAllChatFromUser(@PathVariable UUID userIdentifier) {
        Set<ChatModel> userAllChats = chatAdapter.getAllChatFromUser(userIdentifier);
        return ResponseEntity.status(HttpStatus.OK).body(userAllChats);
    }
}
