package com.java;

import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static Map<String, Integer> cntOfWords(List<String> words) throws ParseException {
        String rules = "< а, А < б, Б < в, В < г, Г < д, Д < е, Е < ё, Ё < ж, Ж < з, З < и, И < й, Й < к, К < л, Л < м, М < н, Н < о, О < п, П < р, Р < с, С < т, Т < у, У < ф, Ф < х, Х < ц, Ц < ч, Ч < ш, Ш < щ, Щ < ъ, Ъ < ы, Ы < ь, Ь < э, Э < ю, Ю < я, Я";
        RuleBasedCollator col = new RuleBasedCollator(rules);
        Map<String, Integer> mapWords = new TreeMap<>(col);
        for (String w : words) {
            if (!mapWords.containsKey((w))) {
                mapWords.put(w, 1);
            } else {
                mapWords.put(w, mapWords.get(w) + 1);
            }
        }
        return mapWords;
    }

    public static void main(String[] args) throws ParseException {
        List<String> words = new ArrayList<>() {{
            add("язык");
            add("Курсы");
            add("Ёж");
            add("Курсы");
            add("Арбуз");
            add("Курсы");
            add("ель");
            add("ель");
            add("Курсы");
            add("ель");
            add("Курсы");
            add("Ёж");
            add("язык");
        }};

        Map<String, Integer> mapWords = cntOfWords(words);
        mapWords.forEach((a,b)-> System.out.println(a + " - " + b));
    }
}
