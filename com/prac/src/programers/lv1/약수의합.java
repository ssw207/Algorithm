package com.prac.src.programers.lv1;

/**
 * Created by seungwoo.song on 2022-10-25
 */
//https://school.programmers.co.kr/learn/courses/30/lessons/12928
public class 약수의합 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int solution1 = solution.solution(12);
		System.out.println("solution1 = " + solution1);
	}

	static class Solution {
		public int solution(int num) {
			int total = 0;
			for (int i = 1; i <= num; i++) {
				if (num % i == 0) {
					System.out.println("i = " + i);
					total += i;
				}
			}

			return total;
		}
	}

}
