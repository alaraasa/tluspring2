package com.aasa.tluspring.LetterPairs;

import com.aasa.tluspring.Texts.Text;
import com.aasa.tluspring.Texts.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LetterPairService {

    private final LetterPairDAO letterPairDAO;
    private TextService textService;

    @Autowired
    public LetterPairService(LetterPairDAO letterPairDAO, TextService textService) {
        this.letterPairDAO = letterPairDAO;
        this.textService = textService;
    }

    private List<LetterPair> getAll() {
        return (List<LetterPair>) letterPairDAO.findAll();
    }

    public List<LetterPair> getById(Long id) {
        List<LetterPair> letterPairs = getAll();
        letterPairs = letterPairs
                .stream()
                .filter(letterPair -> letterPair.getText().getId().equals(id))
                .collect(Collectors.toList());
        return letterPairs;
    }

    public Long addPair(String pair, Integer size, Long textId) {
        LetterPair letterPair = new LetterPair();
        letterPair.setPair(pair);
        letterPair.setAmount(size);
        Text text = textService.getById(textId);
        letterPair.setText(text);
        letterPairDAO.save(letterPair);
        return letterPair.getId();
    }
}
