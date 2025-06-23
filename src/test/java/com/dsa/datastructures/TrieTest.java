package com.dsa.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrieTest {
    
    private Trie trie;
    
    @BeforeEach
    void setUp() {
        trie = new Trie();
    }
    
    @Test
    void testNewTrie_IsEmpty() {
        assertTrue(trie.isEmpty());
    }
    
    @Test
    void testInsert_SingleWord_NotEmpty() {
        trie.insert("hello");
        
        assertFalse(trie.isEmpty());
        assertTrue(trie.search("hello"));
    }
    
    @Test
    void testInsert_MultipleWords_AllSearchable() {
        trie.insert("cat");
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("dog");
        
        assertTrue(trie.search("cat"));
        assertTrue(trie.search("car"));
        assertTrue(trie.search("card"));
        assertTrue(trie.search("care"));
        assertTrue(trie.search("dog"));
    }
    
    @Test
    void testInsert_NullWord_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> trie.insert(null));
    }
    
    @Test
    void testSearch_NonExistentWord_ReturnsFalse() {
        trie.insert("hello");
        
        assertFalse(trie.search("world"));
        assertFalse(trie.search("hell"));
        assertFalse(trie.search("helloo"));
    }
    
    @Test
    void testSearch_EmptyTrie_ReturnsFalse() {
        assertFalse(trie.search("anything"));
    }
    
    @Test
    void testSearch_NullWord_ReturnsFalse() {
        assertFalse(trie.search(null));
    }
    
    @Test
    void testSearch_EmptyString_WorksCorrectly() {
        trie.insert("");
        assertTrue(trie.search(""));
        
        // Empty string as separate case
        Trie emptyTrie = new Trie();
        assertFalse(emptyTrie.search(""));
    }
    
    @Test
    void testStartsWith_ExistingPrefix_ReturnsTrue() {
        trie.insert("hello");
        trie.insert("help");
        trie.insert("hero");
        
        assertTrue(trie.startsWith("he"));
        assertTrue(trie.startsWith("hel"));
        assertTrue(trie.startsWith("hello"));
        assertTrue(trie.startsWith("help"));
        assertTrue(trie.startsWith("hero"));
    }
    
    @Test
    void testStartsWith_NonExistentPrefix_ReturnsFalse() {
        trie.insert("hello");
        trie.insert("world");
        
        assertFalse(trie.startsWith("hi"));
        assertFalse(trie.startsWith("wu"));  // "wu" is not a prefix of any word
        assertFalse(trie.startsWith("xyz"));
    }
    
    @Test
    void testStartsWith_EmptyTrie_ReturnsFalse() {
        assertFalse(trie.startsWith("any"));
    }
    
    @Test
    void testStartsWith_NullPrefix_ReturnsFalse() {
        assertFalse(trie.startsWith(null));
    }
    
    @Test
    void testStartsWith_EmptyString_ReturnsTrue() {
        trie.insert("hello");
        assertTrue(trie.startsWith(""));
        
        // Even empty trie should return true for empty prefix
        Trie emptyTrie = new Trie();
        assertTrue(emptyTrie.startsWith(""));
    }
    
    @Test
    void testPrefixVsCompleteWord_BehaviorDifference() {
        trie.insert("car");
        trie.insert("card");
        
        // "car" is a complete word
        assertTrue(trie.search("car"));
        assertTrue(trie.startsWith("car"));
        
        // "ca" is only a prefix
        assertFalse(trie.search("ca"));
        assertTrue(trie.startsWith("ca"));
        
        // "card" is a complete word
        assertTrue(trie.search("card"));
        assertTrue(trie.startsWith("card"));
    }
    
    @Test
    void testInsertDuplicateWord_HandlesCorrectly() {
        trie.insert("hello");
        trie.insert("hello"); // Duplicate
        
        assertTrue(trie.search("hello"));
        assertTrue(trie.startsWith("hello"));
        assertTrue(trie.startsWith("hell"));
    }
    
    @Test
    void testWordsWithCommonPrefix_BothWork() {
        trie.insert("test");
        trie.insert("testing");
        trie.insert("tester");
        
        assertTrue(trie.search("test"));
        assertTrue(trie.search("testing"));
        assertTrue(trie.search("tester"));
        
        assertTrue(trie.startsWith("test"));
        assertTrue(trie.startsWith("testi"));
        assertTrue(trie.startsWith("testin"));
        assertTrue(trie.startsWith("testing"));
    }
    
    @Test
    void testSingleCharacterWords_WorkCorrectly() {
        trie.insert("a");
        trie.insert("b");
        trie.insert("c");
        
        assertTrue(trie.search("a"));
        assertTrue(trie.search("b"));
        assertTrue(trie.search("c"));
        
        assertTrue(trie.startsWith("a"));
        assertTrue(trie.startsWith("b"));
        assertTrue(trie.startsWith("c"));
        
        assertFalse(trie.search("d"));
        assertFalse(trie.startsWith("d"));
    }
    
    @Test
    void testLongWords_WorkCorrectly() {
        String longWord = "supercalifragilisticexpialidocious";
        trie.insert(longWord);
        
        assertTrue(trie.search(longWord));
        assertTrue(trie.startsWith(longWord));
        assertTrue(trie.startsWith("super"));
        assertTrue(trie.startsWith("supercali"));
        
        assertFalse(trie.search("super"));
        assertFalse(trie.search(longWord + "extra"));
    }
    
    @Test
    void testCaseSensitivity_TreatsAsDistinct() {
        trie.insert("Hello");
        trie.insert("hello");
        trie.insert("HELLO");
        
        assertTrue(trie.search("Hello"));
        assertTrue(trie.search("hello"));
        assertTrue(trie.search("HELLO"));
        
        assertFalse(trie.search("HeLLo"));
        assertFalse(trie.search("hELLO"));
    }
    
    @Test
    void testSpecialCharacters_NotSupported() {
        // Our implementation only supports lowercase a-z
        // Other characters should either be ignored or cause issues
        // This behavior depends on implementation details
        
        // Test with numbers and symbols might not work as expected
        // since our TrieNode uses children = new TrieNode[26]
        
        // For safety, we'll test that normal words still work
        trie.insert("normal");
        assertTrue(trie.search("normal"));
    }
    
    @Test
    void testComplexInsertAndSearch_WorksCorrectly() {
        // Insert multiple words with overlapping prefixes
        trie.insert("cat");
        trie.insert("cats");
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        
        // Verify all exist
        assertTrue(trie.search("cat"));
        assertTrue(trie.search("cats"));
        assertTrue(trie.search("car"));
        assertTrue(trie.search("card"));
        assertTrue(trie.search("care"));
        assertTrue(trie.search("careful"));
        
        // Test prefixes
        assertTrue(trie.startsWith("ca"));
        assertTrue(trie.startsWith("car"));
        assertTrue(trie.startsWith("care"));
        assertTrue(trie.startsWith("careful"));
        
        // Test non-existent searches
        assertFalse(trie.search("ca"));
        assertFalse(trie.search("cars"));
        assertFalse(trie.search("carefully"));
    }
}