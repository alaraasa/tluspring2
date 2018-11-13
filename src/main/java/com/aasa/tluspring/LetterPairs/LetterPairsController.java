package com.aasa.tluspring.LetterPairs;

import com.aasa.tluspring.Texts.TextService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/lepa")
public class LetterPairsController {
    private final TextService textService;
    private final LetterPairService letterPairService;
    private final LetterPairUtils letterPairUtils = new LetterPairUtils();
    private final Gson gson = new Gson();
    @Autowired
    public LetterPairsController(TextService textService, LetterPairService letterPairService) {
        this.textService = textService;
        this.letterPairService = letterPairService;
    }

    @GetMapping(produces = "application/json")
    String getByTextId(Long id) {
        List<LetterPair> letterPairs = letterPairService.getById(id);
        return gson.toJson(letterPairs);
    }

    @PostMapping(produces = "application/json")
    String newTextAndPairs (String text) {
        Long textId = textService.createNewText(text);
        letterPairUtils.setOriginalText(text);
        letterPairUtils.parseText();
        HashMap<String, Integer> pairs = letterPairUtils.sortByValues();
        pairs.forEach((pair, amount) -> letterPairService.addPair(pair, amount, textId));
        return getByTextId(textId);
    }
}
