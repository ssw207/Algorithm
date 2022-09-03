package com.prac.src.programers.lv1;

import javax.security.auth.Subject;

//https://school.programmers.co.kr/learn/courses/30/lessons/12903
public class 가운데글자가져오기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution("qwer");
        System.out.println("result = " + result);
    }

    static class Solution {
        public String solution(String s) {
            boolean isEven = ((s.length() % 2) == 0);

            int idx = s.length() / 2;
            if (isEven) {
                return s.substring(idx -1, idx+1);
            } else {
                return s.charAt(idx) + "";
            }
        }
    }
}
