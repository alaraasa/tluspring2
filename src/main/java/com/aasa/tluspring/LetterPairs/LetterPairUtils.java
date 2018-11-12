package com.aasa.tluspring.LetterPairs;

import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Data
class LetterPairUtils {

    private String originalText;
    private Map<String, Integer> allPairs = new HashMap<>();
    private Integer TOP_N_TO_RETURN = 3;

    void parseText() {
        String[] splitText = originalText.split("[\\p{Punct}\\s]+");
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

    HashMap<String, Integer> sortByValues() {
        return allPairs.entrySet().stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .limit(TOP_N_TO_RETURN)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    HashMap<String, Integer> getPairs() {
        return sortByValues();
//        StringBuilder toReturn = new StringBuilder();
//        HashMap<String, Integer> sortedResults = sortByValues();
//        Gson gson = new Gson();
//        return gson.toJson(sortedResults);
    }
}
