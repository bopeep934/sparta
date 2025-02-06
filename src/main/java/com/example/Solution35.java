package com.example;

public class Solution35 {

    public long solution35(int price, int money, int count) {

        long answer = -1;
        long expense = 0;
        for (int i = 0; i < count; i++) {
            expense += price * (count - i);
        }
        if (money - expense > 0)
            answer = 0;
        else answer = expense - money;

        return answer;
    }
}
