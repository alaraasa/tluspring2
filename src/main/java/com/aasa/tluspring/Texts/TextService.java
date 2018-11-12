package com.aasa.tluspring.Texts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextService {
    private TextDAO textDAO;
    @Autowired
    public TextService(TextDAO textDAO) {
        this.textDAO = textDAO;
    }

    public Long createNewText(String text) {
        Text newText = new Text();
        newText.setText(text);
        textDAO.save(newText);
        return newText.getId();
    }

    public Iterable<Text> getAllTexts() {
        return textDAO.findAll();
    }
}
