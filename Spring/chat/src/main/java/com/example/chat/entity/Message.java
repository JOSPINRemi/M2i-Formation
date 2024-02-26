package com.example.chat.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Message {
    private LocalDateTime dateTime;
    private String author;
    private String content;
}
