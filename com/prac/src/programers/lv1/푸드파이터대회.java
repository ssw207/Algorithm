package com.prac.src.programers.lv1;

/**
 * Created by seungwoo.song on 2022-11-08
 */
//https://school.programmers.co.kr/learn/courses/30/lessons/134240
public class 푸드파이터대회 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		String solution1 = solution.solution(new int[] {1, 3, 4, 6});
		System.out.println("solution1 = " + solution1);
	}

	static class Solution {
		public String solution(int[] food) {
			StringBuilder sb = getToEatFood(food);
			String foodStr = sb.toString();
			String foodStr2 = sb.reverse().toString();

			return foodStr + "0" + foodStr2;
		}

		private StringBuilder getToEatFood(int[] food) {
			StringBuilder sb = new StringBuilder();

			for (int i = 1; i < food.length; i++) {
				int cnt = food[i] / 2;
				sb.append(String.valueOf(i).repeat(cnt));
			}

			return sb;
		}
	}
}
