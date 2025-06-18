package com.dsa.datastructures.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of a Trie (Prefix Tree) for storing and searching for strings.
 * It supports efficient insertion, full-word search, and prefix search.
 */
public class Trie {

    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     * @param word The word to insert.
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty.");
        }
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }

    /**
     * Searches for a word in the trie.
     * @param word The word to search for.
     * @return true if the word is in the trie, false otherwise.
     */
    public boolean search(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Word to search cannot be null.");
        }
        if (word.isEmpty()) {
            return root.isEndOfWord; // Only true if an empty string was explicitly inserted (not by this impl)
        }
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return false; // Path does not exist
            }
            current = node;
        }
        return current.isEndOfWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * @param prefix The prefix to search for.
     * @return true if there is any word with the given prefix, false otherwise.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix cannot be null.");
        }
        if (prefix.isEmpty()) {
            return true; // Any trie contains words starting with an empty prefix
        }
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return false; // Path does not exist
            }
            current = node;
        }
        return true; // Prefix path exists
    }
}
