package com.basics.hash;

import java.util.HashMap;

public class HashMapStu {
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("1", "1");
        objectObjectHashMap.put("2", "2");
        objectObjectHashMap.put("3", "3");
        objectObjectHashMap.put("4", "4");
        objectObjectHashMap.put("5", "5");
        Object o = objectObjectHashMap.get("1");
        System.out.println(o.toString());

    }
}
