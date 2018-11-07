package com.aasa.tluspring.LetterPairs;

import com.google.gson.Gson;
import lombok.Data;
import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Data
@Log
class LetterPairs {

    private String originalText;
    private Map<String, Integer> allPairs = new HashMap<>();
    private Integer TOP_N_TO_RETURN = 3;

    void parseText() {
        String[] splitText = originalText.split("[\\p{Punct}\\s]+");
        log.info(originalText);
        Arrays.stream(splitText).forEach(word -> {
            for(int i=0; i < word.length(); i++) {
                if (i <  word.length()-1) {
                    String pair = word.substring(i, i+2);
                    if(allPairs.containsKey(pair)) {
                        allPairs.put(pair, allPairs.get(pair) + 1);
                    } else {
                        allPairs.put(pair, 1);
                    }
                }
            }
        });
    }

    private HashMap<String, Integer> sortByValues() {
        return allPairs.entrySet().stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .limit(TOP_N_TO_RETURN)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    String getPairs() {
        StringBuilder toReturn = new StringBuilder();
        HashMap<String, Integer> sortedResults = sortByValues();
        AtomicInteger rank = new AtomicInteger(1);
        sortedResults.forEach((key, value) -> {
            toReturn
                    .append(rank.get())
                    .append(": ")
                    .append(key)
                    .append(" (")
                    .append(value)
                    .append(")")
                    .append(System.getProperty("line.separator"));
            rank.set(rank.get() + 1);
        });

        Gson gson = new Gson();
        return gson.toJson(sortedResults);
    }
}
