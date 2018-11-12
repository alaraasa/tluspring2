package com.aasa.tluspring.LetterPairs;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@Data
class LetterPair {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id", table="Text")
    private Long textId;
    @Column(name = "pair")
    private String pair;
    @Column(name = "amount")
    private Integer amount;
}
