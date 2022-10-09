package com.prac.src.programers.lv1;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12932
public class 자연수뒤집어배열로만들기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(12345);
        System.out.println("Arrays.toString(solution1) = " + Arrays.toString(solution1));
    }
    
    static class Solution {
        public int[] solution(long n) {
            StringBuilder sb = new StringBuilder();
            sb.append(n);
            sb.reverse();

            return sb.chars()
                    .map(Character::getNumericValue)
                    .toArray();
        }
    }
}
