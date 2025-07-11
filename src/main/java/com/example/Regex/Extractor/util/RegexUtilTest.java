import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class RegexUtilTest {

    @Test
    void testEmailExtraction() {
        String text = "Contact me at hello@example.com and support@mydomain.org";
        Map<String, List<String>> result = RegexUtil.extractAll(text);
        assertEquals(List.of("hello@example.com", "support@mydomain.org"), result.get("email"));
    }

    @Test
    void testUrlExtraction() {
        String text = "Visit https://example.com or http://test.org/page";
        Map<String, List<String>> result = RegexUtil.extractAll(text);
        assertTrue(result.get("url").contains("https://example.com"));
        assertTrue(result.get("url").contains("http://test.org/page"));
    }

    @Test
    void testPhoneExtraction() {
        String text = "Call me at +250 788 123 456 or 0788-123-456";
        Map<String, List<String>> result = RegexUtil.extractAll(text);
        assertEquals(2, result.get("phone").size());
    }

    @Test
    void testCreditCardExtraction() {
        String text = "My card number is 1234-5678-9012-3456";
        Map<String, List<String>> result = RegexUtil.extractAll(text);
        assertEquals(List.of("1234-5678-9012-3456"), result.get("creditCard"));
    }

    @Test
    void testCurrencyExtraction() {
        String text = "Total cost is $45.50 and discount price is $20";
        Map<String, List<String>> result = RegexUtil.extractAll(text);
        assertTrue(result.get("currency").contains("$45.50"));
        assertTrue(result.get("currency").contains("$20"));
    }

    @Test
    void testTimeExtraction() {
        String text = "Meeting at 09:30, lunch at 14:00, dinner at 20:45";
        Map<String, List<String>> result = RegexUtil.extractAll(text);
        assertEquals(3, result.get("time").size());
    }

    @Test
    void testHtmlTagExtraction() {
        String text = "<div>Hello</div><p>World</p>";
        Map<String, List<String>> result = RegexUtil.extractAll(text);
        assertTrue(result.get("htmlTag").contains("<div>"));
        assertTrue(result.get("htmlTag").contains("</div>"));
    }

    @Test
    void testHashtagExtraction() {
        String text = "Loving #Java and #SpringBoot!";
        Map<String, List<String>> result = RegexUtil.extractAll(text);
        assertEquals(List.of("#Java", "#SpringBoot"), result.get("hashtag"));
    }
}