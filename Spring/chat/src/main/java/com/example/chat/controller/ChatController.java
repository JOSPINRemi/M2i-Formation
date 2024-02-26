package com.example.chat.controller;

import com.example.chat.entity.Message;
import com.example.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("add")
    public ResponseEntity<String> addMessage(@RequestBody Message message) {
        this.chatService.sendMessage(message.getAuthor(), message.getContent());
        return ResponseEntity.ok("Message envoyé");
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> getMessagesFlux() {
        return chatService.getMessagesFlux();
    }
}
