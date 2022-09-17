package com.prac.src.programers.lv2;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/12951
public class JadenCase문자열만들기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String solution1 = solution.solution(" 3people unFollowed  me ");
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public String solution(String s) {
            String[] words = s.toLowerCase().split(" ", -1);
            System.out.println("Arrays.toString(words) = " + Arrays.toString(words));
            return Arrays.stream(words)
                    .map(word -> {
                        if (word.length() == 0) return word;
                        return (word.charAt(0) + "").toUpperCase() + word.substring(1);
                    })
                    .collect(Collectors.joining(" "));
        }
    }
}
