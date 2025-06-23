package com.dsa.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * Trie (Prefix Tree) implementation for strings
 */
public class Trie {
    
    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;
        
        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }
    
    private final TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    /**
     * Insert word into trie
     * @param word word to insert
     */
    public void insert(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Word cannot be null");
        }
        
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }
    
    /**
     * Search for complete word in trie
     * @param word word to search for
     * @return true if word exists, false otherwise
     */
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord;
    }
    
    /**
     * Check if any word starts with given prefix
     * @param prefix prefix to check
     * @return true if prefix exists, false otherwise
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return true;
    }
    
    
    /**
     * Check if trie is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return root.children.isEmpty();
    }
}