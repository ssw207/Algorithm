package com.prac.src.programers.lv2;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//https://school.programmers.co.kr/learn/courses/30/lessons/12973
public class 짝지어제거하기 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int solution1 = solution.solution("baabaa");
        System.out.println("solution1 = " + solution1);
    }

    /*
    스텍이 비었으면 넣는다
    스텍이 비지 않았으면 꺼내서 넣으려는 문자열과 같은지 확인하고 같으면 제거
    아니면 스텍에 넣는다
     */
    static class Solution {
        public int solution(String s) {

            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.add(c);
                    continue;
                }

                if (stack.peek() == c) {
                    stack.pop();
                    continue;
                }
                stack.add(c);
            }

            return stack.isEmpty() ? 1 : 0;
        }
    }
}
