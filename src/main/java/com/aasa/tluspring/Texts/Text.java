package com.aasa.tluspring.Texts;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Text")
@Data
public class Text {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, length = 8000)
    private String text;
}
