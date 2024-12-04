package com.autocomplete.service;

import com.autocomplete.entity.Name;
import com.autocomplete.repository.NameRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NameService {

    @Autowired
    private NameRepository nameRepository;

    private Trie trie;

    @PostConstruct
    public void init() {
        trie = new Trie();
        List<Name> names = nameRepository.findAll();
        for (Name name : names) {
            trie.insert(name.getName());
        }
    }

    public List<String> getAutocompleteSuggestions(String prefix) {
        return trie.autocomplete(prefix);
    }
}