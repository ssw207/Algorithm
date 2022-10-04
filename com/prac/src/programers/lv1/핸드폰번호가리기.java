package com.prac.src.programers.lv1;

public class 핸드폰번호가리기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String solution1 = solution.solution("01033334444");
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public String solution(String phone_number) {
            char[] chars = phone_number.toCharArray();
            for (int i = 0; i < chars.length - 4; i++) {
                chars[i] = '*';
            }

            return String.valueOf(chars);
        }
    }
}
