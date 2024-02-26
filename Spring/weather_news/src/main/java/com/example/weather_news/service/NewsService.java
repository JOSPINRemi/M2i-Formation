package com.example.weather_news.service;

import com.example.weather_news.entity.News;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.LocalDateTime;

@Service
public class NewsService {

    private final Sinks.Many<News> sink;

    public NewsService() {
        sink = Sinks.many().multicast().onBackpressureBuffer();
    }


    public void sendNews(String title, String content) {
        sink.tryEmitNext(
                News.builder()
                        .dateTime(LocalDateTime.now())
                        .title(title)
                        .content(content)
                        .build()
        );
    }

    public Flux<News> getFlux() {
        return sink.asFlux();
    }
}
