package com.example;

import java.util.Arrays;

public class Solution34 {

    public String solution34(String s) {
        String answer = "";
        char[] a = s.toCharArray();
        char[] b = new char[a.length];

        Arrays.sort(a);

        for (int i = a.length - 1; i >= 0; i--) {
            b[a.length - i - 1] = a[i];
        }
        answer = String.valueOf(b);

        return answer;
    }

}
