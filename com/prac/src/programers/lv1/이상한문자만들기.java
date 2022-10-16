package com.prac.src.programers.lv1;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://school.programmers.co.kr/learn/courses/30/lessons/12930
public class 이상한문자만들기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String solution1 = solution.solution(" try  hello world  ");
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public String solution(String s) {
            String words = s.toLowerCase();
            return Arrays.stream(words.split(" ", -1))
                    //.peek(System.out::println)
                    .map(w -> IntStream.range(0, w.length())
                            .mapToObj(i -> {
                                if (i % 2 == 0) {
                                    return (w.charAt(i) + "").toUpperCase();
                                }

                                return w.charAt(i) + "";
                            })
                            .collect(Collectors.joining()))
                    .collect(Collectors.joining(" "));
        }
    }
}
