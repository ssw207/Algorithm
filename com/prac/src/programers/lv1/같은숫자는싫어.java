package com.prac.src.programers.lv1;

import java.nio.file.StandardWatchEventKinds;
import java.util.Arrays;
import java.util.Stack;

//https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class 같은숫자는싫어 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,1,3,3,0,1,1};
        int[] result = solution.solution(arr);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result)); //1,3,0,1
    }
    public static class Solution {
        public int[] solution(int []arr) {
            Stack<Integer> stack = new Stack<>();
            for (int i : arr) {
                // 마지막 숫자와 다른경우만 넣는다
                if (stack.empty() || stack.peek() != i) {
                    stack.add(i);
                }
            }

            return stack.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
