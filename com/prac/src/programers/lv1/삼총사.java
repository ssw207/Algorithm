package com.prac.src.programers.lv1;

//https://school.programmers.co.kr/learn/courses/30/lessons/131705
public class 삼총사 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[] {-2, 3, 0, 2, -5});
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public int solution(int[] number) {
            int cnt = 0;

            for (int i = 0; i < number.length; i++) {
                for (int j = i+1; j < number.length; j++) {
                    for (int k = j+1; k < number.length ; k++) {
                        if ((number[i] + number[j] + number[k]) == 0) {
                            cnt++;
                        }
                    }
                }
            }

            return cnt;
        }
    }
}
