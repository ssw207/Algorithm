package com.prac.src.programers.lv2;

/**
 * Created by seungwoo.song on 2022-11-01
 */
//https://school.programmers.co.kr/learn/courses/30/lessons/12980
public class 점프와순간이동 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int solution1 = solution.solution(6);
		System.out.println("solution1 = " + solution1);
	}

	static public class Solution {
		public int solution(int n) {
			/*
			전프 : 이동+1, 에너지 1
			순간이동 : 이동거리 * 2

			거리5 : 점 (1) 순 (2) 순(4) 점(5)
			거리6 : 점 (1) 순 (2) 점 (3) 순(6)
			거리10 : 점(1) 순(2) 점(4) 순(5) 순(10)
			거리 5000: ... 337(순) 점(674) 순(675) 순(1250) (순)2500 순(5000)

			현재거리 / 2 가 짝수가 아니면 접프

			총 겨리가 짝수일때 순간이동후 현재 거리를 반씩 나누고 나누어떨어지지 않으면 점프를한다
			 */

			int cnt = 0;

			if (n <= 2) {
				return 1;
			}

			while (n > 2){
				if (n % 2 != 0) {
					n--;
					cnt++;
					continue;
				}

				n = n/2;
			}

			return cnt + 1;
		}
	}
}
