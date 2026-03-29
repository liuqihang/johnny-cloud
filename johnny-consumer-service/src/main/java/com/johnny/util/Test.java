package com.johnny.util;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> results = new ArrayList<Integer>();
        int[] arrs = {2,2,4,6,5,6,4,6,7,9,7,9};
        int tmp = 0;
        for (int i = 0; i < arrs.length; i++) {
            tmp ^= arrs[i];
        }
        System.out.println(tmp);
    }
}
