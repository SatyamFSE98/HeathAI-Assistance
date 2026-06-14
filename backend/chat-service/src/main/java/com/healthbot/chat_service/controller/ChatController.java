package com.healthbot.chat_service.controller;


import com.healthbot.chat_service.dto.AskQuestionRequest;
import com.healthbot.chat_service.dto.ChatResponse;
import com.healthbot.chat_service.service.ChatService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
@CrossOrigin(origins = "http://localhost:4200")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/ask")
    public ResponseEntity<ChatResponse> askQuestion(@Valid @RequestBody AskQuestionRequest request){
        ChatResponse response = chatService.askQuestion(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ChatResponse>> getChatHistory(@PathVariable long userId){
        List<ChatResponse> responses = chatService.getChatHistory(userId);
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/user/{userId}")
    public String deleteChatHistory(@PathVariable Long userId) {
        chatService.deleteChatHistory(userId);
        return "Chat history deleted successfully";
    }

}
