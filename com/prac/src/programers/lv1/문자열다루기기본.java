package com.prac.src.programers.lv1;

import javax.lang.model.SourceVersion;

/**
 * Created by seungwoo.song on 2022-10-12
 */
//https://school.programmers.co.kr/learn/courses/30/lessons/12918
public class 문자열다루기기본 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean solution1 = solution.solution("12345");
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public boolean solution(String s) {
            if (!(s.length() == 4 || s.length() == 6)) {
                return false;
            }

            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }

            return true;
        }
    }

}
