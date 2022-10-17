package com.prac.src.programers.lv1;

import java.net.SocketImpl;
import java.util.Arrays;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class 행렬의덧셈 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] arr1 = new int[][] {{1,2}, {1,2}};
		int[][] arr2 = new int[][] {{3,4}, {5,6}};

		int[][] solution1 = solution.solution(arr1, arr2);
		System.out.println("Arrays.toString(solution1) = " + Arrays.toString(solution1));
	}

	static class Solution {
		public int[][] solution(int[][] arr1, int[][] arr2) {
			int[][] answer = {};
			return answer;
		}
	}
}
