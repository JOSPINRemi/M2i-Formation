package com.example.weather_news.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class News {
    private LocalDateTime dateTime;
    private String title;
    private String content;
}
