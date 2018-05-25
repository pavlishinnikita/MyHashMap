package com.nikita.HashMap;

//запилить для ключей int и значений long
public class MyHashMap <K, V> {

    private int CAPACITY = 16;
    private float LOAD_FACTOR = 0.75f;

    private int threshold = (int)(CAPACITY / LOAD_FACTOR);
    private int size = 0;
    private MyEntry[] table;
    public MyHashMap(){
        table = new MyEntry[CAPACITY];
    }
    public MyHashMap(int capacity) {
        table = new MyEntry[capacity];
        CAPACITY = capacity;
        threshold = (int)(CAPACITY / LOAD_FACTOR);
    }
    public MyHashMap(int capacity, float loadFactor) {
        table = new MyEntry[capacity];
        CAPACITY = capacity;
        LOAD_FACTOR = loadFactor;
        threshold = (int)(CAPACITY / LOAD_FACTOR);
    }
    public void put(K key, V value) {

    }
    public V get(Object key) {
        return null;
    }
    public int size() {
        return table.length;
    }
    private void resize() { // or return new hash table

    }
}