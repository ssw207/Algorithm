package com.prac.src.programers.lv1;

import javax.management.BadAttributeValueExpException;
import java.util.Set;

//https://school.programmers.co.kr/learn/courses/30/lessons/133499
public class 옹알이 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int solution1 = solution.solution(new String[] {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"});
        int solution1 = solution.solution(new String[] {"ayaye"});
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        private String[] strings = {"aya", "ye", "woo", "ma"};

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
            String s = "";
            for (String string : strings) {
                s = str.replaceFirst(string, "");
                System.out.println("string = " + s);
            }

            return s.equals("");
        }
    }
}

