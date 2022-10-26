package com.prac.src.programers.lv2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

///https://school.programmers.co.kr/learn/courses/30/lessons/12909
public class 올바른괄호 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean solution1 = solution.solution(")()(");
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        boolean solution(String s) {
            Deque<String> stack = new ArrayDeque<>();

            for (String token : s.split("")) {
                if (stack.isEmpty()) {
                    stack.add(token);
                    continue;
                }

                String peek = stack.peek();
                
                // 같으면 넣는다
                if (peek.equals(token)) {
                    stack.add(peek);
                    continue;
                }

                // 다르면 뺀다
                stack.pop();
            }

            return stack.isEmpty();
        }
    }
}
