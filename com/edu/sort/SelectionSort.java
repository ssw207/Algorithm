package com.edu.sort;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		/**
		 * 선택정렬
		 * 1.배열의 모든 값을 순회
		 * 2.배열의 값을 하나 꺼내고 나머지 배열의 값들과 비교해서 최소값을 찾는다.
		 * 3.최소값과 현재값을 변경한다.
		 * 4.세트중 한번도 최소값이 변경되지 않으면 정렬을 중단한다.  
		 */
		int[] arr = {1,4,5,2,3};
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("===============세트 : "+i);
			int min = arr[i];
			int minIdx = 0;
			boolean isChanged = false;
			
			for (int j = i+1; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					minIdx = j;
					isChanged = true;
				}
			}
			System.out.println("최소값 "+min);
			System.out.println("최소값idx "+minIdx);
			
			//교환
			if (isChanged) {
				int tmp = arr[i];
				arr[i] = arr[minIdx];
				arr[minIdx] = tmp;
				System.out.println("변경 "+Arrays.toString(arr));
			} 
		}
		
	}
}
