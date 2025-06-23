package com.dsa.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    
    private HashTable<String, Integer> hashTable;
    
    @BeforeEach
    void setUp() {
        hashTable = new HashTable<>();
    }
    
    @Test
    void testNewHashTable_IsEmpty() {
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
    }
    
    @Test
    void testPut_SingleKeyValue_SizeIncreases() {
        hashTable.put("key1", 100);
        
        assertEquals(1, hashTable.size());
        assertFalse(hashTable.isEmpty());
        assertTrue(hashTable.containsKey("key1"));
        assertEquals(100, hashTable.get("key1"));
    }
    
    @Test
    void testPut_MultipleKeyValues_AllStored() {
        hashTable.put("apple", 1);
        hashTable.put("banana", 2);
        hashTable.put("cherry", 3);
        
        assertEquals(3, hashTable.size());
        assertEquals(1, hashTable.get("apple"));
        assertEquals(2, hashTable.get("banana"));
        assertEquals(3, hashTable.get("cherry"));
    }
    
    @Test
    void testPut_DuplicateKey_UpdatesValue() {
        hashTable.put("key1", 100);
        hashTable.put("key1", 200);
        
        assertEquals(1, hashTable.size()); // Size should not increase
        assertEquals(200, hashTable.get("key1")); // Value should be updated
    }
    
    @Test
    void testPut_NullKey_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> hashTable.put(null, 100));
    }
    
    @Test
    void testGet_ExistingKey_ReturnsValue() {
        hashTable.put("test", 42);
        assertEquals(42, hashTable.get("test"));
    }
    
    @Test
    void testGet_NonExistentKey_ReturnsNull() {
        assertNull(hashTable.get("nonexistent"));
        
        hashTable.put("key1", 100);
        assertNull(hashTable.get("key2"));
    }
    
    @Test
    void testGet_NullKey_ReturnsNull() {
        assertNull(hashTable.get(null));
    }
    
    @Test
    void testContainsKey_ExistingKey_ReturnsTrue() {
        hashTable.put("exists", 123);
        assertTrue(hashTable.containsKey("exists"));
    }
    
    @Test
    void testContainsKey_NonExistentKey_ReturnsFalse() {
        assertFalse(hashTable.containsKey("nonexistent"));
        
        hashTable.put("key1", 100);
        assertFalse(hashTable.containsKey("key2"));
    }
    
    @Test
    void testRemove_ExistingKey_RemovesAndReturnsValue() {
        hashTable.put("remove_me", 999);
        hashTable.put("keep_me", 111);
        
        assertEquals(999, hashTable.remove("remove_me"));
        assertEquals(1, hashTable.size());
        assertFalse(hashTable.containsKey("remove_me"));
        assertTrue(hashTable.containsKey("keep_me"));
        assertNull(hashTable.get("remove_me"));
    }
    
    @Test
    void testRemove_NonExistentKey_ReturnsNull() {
        assertNull(hashTable.remove("nonexistent"));
        
        hashTable.put("key1", 100);
        assertNull(hashTable.remove("key2"));
        assertEquals(1, hashTable.size()); // Size should not change
    }
    
    @Test
    void testRemove_NullKey_ReturnsNull() {
        assertNull(hashTable.remove(null));
    }
    
    @Test
    void testCollisionHandling_SeparateChaining() {
        // We'll test with enough elements to likely cause collisions
        for (int i = 0; i < 20; i++) {
            hashTable.put("key" + i, i * 10);
        }
        
        assertEquals(20, hashTable.size());
        
        // Verify all values can be retrieved correctly
        for (int i = 0; i < 20; i++) {
            assertEquals(i * 10, hashTable.get("key" + i));
            assertTrue(hashTable.containsKey("key" + i));
        }
    }
    
    @Test
    void testDynamicResizing_HandlesLoadFactor() {
        // Insert enough elements to trigger resizing
        for (int i = 0; i < 50; i++) {
            hashTable.put("item" + i, i);
        }
        
        assertEquals(50, hashTable.size());
        
        // All elements should still be accessible after resizing
        for (int i = 0; i < 50; i++) {
            assertEquals(i, hashTable.get("item" + i));
            assertTrue(hashTable.containsKey("item" + i));
        }
    }
    
    @Test
    void testMixedOperations_WorkCorrectly() {
        // Put some values
        hashTable.put("a", 1);
        hashTable.put("b", 2);
        hashTable.put("c", 3);
        
        // Update a value
        hashTable.put("b", 20);
        assertEquals(20, hashTable.get("b"));
        
        // Remove a value
        assertEquals(1, hashTable.remove("a"));
        assertFalse(hashTable.containsKey("a"));
        
        // Add more values
        hashTable.put("d", 4);
        hashTable.put("e", 5);
        
        assertEquals(4, hashTable.size());
        assertTrue(hashTable.containsKey("b"));
        assertTrue(hashTable.containsKey("c"));
        assertTrue(hashTable.containsKey("d"));
        assertTrue(hashTable.containsKey("e"));
    }
    
    @Test
    void testGenericTypes_WorksWithDifferentTypes() {
        HashTable<Integer, String> intStringTable = new HashTable<>();
        
        intStringTable.put(1, "one");
        intStringTable.put(2, "two");
        intStringTable.put(3, "three");
        
        assertEquals(3, intStringTable.size());
        assertEquals("one", intStringTable.get(1));
        assertEquals("two", intStringTable.get(2));
        assertEquals("three", intStringTable.get(3));
        
        assertTrue(intStringTable.containsKey(1));
        assertFalse(intStringTable.containsKey(4));
    }
    
    @Test
    void testNullValues_HandledCorrectly() {
        hashTable.put("null_value", null);
        hashTable.put("real_value", 100);
        
        assertEquals(2, hashTable.size());
        assertNull(hashTable.get("null_value"));
        assertEquals(100, hashTable.get("real_value"));
        
        // containsKey should work even with null values
        assertTrue(hashTable.containsKey("null_value"));
        assertTrue(hashTable.containsKey("real_value"));
        
        // Remove null value
        assertNull(hashTable.remove("null_value"));
        assertEquals(1, hashTable.size());
        assertFalse(hashTable.containsKey("null_value"));
    }
    
    @Test
    void testEmptyStringKey_WorksCorrectly() {
        hashTable.put("", 999);
        
        assertEquals(1, hashTable.size());
        assertEquals(999, hashTable.get(""));
        assertTrue(hashTable.containsKey(""));
        
        assertEquals(999, hashTable.remove(""));
        assertEquals(0, hashTable.size());
        assertFalse(hashTable.containsKey(""));
    }
    
    @Test
    void testLargeNumberOfElements_PerformanceTest() {
        // Insert many elements
        for (int i = 0; i < 1000; i++) {
            hashTable.put("key" + i, i);
        }
        
        assertEquals(1000, hashTable.size());
        
        // Random access should still be fast
        assertEquals(500, hashTable.get("key500"));
        assertEquals(0, hashTable.get("key0"));
        assertEquals(999, hashTable.get("key999"));
        
        // Remove half the elements
        for (int i = 0; i < 500; i++) {
            assertEquals(i, hashTable.remove("key" + i));
        }
        
        assertEquals(500, hashTable.size());
        
        // Verify remaining elements
        for (int i = 500; i < 1000; i++) {
            assertTrue(hashTable.containsKey("key" + i));
            assertEquals(i, hashTable.get("key" + i));
        }
        
        // Verify removed elements are gone
        for (int i = 0; i < 500; i++) {
            assertFalse(hashTable.containsKey("key" + i));
            assertNull(hashTable.get("key" + i));
        }
    }
    
    @Test
    void testClearAllElements_ByRemoval() {
        // Add elements
        for (int i = 0; i < 10; i++) {
            hashTable.put("item" + i, i);
        }
        
        assertEquals(10, hashTable.size());
        
        // Remove all elements
        for (int i = 0; i < 10; i++) {
            assertEquals(i, hashTable.remove("item" + i));
        }
        
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
    }
    
    @Test
    void testSameHashCode_DifferentKeys() {
        // Use keys that are likely to have hash collisions
        hashTable.put("a", 1);
        hashTable.put("b", 2);
        hashTable.put("c", 3);
        
        // Even with potential collisions, all should work
        assertEquals(3, hashTable.size());
        assertEquals(1, hashTable.get("a"));
        assertEquals(2, hashTable.get("b"));
        assertEquals(3, hashTable.get("c"));
    }
}