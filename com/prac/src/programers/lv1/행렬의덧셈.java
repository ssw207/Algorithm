package com.prac.src.programers.lv1;

import java.net.SocketImpl;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class 행렬의덧셈 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] arr1 = new int[][] {{1,2}, {2,3}};
		int[][] arr2 = new int[][] {{3,4}, {5,6}};

		int[][] solution1 = solution.solution(arr1, arr2);
		for (int[] ints : solution1) {
			System.out.println("Arrays.toString(solution1) = " + Arrays.toString(ints));
		}
	}

	static class Solution {
		public int[][] solution(int[][] arr1, int[][] arr2) {
			for (int i = 0; i < arr1.length; i++) {
				for (int j = 0; j <arr1[i].length; j++) {
					//System.out.println(String.format("i:%d, j:%d, arr1[i][j]:%d, arr2[i][j]:%d", i,j, arr1[i][j] , arr2[i][j]));
					arr1[i][j] += arr2[i][j];
				}
			}

			return arr1;
		}
	}
}
