package com.example.weather_news.controller;

import com.example.weather_news.entity.News;
import com.example.weather_news.model.NewsDto;
import com.example.weather_news.service.NewsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    public void post(@RequestBody NewsDto newsDto) {
        newsService.sendNews(newsDto.getTitle(), newsDto.getContent());
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<News> get() {
        return newsService.getFlux();
    }
}
