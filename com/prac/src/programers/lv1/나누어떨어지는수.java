package com.prac.src.programers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/12910
public class 나누어떨어지는수 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new int[]{5, 9, 7, 10}, 5);
        System.out.println("Arrays.toString(solution1) = " + Arrays.toString(solution1));
    }

    static class Solution {
        public int[] solution(int[] arr, int divisor) {
            return Arrays.stream(arr)
                    .filter(i -> i % divisor == 0)
                    .toArray();
        }
    }
}
