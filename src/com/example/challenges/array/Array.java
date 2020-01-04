package com.example.challenges.array;

import java.util.HashMap;
import java.util.Map;

public class Array {
    public static void main(String[] args) {
        int [] arr1 = {1, 2, 3, 2, 1, 2};
        System.out.println(getMaxFrequency(arr1));
    }

    public static Integer getMaxFrequency(int[] arr) {
        Integer maxElem = null;
        Integer maxFreq = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num)+1);
                if(map.get(num) > maxFreq) {
                    maxFreq = map.get(num);
                    maxElem = num;
                }
            } else {
                map.put(num, 1);
            }
        }
        return maxElem;
    }
}
