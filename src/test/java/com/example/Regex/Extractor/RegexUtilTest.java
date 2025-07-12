package com.example.Regex.Extractor;

import com.example.Regex.Extractor.util.RegexUtil;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexUtilTest {

    @Test
    public void testEmailExtraction() {
        String text = "hello@example.com support@mydomain.org";
        Map<String, List<String>> result = RegexUtil.extractAll(text);
        List<String> emails = result.get("emails");
        assertEquals(Arrays.asList("hello@example.com", "support@mydomain.org"), emails);
    }

    @Test
    public void testUrlExtraction() {
        String text = "Visit https://example.com and http://mydomain.org for info.";
        Map<String, List<String>> result = RegexUtil.extractAll(text);
        List<String> urls = result.get("urls");
        assertTrue(urls.contains("https://example.com"));
        assertTrue(urls.contains("http://mydomain.org"));
    }

    @Test
    public void testPhoneExtraction() {
        String text = "+1-123-456-7890 (555) 234-5678";
        Map<String, List<String>> result = RegexUtil.extractAll(text);
        List<String> phones = result.get("phoneNumbers");
        assertEquals(2, phones.size());
        assertTrue(phones.contains("+1-123-456-7890"));
        assertTrue(phones.contains("(555) 234-5678"));
    }

    @Test
    public void testCreditCardExtraction() {
        String text = "My card: 1234-5678-9012-3456";
        Map<String, List<String>> result = RegexUtil.extractAll(text);
        List<String> cards = result.get("creditCards");
        assertEquals(Arrays.asList("1234-5678-9012-3456"), cards);
    }

    @Test
    public void testCurrencyExtraction() {
        String text = "$12.50 €99.99 £100";
        Map<String, List<String>> result = RegexUtil.extractAll(text);
        List<String> currencies = result.get("currencies");
        assertTrue(currencies.contains("$12.50"));
        assertTrue(currencies.contains("€99.99"));
        assertTrue(currencies.contains("£100"));
    }

    @Test
    public void testTimeExtraction() {
        String text = "Meeting at 09:30 or 23:15:45 PM";
        Map<String, List<String>> result = RegexUtil.extractAll(text);
        List<String> times = result.get("times");
        assertTrue(times.contains("09:30"));
        assertTrue(times.contains("23:15:45 PM"));
    }

    @Test
    public void testHtmlTagExtraction() {
        String text = "<div>Hello</div> <p>World</p>";
        Map<String, List<String>> result = RegexUtil.extractAll(text);
        List<String> htmlTags = result.get("htmlTags");
        assertTrue(htmlTags.contains("<div>"));
        assertTrue(htmlTags.contains("</div>"));
        assertTrue(htmlTags.contains("<p>"));
        assertTrue(htmlTags.contains("</p>"));
    }

    @Test
    public void testHashtagExtraction() {
        String text = "#Java #SpringBoot";
        Map<String, List<String>> result = RegexUtil.extractAll(text);
        List<String> hashtags = result.get("hashtags");
        assertEquals(Arrays.asList("#Java", "#SpringBoot"), hashtags);
    }
}
