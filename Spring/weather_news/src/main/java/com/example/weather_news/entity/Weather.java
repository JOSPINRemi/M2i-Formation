package com.example.weather_news.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Weather {
    private LocalDateTime dateTime;
    private String location;
    private Float temperature;
}
