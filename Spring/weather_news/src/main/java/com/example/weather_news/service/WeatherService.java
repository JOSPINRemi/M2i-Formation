package com.example.weather_news.service;

import com.example.weather_news.entity.Weather;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.LocalDateTime;

@Service
public class WeatherService {

    private final Sinks.Many<Weather> sink;

    public WeatherService() {
        sink = Sinks.many().multicast().onBackpressureBuffer();
    }


    public void sendWeather(String location, Float temperature){
        sink.tryEmitNext(
                Weather.builder()
                        .dateTime(LocalDateTime.now())
                        .location(location)
                        .temperature(temperature)
                        .build()
        );
    }

    public Flux<Weather> getFlux() {
        return sink.asFlux();
    }
}
