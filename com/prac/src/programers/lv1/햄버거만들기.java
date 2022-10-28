package com.prac.src.programers.lv1;

import java.util.*;

/**
 * Created by seungwoo.song on 2022-10-28
 */
//https://school.programmers.co.kr/learn/courses/30/lessons/133502+
public class 햄버거만들기 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int solution1 = solution.solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3});
		System.out.println("solution1 = " + solution1);
	}

	static class Solution {

		int cnt = 0;

		public int solution(int[] ingredient) {
			Stack<Integer> stack = new Stack<>();

			for (int next : ingredient) {
				if (isPopReady(stack) && next == 1) {
					clear(stack);
					continue;
				}
				stack.add(next);
			}

			return cnt;
		}

		private void clear(Stack<Integer> stack) {
			stack.pop();
			stack.pop();
			stack.pop();
			cnt++;
		}

		private boolean isPopReady(Stack<Integer> stack) {
			return stack.size() > 2
				&& stack.get(stack.size() - 3) == 1
				&& stack.get(stack.size() - 2) == 2
				&& stack.get(stack.size() - 1) == 3;
		}
	}


}
