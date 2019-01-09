package com.aasa.tluspring.Comments;

import com.aasa.tluspring.News.News;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Comment")
@Data
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private News news;

    @Column
    private String name;

    @Column
    private String content;
}
