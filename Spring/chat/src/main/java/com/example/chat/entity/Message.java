package com.example.chat.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Data
@Builder
public class Message {
    @Id
    private int id;
    private LocalDateTime dateTime;
    private String author;
    private String content;
}
