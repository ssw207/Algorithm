package com.prac.src.programers.lv1;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12919
public class 서울에서김서방찾기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String solution1 = solution.solution(new String[]{"Jane", "Kim"});
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public String solution(String[] seoul) {
            for (int i = 0; i < seoul.length; i++) {
                String s = seoul[i];
                if (s.equals("Kim")) {
                    return String.format("김서방은 %d에 있다", i);
                }
            }

            return "";
        }
    }
}
