package com.autocomplete.service;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        String lowerWord = word.toLowerCase();
        TrieNode currentNode = root;
        for (char c : lowerWord.toCharArray()) {
            currentNode = currentNode.children.computeIfAbsent(c, k -> new TrieNode());
        }
        currentNode.isEndOfWord = true;
        currentNode.originalWord = word;
    }

    public List<String> autocomplete(String prefix) {
        String lowerPrefix = prefix.toLowerCase();
        TrieNode currentNode = root;

        for (char c : lowerPrefix.toCharArray()) {
            currentNode = currentNode.children.get(c);
            if (currentNode == null) {
                return new ArrayList<>(); // No matches
            }
        }

        List<String> results = new ArrayList<>();
        findWordsWithPrefix(currentNode, lowerPrefix, results);
        return results;
    }

    private void findWordsWithPrefix(TrieNode node, String prefix, List<String> results) {
        if (node.isEndOfWord) {
            results.add(node.originalWord);
        }
        for (char c : node.children.keySet()) {
            findWordsWithPrefix(node.children.get(c), prefix + c, results);
        }
    }

    private static class TrieNode {
        private boolean isEndOfWord;
        private String originalWord;
        private final java.util.Map<Character, TrieNode> children;

        public TrieNode() {
            this.isEndOfWord = false;
            this.originalWord = null;
            this.children = new java.util.HashMap<>();
        }
    }
}