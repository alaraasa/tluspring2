package com.aasa.tluspring.Comments;

import com.aasa.tluspring.News.News;
import com.aasa.tluspring.News.NewsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {
    private final Gson gson = new Gson();
    private final CommentService commentService;
    private final NewsService newsService;

    @Autowired
    public CommentController(CommentService commentService, NewsService newsService) {
        this.commentService = commentService;
        this.newsService = newsService;
    }

    @GetMapping(produces = "application/json")
    public String getCommentsByNewsId(Long id) {
        News newsOfComments = newsService.findById(id);
        Iterable<Comment> allComments = commentService.getAllComments(newsOfComments);
        return gson.toJson(allComments);
    }

}
