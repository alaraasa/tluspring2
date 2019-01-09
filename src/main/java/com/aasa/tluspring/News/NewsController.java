package com.aasa.tluspring.News;

import com.aasa.tluspring.Comments.CommentService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.apache.logging.log4j.util.LambdaUtil.getAll;

@RestController
@RequestMapping(value = "/news")
public class NewsController {
    private final Gson gson = new Gson();
    private final NewsService newsService;
    private final CommentService commentService;

    @Autowired
    public NewsController(NewsService newsService, CommentService commentService) {
        this.newsService = newsService;
        this.commentService = commentService;
    }

    @GetMapping(produces = "application/json")
    public String getAllNews() {
        return gson.toJson(newsService.getAll());
    }

    @GetMapping(value = "/single", produces = "application/json")
    public String getSingleNews(long id) {
        return gson.toJson(newsService.findById(id));
    }

    @GetMapping(value = "/initialize")
    public String createMockData() {
        Long newsId1 = newsService.createNews("News one", "Content one");
        Long newsId2 = newsService.createNews("News two", "Content two");
        Long newsId3 = newsService.createNews("News three", "Content three");

        Long news1Comment1 = commentService.createNewComment("User1", "Comment one-1", newsService.findById(newsId1));
        Long news1Comment2 = commentService.createNewComment("User12", "Comment one-2", newsService.findById(newsId1));
        Long news1Comment3 = commentService.createNewComment("User13", "Comment one-3", newsService.findById(newsId1));
        Long news1Comment4 = commentService.createNewComment("User14", "Comment one-4", newsService.findById(newsId1));

        Long news2Comment1 = commentService.createNewComment("User2", "Comment two-1", newsService.findById(newsId2));
        Long news2Comment2 = commentService.createNewComment("User22", "Comment two-2", newsService.findById(newsId2));
        Long news2Comment3 = commentService.createNewComment("User23", "Comment two-3", newsService.findById(newsId2));

        Long news3Comment1 = commentService.createNewComment("User3", "Comment three-1", newsService.findById(newsId3));
        Long news3Comment2 = commentService.createNewComment("User32", "Comment three-2", newsService.findById(newsId3));
        return "Initialized.";
    }
}
