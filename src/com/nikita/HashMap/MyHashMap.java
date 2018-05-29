package com.nikita.HashMap;

import com.nikita.HashMap.CollisionDetect.AbstractCollisionBehavior;

public class MyHashMap <K, V> {

    private int CAPACITY = 16;
    private float LOAD_FACTOR = 0.75f;
    private int MAX_CAPASITY = Integer.MAX_VALUE / 2;
    private int threshold = (int)(CAPACITY * LOAD_FACTOR); // max value after which table is doubling
    private MyEntry[] table;
    private AbstractCollisionBehavior behavior; // behavior for collision detect

    public void setBehavior(AbstractCollisionBehavior behavior) {
        this.behavior = behavior;
    }

    public MyHashMap(){
        table = new MyEntry[CAPACITY];
    }

    public MyHashMap(int capacity) {
        table = new MyEntry[capacity];
        CAPACITY = capacity;
        threshold = (int)(CAPACITY * LOAD_FACTOR);
    }

    public MyHashMap(int capacity, float loadFactor) {
        table = new MyEntry[capacity];
        CAPACITY = capacity;
        LOAD_FACTOR = loadFactor;
        threshold = (int)(CAPACITY * LOAD_FACTOR);
    }

    /**
     * Method with fake key for calc fake index
     * @param key - original key
     * @param value - original value
     * @param fakeKey - fake key
     * @return true if entry pushed, else - false
     */
    public boolean fakePut(K key, V value, K fakeKey) {
        if (key == null) {
            return false;
        }
        if(behavior.getSize() == threshold) {
            CAPACITY *= 2;
            resize(CAPACITY);
        }
        MyEntry entry = new MyEntry(key, value);
        MyEntry fakeEntry = new MyEntry(fakeKey, value);
        int index = indexOfTable(fakeEntry.hashCode(), table.length);
        table = behavior.collisionDetect(table, index, entry);
        return true;
    }

    public boolean put(K key, V value) {
        if (key == null) {
            return false;
        }
        if(behavior.getSize() == threshold){
            CAPACITY *= 2;
            resize(CAPACITY);
        }
        MyEntry entry = new MyEntry(key, value);
        int index = indexOfTable(entry.hashCode(), table.length);
        table = behavior.collisionDetect(table, index, entry);
        return true;
    }

    public V get(Object key) {
        int hashCode = 31;
        hashCode = hashCode * 17 + key.hashCode();
        try {
            return (V)behavior.collisionDetect(table, indexOfTable(hashCode, table.length), key).getValue();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public int size() {
        return behavior.getSize();
    }

    public void transfer(MyEntry[] newTable) {
        for (MyEntry aTable : table) {
            if (aTable != null) {
                newTable[indexOfTable(aTable.hashCode(), newTable.length)] = aTable;
            }
        }
        table = newTable;
    }

    private void resize(int newCapasity) {
        if (table.length == MAX_CAPASITY) {
            //throw new Exception("Max size has been achieved");
            threshold = Integer.MAX_VALUE - 8;
            return;
        }
        CAPACITY = newCapasity;
        threshold = (int) ( CAPACITY * LOAD_FACTOR );
        MyEntry newTable[] = new MyEntry[newCapasity];
        transfer(newTable);
    }

    private int indexOfTable(int hash, int tableLength) {
        return hash % tableLength;
    }

}