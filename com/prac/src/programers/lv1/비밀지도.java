package com.prac.src.programers.lv1;

import java.util.Arrays;

/**
 * Created by seungwoo.song on 2022-09-08
 */
//https://school.programmers.co.kr/learn/courses/30/lessons/17681
public class 비밀지도 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {9, 20, 28, 18, 11};
		int[] arr2= {30, 1, 21, 17, 28};
		String[] solution1 = solution.solution(5, arr, arr2);
		System.out.println("Arrays.toString(solution1) = " + Arrays.toString(solution1));
	}

	static class Solution {
		public String[] solution(int n, int[] arr1, int[] arr2) {
			String[] result = new String[n];
			for (int i = 0; i < n; i++) {
				String line1 = convert(arr1[i], n);
				String line2 = convert(arr2[i], n);
				result[i] = getDecryptLine(line1, line2, n);
			}

			return result;
		}

		private String getDecryptLine(String line1, String line2, int n) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				String mark = getMark(line1.charAt(j), line2.charAt(j));
				sb.append(mark);
			}

			return sb.toString();
		}

		private String getMark(char mark1, char mark2) {
			return (mark1 == '0' && mark2 == '0') ? " " : "#";
		}

		public String convert(int input, int num) {
			return lpad(Integer.toBinaryString(input), num);
		}

		private String lpad(String str, int num) {
			StringBuilder sb = new StringBuilder();

			int diff = num - str.length();
			for (int i = 0; i < diff; i++) {
				sb.append("0");
			}
			sb.append(str);

			return sb.toString();
		}
	}
}
