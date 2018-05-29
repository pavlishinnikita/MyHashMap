package com.nikita.SimpleHashMap;

import java.util.Map;
import java.util.Objects;

/**
 * This class is simple entry in hash table
 * @param <K> - Key in pair
 * @param <V> - Value in pair
 */
public class MyEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return this.value;
    }

    @Override
    public int hashCode() {
        int hashCode = 31; // usually this a simple number
        hashCode = hashCode * 17 + key.hashCode(); // 17 is a simple number
        return hashCode;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o instanceof MyEntry) {
            MyEntry obj = (MyEntry) o;
            return (Objects.equals(this.key, obj.getKey()) &&
                    Objects.equals(this.value, obj.getValue()) ||
                    Objects.equals(this.hashCode(), obj.hashCode()));
        }
        return false;
    }

}
