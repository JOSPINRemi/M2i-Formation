package com.example.weather_news.service;

import com.example.weather_news.entity.News;
import com.example.weather_news.entity.Weather;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class WeatherNewsService {
    private final WebClient webClient;

    public WeatherNewsService() {
        webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
    }

    public Flux<Object> getFlux() {
        Flux<Weather> weatherFlux = webClient.get().uri("weather")
                .retrieve()
                .bodyToFlux(Weather.class);

        Flux<News> newsFlux = webClient.get().uri("news")
                .retrieve()
                .bodyToFlux(News.class);

        return Flux.zip(weatherFlux, newsFlux).map(t -> t.getT1() + " " + t.getT2());
    }
}
