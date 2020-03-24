package com.example.challenges.etc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Etc {
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(getPrice(new int[]{1, 2, 3, 4, 5}));
        System.out.println(getPrice(new int[]{1, 2, 3, 4, 4}));
        System.out.println(getPrice(new int[]{1, 2, 3, 3, 3}));
        System.out.println(getPrice(new int[]{1, 2, 2, 2, 2}));
        System.out.println(getPrice(new int[]{1, 1, 1, 1, 1}));
        System.out.println(getPrice(new int[]{1, 1, 2, 2, 3}));
        System.out.println(getPrice(new int[]{1, 1, 2, 2, 1}));
    }

    private static int mySqrt(int x) {
        int i=0;
        int j = Integer.MAX_VALUE/2;
        int m = (i+j)/2;
        while(true) {
            if(j-i <= 2) {
                break;
            }
            if(m < x/m) {
                i=m;
                m=(i+j)/2;
            } else if(m > x/m) {
                j=m;
                m=(i+j)/2;
            } else if (m*m == x) {
                return m;
            }
        }
        if(m*m<=x) {
            return m;
        }
        return m-1;
    }

    private static double getPrice(int[] items) {
        List<Set<Integer>> listOfSets = new ArrayList<>();
        for(int item : items) {
            listOfSets.add(new HashSet<>());
        }
        for(int item : items) {
            for(Set<Integer> set : listOfSets) {
                if(!set.contains(item)) {
                    set.add(item);
                    break;
                }
            }
        }

        double price = 0;
        for(Set<Integer> set : listOfSets) {
            if(set.size()==5) {
                price += 8*5*0.8;
            } else if(set.size()==4) {
                price += 8*4*0.85;
            } else if(set.size()==3) {
                price += 8*3*0.9;
            } else if(set.size()==2) {
                price += 8*2*0.95;
            } else if(set.size()==1) {
                price += 8*1;
            }
        }
        return price;
    }
}
