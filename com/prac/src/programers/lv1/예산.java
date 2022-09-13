package com.prac.src.programers.lv1;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/1845
public class 예산 {
    public static void main(String[] args) {
        예산 init = new 예산();
        int[] nums = {1,3,2,5,4}; // 항상짝수
        int budget = 9;
        int result = init.solution(nums, budget);
        System.out.println(result);
    }

    public int solution(int[] d, int budget) {
        int cnt = 0;

        Arrays.sort(d);
        for (int i : d) {
            budget = budget - i;

            if (budget >= 0) {
                cnt++;
            } else {
                break;
            }
        }

        return cnt;
    }
}
