package com.prac.src.programers.lv2;

import java.util.*;

public class 올바른괄호 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean solution1 = solution.solution("()()");
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        boolean solution(String s) {
            Deque<Character> stack = new ArrayDeque<>();

            for (char token : s.toCharArray()) {
                // 초기값이면 넣는다
                if (stack.isEmpty()) {
                    stack.add(token);
                    continue;
                }

                char peek = stack.peek();
                if (')' == peek && '(' == token) {
                    return false;
                }

                // 같으면 넣는다.
                if (peek==(token)) {
                    stack.add(token);
                    continue;
                }

                // 쌍이면 뺀다
                if ('(' == stack.peek() && ')'== token) {
                    stack.pop();
                    continue;
                }

                stack.add(token);
            }

            return stack.isEmpty();
        }
    }
}
///https://school.programmers.co.kr/learn/courses/30/lessons/12909
