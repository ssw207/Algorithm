package com.prac.src.programers.lv1;

import java.util.Arrays;
import java.util.List;

/**
 * Created by seungwoo.song on 2022-10-11
 */
public class x만큼간격이있는n개의숫자 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long[] solution1 = solution.solution(-1, 2);
        System.out.println("solution1 = " + Arrays.toString(solution1));
    }

    static class Solution {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];
            answer[0] = x;
            for (long i = 1; i < n; i++) {
                answer[(int)i] = answer[(int)i - 1] + x;
            }

            return answer;
        }
    }
}
