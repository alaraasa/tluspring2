package com.aasa.tluspring.LetterPairs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetterPairService {

    private final LetterPairDAO letterPairDAO;

    @Autowired
    public LetterPairService(LetterPairDAO letterPairDAO) {
        this.letterPairDAO = letterPairDAO;
    }

    public List<LetterPair> getAll() {
        return (List<LetterPair>) letterPairDAO.findAll();
    }

    public Long addPair(String pair, Integer size, Long textId) {
        LetterPair letterPair = new LetterPair();
        letterPair.setPair(pair);
        letterPair.setAmount(size);
        letterPair.setTextId(textId);
        letterPairDAO.save(letterPair);
        return letterPair.getId();
    }
}
