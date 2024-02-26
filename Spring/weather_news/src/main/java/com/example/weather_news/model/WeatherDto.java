package com.example.weather_news.model;

import lombok.Data;

@Data
public class WeatherDto {
    private String location;
    private Float temperature;
}
