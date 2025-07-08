package com.example.Regex.Extractor.util;

import java.util.*;
import java.util.regex.*;

public Class RegexUtil {

    private static final Map<String, String> patterns = new HashMap<>();

    static {
        patterns.put("email", "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b");
        patterns.put("url", "\\bhttps?://[\\w\\-\\.]+(?:/\\S*)?\\b");
        patterns.put("phone", "\\b\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,4}\\b");
        patterns.put("creditCard", "\\b\\d{4}[-\\s]?\\d{4}[-\\s]?\\d{4}[-\\s]?\\d{4}\\b");
        patterns.put("currency", "\\b\\$\\d+(?:\\.\\d{2})?\\b");
        patterns.put("time", "\\b([01]?\\d|2[0-3]):[0-5]\\d\\b");
        patterns.put("htmlTag", "<(\"[^\"]*\"|'[^']*'|[^'\">])*>");
        patterns.put("hashtag", "#\\w+");
    }

    public static Map<String, List<String>> extractAll(String text) {
        Map<String, List<String>> results = new HashMap<>();
        for (Map.Entry<String, String> entry : patterns.entrySet()) {
            List<String> matches = new ArrayList<>();
            Matcher matcher = Pattern.compile(entry.getValue()).matcher(text);
            while (matcher.find()) {
                matches.add(matcher.group());
            }
            results.put(entry.getKey(), matches);
        }
        return results;
    }

}