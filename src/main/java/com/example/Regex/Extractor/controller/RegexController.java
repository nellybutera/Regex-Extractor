package com.example.Regex.Extractor.controller;

import com.example.Regex.Extractor.util.RegexUtil;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/extract")
public class RegexController {

    @PostMapping
    public Map<String, List<String>> extractData(@RequestBody Map<String, String> request) {
        String text = request.get("text");
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text input cannot be empty");
        }
        return RegexUtil.extractAll(text);
    }
}