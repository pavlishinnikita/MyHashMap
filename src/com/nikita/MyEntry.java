package com.nikita.HashMap;

import java.util.Map;

public class MyEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    public MyEntry(){

    }

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
        int hash = 31; // usually this a simple number
        return hash *= 17 + (key.hashCode() ^ this.value.hashCode()); // 17 is a simple number
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof MyEntry) {
            MyEntry obj = (MyEntry) o;
            if(this.key == obj.key && this.hashCode() == obj.hashCode() ) {
                return true;
            }
        }
        return false;
    }
}
