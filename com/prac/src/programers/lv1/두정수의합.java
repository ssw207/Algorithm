package com.prac.src.programers.lv1;

public class 두정수의합 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long solution1 = solution.solution(-1000000, 10000000);
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public long solution(int a, int b) {
            int fst = a;
            int lst = b;

            if (b < a) {
                fst = b;
                lst = a;
            }

            long sum =0;
            for (int i=fst; i<=lst; i++) {
                sum += i;
            }

            return sum;
        }
    }
}
