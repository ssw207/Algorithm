package com.prac.src.programers.lv2;

//https://school.programmers.co.kr/learn/courses/30/lessons/12939
public class 최댓값과최솟값 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String solution1 = solution.solution("1 2 3 4");
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public String solution(String s) {
            String[] s1 = s.split(" ");

            int max = 0;
            int min = 0;
            for (String s2 : s1) {
                Integer num = Integer.valueOf(s2);
                max = (max == 0) ? num : Integer.max(num, max);
                min = (min == 0) ? num : Integer.min(num, min);
            }

            return min + " " + max;
        }
    }
}
