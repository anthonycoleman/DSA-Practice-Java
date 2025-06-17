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
            // TODO: Initialize children map and set isEndOfWord to false
        }
    }

    private final TrieNode root;

    public Trie() {
        // TODO: Initialize the root node
        this.root = null; // Placeholder
    }

    /**
     * Inserts a word into the trie.
     * @param word The word to insert.
     */
    public void insert(String word) {
        // TODO: Implement insert. Traverse the trie, creating nodes as necessary,
        // and mark the end of the word.
    }

    /**
     * Searches for a word in the trie.
     * @param word The word to search for.
     * @return true if the word is in the trie, false otherwise.
     */
    public boolean search(String word) {
        // TODO: Implement search. Traverse the trie and check if the final node
        // is marked as the end of a word.
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * @param prefix The prefix to search for.
     * @return true if there is any word with the given prefix, false otherwise.
     */
    public boolean startsWith(String prefix) {
        // TODO: Implement startsWith. Traverse the trie. If the traversal completes,
        // a word with the prefix exists.
        return false;
    }
}
