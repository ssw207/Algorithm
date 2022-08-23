package com.prac.src.programers.lv1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class 최소직사각형 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int rs = solution.solution(sizes);
        System.out.println("rs = " + rs);
    }

    static class Solution {
        public int solution(int[][] sizes) {

            for (int[] size : sizes) {
                Arrays.sort(size);
            }

            int widthMax = 0;
            int heightMax = 0;
            for (int[] size : sizes) {
                widthMax = Math.max(size[0], widthMax);
                heightMax = Math.max(size[1], heightMax);
            }

            return widthMax * heightMax;
        }
    }
}
