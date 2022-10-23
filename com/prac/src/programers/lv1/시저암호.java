package com.prac.src.programers.lv1;

import java.util.HashMap;
import java.util.Map;

//https://school.programmers.co.kr/learn/courses/30/lessons/12926
public class 시저암호 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String solution1 = solution.solution("AaZz", 25);
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public String solution(String s, int n) {
            Character[] arr = {'A','B','C','D','E','F','G','H','I','Z','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], i);
            }

            String answer = "";

            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == ' ') {
                    answer += " ";
                    continue;
                }

                answer += getNext(c, map, n, arr);
            }
            
            return answer;
        }

        private String getNext(char c, Map<Character, Integer> map, int n, Character[] arr) {
            boolean isUpperCase = Character.isUpperCase(c);

            if (!isUpperCase) {
                c = Character.toUpperCase(c);
            }

            int nextIdx = map.get(c) + n;

            if (nextIdx >= 26) {
                nextIdx -= 26;
            }

            if (!isUpperCase) {
                return (arr[nextIdx] + "").toLowerCase();
            }

            return arr[nextIdx] + "";
        }
    }
}
