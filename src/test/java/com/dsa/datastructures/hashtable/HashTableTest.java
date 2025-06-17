package com.dsa.datastructures.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    private HashTable<String, Integer> hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new HashTable<>();
    }

    @Test
    void testNewHashTableIsEmpty() {
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
    }

    @Test
    void testPutAndGet() {
        hashTable.put("apple", 1);
        hashTable.put("banana", 2);

        assertEquals(2, hashTable.size());
        assertEquals(1, hashTable.get("apple"));
        assertEquals(2, hashTable.get("banana"));
        assertNull(hashTable.get("cherry"));
    }

    @Test
    void testPutUpdatesExistingKey() {
        hashTable.put("apple", 1);
        assertEquals(1, hashTable.get("apple"));

        hashTable.put("apple", 100);
        assertEquals(1, hashTable.size(), "Size should not change when updating a key");
        assertEquals(100, hashTable.get("apple"), "Value should be updated for an existing key");
    }

    @Test
    void testRemove() {
        hashTable.put("apple", 1);
        hashTable.put("banana", 2);

        assertEquals(1, hashTable.remove("apple"));
        assertEquals(1, hashTable.size());
        assertNull(hashTable.get("apple"));
        assertNull(hashTable.remove("cherry"), "Removing a non-existent key should return null");
    }

    @Test
    void testContainsKey() {
        hashTable.put("apple", 1);
        assertTrue(hashTable.containsKey("apple"));
        assertFalse(hashTable.containsKey("cherry"));
    }

    @Test
    void testCollisionHandling() {
        // These two keys are chosen to likely cause a collision with a simple hash function.
        // In a real scenario, you might need a custom key class with a controlled hashCode().
        hashTable.put("FB", 1);
        hashTable.put("Ea", 2);

        assertEquals(2, hashTable.size());
        assertEquals(1, hashTable.get("FB"));
        assertEquals(2, hashTable.get("Ea"));

        hashTable.remove("FB");
        assertEquals(1, hashTable.size());
        assertNull(hashTable.get("FB"));
        assertEquals(2, hashTable.get("Ea"));
    }
}
