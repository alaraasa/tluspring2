package com.aasa.tluspring.Texts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public Text getById(Long id) {
        List<Text> allTexts = (List<Text>) getAllTexts();
        allTexts = allTexts
                .stream()
                .filter(text -> text.getId().equals(id))
                .collect(Collectors.toList());
        if (allTexts.size() > 1) System.out.println("MORE THAN ONE TEXT FOUND WITH ID " + id);
        return allTexts.get(0);
    }
}
