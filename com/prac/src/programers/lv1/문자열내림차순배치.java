package com.prac.src.programers.lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class 문자열내림차순배치 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String zbcdefg = solution.solution("Zbcdefg");
        System.out.println("zbcdefg = " + zbcdefg);
    }

    static class Solution {
        public String solution(String s) {
            return Arrays.stream(s.split(""))
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.joining());
        }
    }
}
