package com.edu.sort;

import java.util.Arrays;

public class BubleSort {
	public static void main(String[] args) {
		/**
		 * 버블정렬
		 * 1.변경이 한번도 없을때 까지 반복한다.
		 * 2.i, i+1번째 배열의 값을 비교한다.
		 * 3.i > i+1  이면 i와 i+1의 값을 바꾼다.
		 */
		
		int[] arr = {5,4,3,2,1};
		boolean isChanged = false;
		
		do {
			isChanged = false;
			// 배열의 i+1인덱스를 참조하므로 배열의 길이 -1 번까지 반복한다.
			for (int i = 0; i < arr.length-1; i++) {
				if (arr[i] > arr[i+1]) { // 앞의 배열의 값이 더 크다면 
					// 서로 위치를 바꾼다.
					int tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
					
					isChanged = true; // 변경여부 체크
				}
				System.out.println(Arrays.toString(arr));
			}
		} while (isChanged); // 변경이 일어나지 않을때까지 세트 방복
		
		System.out.println(Arrays.toString(arr));
	}
}
