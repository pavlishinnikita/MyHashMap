package com.nikita;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        MyHashMap<Integer, Long> myHashMap = new MyHashMap<>(3);
        myHashMap.put(0, (long)10);
        myHashMap.put(10, (long)1);
        myHashMap.put(11, (long)2);
        myHashMap.put(12, (long)3);
        System.out.println(myHashMap.keys());
        System.out.println(myHashMap.values());
        System.out.println(myHashMap.get(0));
        System.out.println(myHashMap.get(10));
        System.out.println(myHashMap.get(11));
        System.out.println(myHashMap.get(12));
    }
    public String testMapDefault(int numb) {
        Map<Integer, String> numbers = new HashMap<>();
        System.out.println(numbers.put(1, "one"));
        numbers.put(2, "two");
        System.out.println(numbers.put(5, "five"));
        numbers.put(3, "three");
        return numbers.get(numb);
    }
}
