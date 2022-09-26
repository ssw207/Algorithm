package com.prac.src.programers.lv1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12931/solution_groups?language=java
public class 자리수더하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(123);
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public int solution(int n) {
            int sum = 0;
            while ( n!= 0) {
                sum += n % 10;
                n /= 10;
            }

            return sum;
        }
    }
}
