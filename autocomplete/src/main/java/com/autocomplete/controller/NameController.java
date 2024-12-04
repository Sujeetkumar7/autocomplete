package com.autocomplete.controller;

import com.autocomplete.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NameController {

    @Autowired
    private NameService nameService;

    @GetMapping("/autocomplete")
    public List<String> autocomplete(@RequestParam String prefix) {
        if (prefix == null || prefix.trim().isEmpty()) {
            throw new IllegalArgumentException("Prefix cannot be empty");
        }
        return nameService.getAutocompleteSuggestions(prefix);
    }
}