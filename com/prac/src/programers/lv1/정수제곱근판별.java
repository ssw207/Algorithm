package com.prac.src.programers.lv1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12934
public class 정수제곱근판별 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long solution1 = solution.solution(121);
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public long solution(long n) {
            long pow = (long) (Math.sqrt(n));
            if ((pow * pow) == n) {
                return (long) Math.pow(pow + 1, 2);
            }

            return -1;
        }
    }
}
