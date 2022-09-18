package com.prac.src.programers.lv2;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/70129
public class 이진변환반복하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution("01110");
        System.out.println("Arrays.toString(solution1) = " + Arrays.toString(solution1));
    }

    static class Solution {
        public int[] solution(String s) {
            int[] result = new int[2];

            while (!s.equals("1")) {
                //0을 없앤다
                String replaced = s.replaceAll("0", "");

                //삭제한 0의 갯수
                result[1] += s.length() - replaced.length();

                //2진법 변환
                s = Integer.toBinaryString(replaced.length());
                
                //이진변환 횟수
                result[0]++;
            }

            return result;
        }
    }
}
