package com.aasa.tluspring.News;

import com.aasa.tluspring.Comments.CommentService;
import com.aasa.tluspring.Time.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Service
public class NewsService {
    private NewsDAO newsDAO;
    private CommentService commentService;
    private TimeService timeService;

    @Autowired
    public NewsService(NewsDAO newsDAO, CommentService commentService, TimeService timeService) {
        this.newsDAO = newsDAO;
        this.commentService = commentService;
        this.timeService = timeService;
    }

    public Iterable<News> getAll() {
        return newsDAO.findAll();
    }

    public Long createNews(String title, String content) {
        News news = new News();
        news.setTitle(title);
        news.setContent(content);
        news.setTime(timeService.getTime());
        newsDAO.save(news);
        return news.getId();
    }

    public News findById(Long id) {
        for (News news : newsDAO.findAll()) {
            if (news.getId().equals(id)) return news;
        }
        return null;
    }
}
