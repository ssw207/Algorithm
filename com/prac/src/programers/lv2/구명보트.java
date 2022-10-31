package com.prac.src.programers.lv2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by seungwoo.song on 2022-10-31
 */
//https://school.programmers.co.kr/learn/courses/30/lessons/42885
public class 구명보트 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int solution1 = solution.solution(new int[] {70, 80, 50}, 100);
		System.out.println("solution1 = " + solution1);
	}

	//정렬후 가장 작은값과 가장 큰값의 합이 limit 보다 크다면 가장 큰값은 혼자타야한다.
	static class Solution {

		public int solution(int[] people, int limit) {
			int answer = 0;

			Deque<Integer> deque = init(people);

			while (!deque.isEmpty()) {
				Integer first = deque.peekFirst();
				Integer last = deque.pollLast();

				int sum = last + first;
				if (!deque.isEmpty() && sum <= limit) {
					deque.pollFirst();
				}

				answer++;
			}

			return answer;
		}

		private Deque<Integer> init(int[] people) {
			Arrays.sort(people);

			Deque<Integer> deque = new ArrayDeque<>(50505);
			for (int integer : people) {
				deque.add(integer);
			}

			return deque;
		}
	}
}
