package com.nikita;

import com.nikita.HashMap.CollisionDetect.NoCollisionDetect;
import com.nikita.HashMap.CollisionDetect.OpenAddressing;
import com.nikita.HashMap.MyHashMap;


public class Main {

    public static void myExtend(){

        MyHashMap<Integer, Long> myHashMap = new MyHashMap<>();
        myHashMap.setBehavior(new NoCollisionDetect());
        myHashMap.put(1, (long) 10);
        myHashMap.put(0, (long) 0);
        myHashMap.put(2, (long) 20);
        myHashMap.put(3, (long) 30);
        myHashMap.put(4, (long) 40);
        myHashMap.put(5, (long) 50);
        myHashMap.fakePut(6, (long) 60, 3);
        myHashMap.fakePut(7, (long) 60, 5);
        System.out.println("For key: " + 6 + " value is: " + myHashMap.get(6));
        System.out.println("For key: " + 3 + " value is: " + myHashMap.get(3));
        System.out.println("And size map is: " + myHashMap.size());
    }

    public static void main(String[] args) {
        myExtend();
    }
}
