package com.prac.src.programers.lv1;

import java.util.Arrays;

/**
 * Created by seungwoo.song on 2022-10-04
 */
//https://school.programmers.co.kr/learn/courses/30/lessons/12935
public class 제일작은수제거 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new int[]{4, 3, 2, 1});
        System.out.println("Arrays.toString(solution1) = " + Arrays.toString(solution1));
    }

    static class Solution {
        public int[] solution(int[] arr) {
            if (arr.length <= 1) {
                return new int[] {1};
            }

            final int min = Arrays.stream(arr)
                    .min()
                    .getAsInt();

            return Arrays.stream(arr)
                    .filter(i -> i != min)
                    .toArray();
        }
    }
}
