package com.example.weather_news.controller;

import com.example.weather_news.entity.Weather;
import com.example.weather_news.model.WeatherDto;
import com.example.weather_news.service.WeatherService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping
    public void post(@RequestBody WeatherDto weatherDto) {
        weatherService.sendWeather(weatherDto.getLocation(), weatherDto.getTemperature());
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Weather> get() {
        return weatherService.getFlux();
    }
}
