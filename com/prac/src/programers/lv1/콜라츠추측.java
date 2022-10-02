package com.prac.src.programers.lv1;

public class 콜라츠추측 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(626331);
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public int solution(long num) {
            int cnt = 0;
            while (num != 1) {

                if (num %2 == 0) {
                    num = num / 2;
                } else {
                    num = (num * 3) + 1;
                }
                cnt++;

                if (cnt == 500) {
                    return -1;
                }
                System.out.println("num = " + num);
            }

            return cnt;
        }
    }
}


