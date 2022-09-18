package com.prac.src.programers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/70129
public class 이진변환반복하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution("01110");
        System.out.println("Arrays.toString(solution1) = " + Arrays.toString(solution1));
    }

    static class Solution {
        public int[] solution(String s) {
            String rs = s;
            int total = 0;
            int replace = 0;

            while (!rs.equals("1")) {
                //0갯수 확인
                replace += getOneCount(rs);

                //0을 없앤다
                int length = rs.replaceAll("0", "").length();

                //2진법 변환
                rs = Integer.toBinaryString(length);
                total++;
            }

            return new int[] {total, replace};
        }

        private int getOneCount(String s) {
            int cnt = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    cnt ++;
                }
            }
            return cnt;
        }
    }
}
