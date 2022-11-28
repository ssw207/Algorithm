package com.prac.src.programers.lv1;

//https://school.programmers.co.kr/learn/courses/30/lessons/133499
public class 옹알이 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int solution1 = solution.solution(new String[] {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"});
        int solution1 = solution.solution(new String[]{"wooyemawooye"});
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        private String[] strings = {"aya", "ye", "woo", "ma"};
        private String[] notValidStrs = {"ayaaya", "yeye", "woowoo", "mama"};

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
            for (String notValidStr : notValidStrs) {
                if (str.contains(notValidStr)) {
                    return false;
                }
            }

            int before = str.length();
            int after = 0;
            while (before != after) {
                for (String string : strings) {
                    before = str.length();
                    str = str.replaceFirst(string, "");
                    after = str.length();
                    //System.out.println("str = " + str);
                }
            }

            return str.equals("");
        }
    }
}

