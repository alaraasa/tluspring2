package com.aasa.tluspring.LetterPairs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/lepa")
public class LetterPairsController {
    @PostMapping(produces = "application/json")
    String parseString (String text) {
        LetterPairs letterPairs = new LetterPairs();
        letterPairs.setOriginalText(text);
        letterPairs.parseText();
        return letterPairs.getPairs();

    }
}
