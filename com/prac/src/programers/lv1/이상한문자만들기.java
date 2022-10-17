package com.prac.src.programers.lv1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12930
public class 이상한문자만들기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String solution1 = solution.solution(" try  hello world  ");
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public String solution(String s) {
            String[] split = s.toLowerCase().split("");

            int index = 0;
            String result = "";

            for (String token : split) {
                index = (token.equals(" ")) ? 0 : index + 1;
                result += (index % 2 == 0) ? token : token.toUpperCase();
            }

            return result;
        }
    }
}
