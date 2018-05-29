package com.nikita.HashMap.CollisionDetect;

import com.nikita.HashMap.MyEntry;

public class OpenAddressing extends AbstractCollisionBehavior {

    @Override
    public MyEntry collisionDetect(MyEntry[] hashTable, int index, Object key) {
        MyEntry entry = null;
        if(hashTable[index].getKey().equals(key)) {
            entry = hashTable[index];
        }
        else {
            for(int i = index + 1; i != index; i = (i + 1) % hashTable.length) {
                if(i >= hashTable.length) {
                    i = 0;
                }
                if(hashTable[i].getKey().equals(key)) {
                    entry = hashTable[i];
                    break;
                }
            }
        }
        return entry;
    }

    @Override
    public MyEntry[] collisionDetect(MyEntry[] hashTable, int index, MyEntry entry) {
        if(hashTable[index] == null) {
            hashTable[index] = entry;
            sizeAdd();
        } else if(hashTable[index].getKey().equals(entry.getKey())) {
            hashTable[index] = entry;
        }
        else {
            for(int i = index + 1; i != index; i = (i + 1) % hashTable.length) {
                if(i >= hashTable.length) {
                    i = 0;
                }
                if(hashTable[i] == null) {
                    hashTable[i] = entry;
                    sizeAdd();
                    break;
                } else if(hashTable[i].getKey().equals(entry.getKey())) {
                    hashTable[i] = entry;
                    break;
                }
            }
        }
        return hashTable;
    }
}
