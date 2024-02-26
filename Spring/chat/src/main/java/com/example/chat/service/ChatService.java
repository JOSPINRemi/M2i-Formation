package com.example.chat.service;

import com.example.chat.entity.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.LocalDateTime;

@Service
public class ChatService {

    private final Sinks.Many<Message> sink;

    public ChatService() {
        sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void sendMessage(String author, String content) {
        Message message = Message.builder()
                .dateTime(LocalDateTime.now())
                .author(author)
                .content(content)
                .build();
        sink.tryEmitNext(message);
    }

    public Flux<Message> getMessagesFlux() {
        return sink.asFlux();
    }
}
