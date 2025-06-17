package com.dsa.datastructures.trie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {

    private Trie trie;

    @BeforeEach
    void setUp() {
        trie = new Trie();
        trie.insert("apple");
    }

    @Test
    void testSearchForExistingWord() {
        assertTrue(trie.search("apple"), "Should find the word 'apple'");
    }

    @Test
    void testSearchForNonExistingWord() {
        assertFalse(trie.search("app"), "Should not find 'app' as a full word");
    }

    @Test
    void testStartsWithExistingPrefix() {
        assertTrue(trie.startsWith("app"), "Should find 'app' as a prefix");
    }

    @Test
    void testStartsWithNonExistingPrefix() {
        assertFalse(trie.startsWith("banana"), "Should not find 'banana' as a prefix");
    }

    @Test
    void testInsertAndSearchMultipleWords() {
        trie.insert("application");
        trie.insert("apply");

        assertTrue(trie.search("application"));
        assertTrue(trie.search("apply"));
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("appl"));
    }

    @Test
    void testComplexStartsWith() {
        trie.insert("application");
        assertTrue(trie.startsWith("appl"));
        assertFalse(trie.startsWith("applesauce"));
    }
}
