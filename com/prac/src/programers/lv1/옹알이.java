package com.prac.src.programers.lv1;

//https://school.programmers.co.kr/learn/courses/30/lessons/133499
public class 옹알이 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int solution1 = solution.solution(new String[] {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"});
        int solution1 = solution.solution(new String[]{"wooyemawooye"});
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public int solution(String[] babbling) {
            int answer = 0;

            for (String str : babbling) {
                if (isValidStr(str)) {
                    answer++;
                }
            }
            return answer;
        }

        private boolean isValidStr(String str) {
            String invalidPattern = "(aya|ye|woo|ma)\\1";
            String validPattern = "^(aya|ye|woo|ma)+$";

            if (str.matches(invalidPattern)) {
                return false;
            }

            return str.matches(validPattern);
        }
    }
}

