package com.prac.src.programers.lv1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://school.programmers.co.kr/learn/courses/30/lessons/12922
public class 수박수박수 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String solution1 = solution.solution(3);
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public String solution(int n) {

            String result = "";
            for (int i = 1; i <= n; i++) {
                result += (i % 2 != 0) ? "수" : "박";
            }

            return result;
        }
    }
}
