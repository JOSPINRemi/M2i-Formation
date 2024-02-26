package com.example.weather_news.controller;

import com.example.weather_news.service.WeatherNewsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("weather-and-news")
public class WeatherNewsController {

    private final WeatherNewsService weatherNewsService;

    public WeatherNewsController(WeatherNewsService weatherNewsService) {
        this.weatherNewsService = weatherNewsService;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Object> get() {
        return weatherNewsService.getFlux();
    }
}
