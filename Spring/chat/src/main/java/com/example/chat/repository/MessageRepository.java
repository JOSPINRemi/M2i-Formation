package com.example.chat.repository;

import com.example.chat.entity.Message;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface MessageRepository extends R2dbcRepository<Message, Integer> {
}
