package com.nikita;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }
    public int pow(int a, int b){
        if(b == 0) {
            return 1;
        }
        return a * pow(a, b-1);
    }
    public String testMap(int numb) {
        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        return numbers.get(numb);
    }
}
