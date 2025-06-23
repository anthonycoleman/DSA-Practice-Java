package com.dsa.datastructures;

/**
 * Generic Hash Table implementation using separate chaining for collision resolution
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;
    
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private Entry<K, V>[] buckets;
    private int size;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public HashTable() {
        this.capacity = DEFAULT_CAPACITY;
        this.buckets = new Entry[capacity];
        this.size = 0;
    }
    
    /**
     * Store key-value pair
     * @param key the key
     * @param value the value
     */
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        
        if ((double) size / capacity >= LOAD_FACTOR_THRESHOLD) {
            resize();
        }
        
        int index = hash(key);
        Entry<K, V> entry = buckets[index];
        
        // Check if key already exists
        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing value
                return;
            }
            entry = entry.next;
        }
        
        // Add new entry at the beginning of the chain
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = buckets[index];
        buckets[index] = newEntry;
        size++;
    }
    
    /**
     * Get value for specified key
     * @param key the key to look up
     * @return value or null if key not found
     */
    public V get(K key) {
        if (key == null) {
            return null;
        }
        
        int index = hash(key);
        Entry<K, V> entry = buckets[index];
        
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        
        return null;
    }
    
    /**
     * Remove key-value pair
     * @param key the key to remove
     * @return removed value or null if key not found
     */
    public V remove(K key) {
        if (key == null) {
            return null;
        }
        
        int index = hash(key);
        Entry<K, V> entry = buckets[index];
        Entry<K, V> prev = null;
        
        while (entry != null) {
            if (entry.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
                return entry.value;
            }
            prev = entry;
            entry = entry.next;
        }
        
        return null;
    }
    
    /**
     * Check if key exists in table
     * @param key the key to check
     * @return true if key exists, false otherwise
     */
    public boolean containsKey(K key) {
        if (key == null) {
            return false;
        }
        
        int index = hash(key);
        Entry<K, V> entry = buckets[index];
        
        while (entry != null) {
            if (entry.key.equals(key)) {
                return true;
            }
            entry = entry.next;
        }
        
        return false;
    }
    
    /**
     * Get number of key-value pairs
     * @return the number of pairs
     */
    public int size() {
        return size;
    }
    
    /**
     * Check if table is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
    
    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldBuckets = buckets;
        capacity *= 2;
        buckets = new Entry[capacity];
        size = 0;
        
        // Rehash all entries
        for (Entry<K, V> head : oldBuckets) {
            Entry<K, V> entry = head;
            while (entry != null) {
                put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }
}