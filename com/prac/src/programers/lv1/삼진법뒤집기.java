package com.prac.src.programers.lv1;

//https://school.programmers.co.kr/learn/courses/30/lessons/68935
public class 삼진법뒤집기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(45);
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public int solution(int n) {
            StringBuilder sb = new StringBuilder(Integer.toString(n, 3));
            String reverse = sb.reverse().toString();
            return Integer.parseInt(reverse, 3);
        }
    }


}
