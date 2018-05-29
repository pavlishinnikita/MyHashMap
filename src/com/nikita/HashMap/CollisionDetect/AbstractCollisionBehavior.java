package com.nikita.HashMap.CollisionDetect;

import com.nikita.HashMap.MyEntry;

/**
 * Parent class for all behavior
 */
public abstract class AbstractCollisionBehavior {

    /**
     * count for hash table elements
     */
    private int size = 0;
    /**
     * override this method for get entry
     * @param hashTable - source table
     * @param index - index for get in table
     * @param key - key for search
     * @return entry for key and index
     */
    public abstract MyEntry collisionDetect(MyEntry[] hashTable, int index, Object key);

    /**
     * override this method for put entry
     * @param hashTable - source table
     * @param index - index for get in table
     * @param entry - entry for put to table
     * @return entry for key and index
     */
    public abstract MyEntry[] collisionDetect(MyEntry[] hashTable, int index, MyEntry entry);

    /**
     * Method for increment size
     */
    void sizeAdd() {
        size++;
    }

    /**
     *
     * @return count of hash table elements
     */
    public int getSize() {
        return size;
    }
}
