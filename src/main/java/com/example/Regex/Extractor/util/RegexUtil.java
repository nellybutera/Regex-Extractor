package com.example.Regex.Extractor.util;

import java.util.*;
import java.util.regex.*;

public class RegexUtil {

    // Define regex patterns for each data type
    private static final String EMAIL_REGEX = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";
    private static final String URL_REGEX = "\\bhttps?://[A-Za-z0-9.-]+(?:\\.[A-Za-z]{2,})+\\S*\\b";
    private static final String PHONE_REGEX = "\\b(?:\\+?\\d{1,3}[-.\\s]?)?(?:\\(?\\d{2,4}\\)?[-.\\s]?)?\\d{3,4}[-.\\s]?\\d{3,4}\\b";
    private static final String CREDIT_CARD_REGEX = "\\b(?:\\d{4}[-\\s]?){3}\\d{4}\\b";
    private static final String CURRENCY_REGEX = "\\b(?:\\$|€|£)?\\d{1,3}(?:,\\d{3})*(?:\\.\\d{2})?\\b";
    private static final String TIME_REGEX = "\\b([01]?\\d|2[0-3]):[0-5]\\d(:[0-5]\\d)?(\\s?(AM|PM|am|pm))?\\b";
    private static final String HTML_TAG_REGEX = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>";
    private static final String HASHTAG_REGEX = "#\\w+";

    /**
     * Extract all supported patterns from the input text.
     * Returns a map of data type -> list of matches.
     */
    public static Map<String, List<String>> extractAll(String text) {
        Map<String, List<String>> results = new HashMap<>();

        results.put("emails", extractMatches(text, EMAIL_REGEX));
        results.put("urls", extractMatches(text, URL_REGEX));
        results.put("phoneNumbers", extractMatches(text, PHONE_REGEX));
        results.put("creditCards", extractMatches(text, CREDIT_CARD_REGEX));
        results.put("currencies", extractMatches(text, CURRENCY_REGEX));
        results.put("times", extractMatches(text, TIME_REGEX));
        results.put("htmlTags", extractMatches(text, HTML_TAG_REGEX));
        results.put("hashtags", extractMatches(text, HASHTAG_REGEX));

        return results;
    }

    /**
     * Helper method that extracts all matches of a regex from the input text.
     */
    private static List<String> extractMatches(String text, String regex) {
        List<String> matches = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }
}
