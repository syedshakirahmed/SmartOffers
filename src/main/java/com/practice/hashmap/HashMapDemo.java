package com.practice.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<MyObject,Integer> myMap = new HashMap<>();
        MyObject obj1 = new MyObject("10");
        MyObject obj2 = new MyObject("10");
       // System.out.println(obj1.equals(obj2));
        myMap.put(obj1,10);
        myMap.put(obj2,20);
        myMap.entrySet().forEach((k) -> System.out.println(k.getKey().getId()+" "+k.getValue()));

    }
}
