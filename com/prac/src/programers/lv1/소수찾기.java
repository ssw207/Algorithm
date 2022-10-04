package com.prac.src.programers.lv1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12921
public class 소수찾기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(10);
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public int solution(int n) {
            int cnt = 0;
            for (int i = 2; i <= n; i++) {
                if (isPrime(i)) {
                    cnt++;
                }
            }

            return cnt;
        }

        public boolean isPrime(int n) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
