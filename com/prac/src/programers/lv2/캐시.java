package com.prac.src.programers.lv2;

import java.util.*;

/**
 * Created by seungwoo.song on 2022-11-02
 */
//https://school.programmers.co.kr/learn/courses/30/lessons/17680
public class 캐시 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int solution1 = solution.solution(5, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"});
		System.out.println("solution1 = " + solution1);
	}

	/*
		캐시가 힛하는 경우
			가장 첫순서로 끌어올린다
		캐시가 빗나가고 캐시가 꽉찬경우
			가장 마지막 값을 삭제한뒤 캐시를 추가한다
		캐시가 빗나가고 캐시가 여유가 있는경우
			캐시를 추가한다
	 */
	static class Solution {

		Set<String> cache = new LinkedHashSet<>();

		public int solution(int cacheSize, String[] cities) {

			int answer = 0;

			for (String city : cities) {
				city = city.toLowerCase();

				boolean cashHit = cache.contains(city);
				answer += cashHit ? 1 : 5;

				if (cashHit) {
					goToTop(city);
					continue;
				}

				if (cache.size() == cacheSize) {
					removeOldest();
				}

				cache.add(city);
			}

			return answer;
		}

		private void removeOldest() {
			for (String s : cache) {
				cache.remove(s);
				break;
			}
		}

		private void goToTop(String city) {
			cache.remove(city);
			cache.add(city);
		}

	}
}

