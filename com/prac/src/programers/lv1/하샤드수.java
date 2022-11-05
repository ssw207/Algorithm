package com.prac.src.programers.lv1;

/**
 * Created by seungwoo.song on 2022-11-03
 */
//https://school.programmers.co.kr/learn/courses/30/lessons/12947
public class 하샤드수 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		boolean solution1 = solution.solution(12);
		System.out.println("solution1 = " + solution1);

	}

	static class Solution {
		public boolean solution(int x) {
			boolean answer = true;

			//자리수를 더하는 기능
			//합산 % 자리수합 == 0인지 판단하면 true

			int sum = 0;
			String[] split = (x + "").split("");
			for (String s : split) {
				sum += Integer.parseInt(s);
			}

			return x % sum == 0;
		}
	}
}
