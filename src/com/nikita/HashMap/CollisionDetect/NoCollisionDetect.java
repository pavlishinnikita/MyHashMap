package com.nikita.HashMap.CollisionDetect;

import com.nikita.HashMap.MyEntry;

public class NoCollisionDetect extends AbstractCollisionBehavior {

    @Override
    public MyEntry collisionDetect(MyEntry[] hashTable, int index, Object key) {
        return hashTable[index];
    }

    @Override
    public MyEntry[] collisionDetect(MyEntry[] hashTable, int index, MyEntry entry) {
        hashTable[index] = entry;
        return hashTable;
    }
}
