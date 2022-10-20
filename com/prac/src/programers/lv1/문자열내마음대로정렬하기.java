package com.prac.src.programers.lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by seungwoo.song on 2022-10-19
 */
//https://school.programmers.co.kr/learn/courses/30/lessons/12915
public class 문자열내마음대로정렬하기 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] solution1 = solution.solution(new String[] {"abce", "abcd", "cdx"}, 2);
		System.out.println("solution1 = " + Arrays.toString(solution1));
	}

	static class Solution {
		public String[] solution(String[] strings, int n) {
			return Arrays.stream(strings)
				.sorted(Comparator.<String, String>comparing(s -> s.charAt(n)+"").thenComparing(s -> s))
				.collect(Collectors.toList())
				.toArray(s -> new String[strings.length]);
		}
	}
}
