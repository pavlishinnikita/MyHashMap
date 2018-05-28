package com.nikita.HashMap.CollisionDetect;

import com.nikita.HashMap.MyEntry;

public abstract class AbstractCollisionBehavior {
    public abstract MyEntry collisionDetect(MyEntry[] hashTable ,int index, Object key);
    public abstract MyEntry[] collisionDetect(MyEntry[] hashTable, int index, MyEntry entry);
}
