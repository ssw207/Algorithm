package com.prac.src.programers.lv1;

import java.util.AbstractMap;

/**
 * Created by seungwoo.song on 2022-11-04
 */
public class 콜라병 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int solution1 = solution.solution(2,1,20);
		System.out.println("solution1 = " + solution1);
	}

	static class Solution {
		public int solution(int a, int b, int n) {
			int answer = 0;

			/*
			20
			10 - 10
			5 - 5
			3 - 2
			2 - 1
			0 - 1
			 */
			while (n != 0 && n >= a) {

				if (isNotRest(a, n)) {
					int cnt = getNewCnt(a, b, n);
					n = cnt;
					answer += cnt;
					continue;
				}

				int returnCnt = getNewCnt(a, b, n);
				answer += returnCnt;

				n = returnCnt + getRest(a, n);

				System.out.println("n = " + n);
			}

			return answer;
		}

		private static int getRest(int a, int n) {
			return n % a;
		}

		private int getNewCnt(int toChangeCnt, int returnCnt, int total) {
			return (total / toChangeCnt) * returnCnt;
		}

		private boolean isNotRest(int a, int n) {
			return getRest(a, n) == 0;
		}
	}
}
