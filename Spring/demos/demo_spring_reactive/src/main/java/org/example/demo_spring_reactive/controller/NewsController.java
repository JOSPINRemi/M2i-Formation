package org.example.demo_spring_reactive.controller;

import org.example.demo_spring_reactive.service.NewsService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("add/{news}")
    public ResponseEntity<String> addNews(@PathVariable String news) {
        this.newsService.sendNews(news);
        return ResponseEntity.ok("Ok");
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> get() {
        return newsService.getFlux();
    }
}
