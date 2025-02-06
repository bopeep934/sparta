package com.example;

public class Solution36 {
    public boolean solution36(String s) {
        boolean answer = true;
        if (s.length() != 4 && s.length() != 6)
            answer = false;
        else {
            answer = s.chars().allMatch(Character::isDigit);
        }
        return answer;
    }
}