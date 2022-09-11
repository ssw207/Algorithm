package com.prac.src.programers.lv1;

/**
 * Created by seungwoo.song on 2022-09-08
 */
public class 짝수와홀수 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		String solution1 = solution.solution(3);
		System.out.println("solution1 = " + solution1);
	}

	static class Solution {
		public String solution(int num) {
			return num % 2 == 0 ? "Even" : "Odd";
		}
	}
}
