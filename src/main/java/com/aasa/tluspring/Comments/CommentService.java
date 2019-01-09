package com.aasa.tluspring.Comments;

import com.aasa.tluspring.News.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class CommentService {

    private final CommentDAO commentDAO;

    @Autowired
    public CommentService(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    public LinkedList<Comment> getAllComments(News news) {
        Iterable<Comment> allComments = commentDAO.findAll();
        Iterator<Comment> allCommentsIterator = allComments.iterator();
        LinkedList<Comment> requiredComments = new LinkedList<>();
        while (allCommentsIterator.hasNext()) {
            Comment currentComment = allCommentsIterator.next();
            if (currentComment.getNews().getId().equals(news.getId())) {
                requiredComments.add(currentComment);
            }
        }
        return requiredComments;
    }

    public Long createNewComment(String user, String content, News news) {
        Comment comment = new Comment();
        comment.setName(user);
        comment.setContent(content);
        comment.setNews(news);
        commentDAO.save(comment);
        return comment.getId();
    }
}
