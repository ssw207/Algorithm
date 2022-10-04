package com.prac.src.programers.lv1;

import java.util.Arrays;

public class 평균구하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        double solution1 = solution.solution(new int[]{1, 2, 3, 4});
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public double solution(int[] arr) {
            return Arrays.stream(arr)
                    .average()
                    .getAsDouble();
        }
    }
}
