package com.dsa.datastructures.hashtable;

import java.util.LinkedList;

/**
 * An implementation of a Hash Table using separate chaining for collision resolution.
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class HashTable<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public HashTable() {
        // TODO: Initialize the table with the default capacity
        // table = new LinkedList[DEFAULT_CAPACITY];
        // for (int i = 0; i < DEFAULT_CAPACITY; i++) {
        //     table[i] = new LinkedList<>();
        // }
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old value is replaced.
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     */
    public void put(K key, V value) {
        // TODO: Implement put. Hash the key, find the bucket, and add/update the entry.
    }

    /**
     * Returns the value to which the specified key is mapped,
     * or null if this map contains no mapping for the key.
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null
     */
    public V get(K key) {
        // TODO: Implement get. Hash the key, find the bucket, and search for the key.
        return null;
    }

    /**
     * Removes the mapping for a key from this map if it is present.
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null
     */
    public V remove(K key) {
        // TODO: Implement remove. Hash the key, find the bucket, and remove the entry.
        return null;
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     * @param key The key whose presence in this map is to be tested
     * @return true if this map contains a mapping for the specified key
     */
    public boolean containsKey(K key) {
        // TODO: Implement containsKey.
        return false;
    }

    /**
     * Returns the number of key-value mappings in this map.
     * @return the number of key-value mappings in this map
     */
    public int size() {
        // TODO: Implement size.
        return 0;
    }

    /**
     * Returns true if this map contains no key-value mappings.
     * @return true if this map contains no key-value mappings
     */
    public boolean isEmpty() {
        // TODO: Implement isEmpty.
        return true;
    }
}
