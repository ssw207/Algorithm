package com.prac.src.programers.lv2;

import java.util.*;

///https://school.programmers.co.kr/learn/courses/30/lessons/12909
public class 올바른괄호 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean solution1 = solution.solution("(())()");
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        boolean solution(String s) {
            Map<String, String> map = new HashMap<>();
            map.put("(",")");

            Deque<String> stack = new ArrayDeque<>();

            for (String token : s.split("")) {
                if (stack.isEmpty()) {
                    stack.add(token);
                    continue;
                }

                // 같으면 넣는다.
                String peek = stack.peek();
                if (peek.equals(token)) {
                    stack.add(token);
                    continue;
                }

                // 쌍이면 뺀다
                getReverse(map, peek)
                        .filter(pair -> pair.equals(token))
                        .ifPresent(pair -> stack.pop());
            }

            return stack.isEmpty();
        }

        private Optional<String> getReverse(Map<String, String> map, String token) {
            return Optional.ofNullable(map.get(token));
        }
    }
}
