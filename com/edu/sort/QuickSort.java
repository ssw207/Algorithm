package com.edu.sort;

import java.util.Arrays;

public class QuickSort {
	private int[] arr;
	
	public static void main(String[] args) {
		int[] arr= {0,5,2,1,6,3};
		QuickSort q = new QuickSort(arr);
		q.sort();
		System.out.println(Arrays.toString(q.getArr()));
	}
	
	public QuickSort(int[] arr) {
		this.arr = arr;
	}
	
	public int[] getArr() {
		return arr;
	}

	private void sort() {
		division();
	}

	/*
	 * 분할 : 배열의 임의의 수를 가져와(이하 피벗) 
	 * 피벗보다 작은 수를 피벗의 왼쪽 피벗보다 큰 수를 피벗의 오르쪽에 둔다.
	 * 
	 * ex)
	 * 정렬할 배열 {0,5,2,1,6,3}
	 * 
	 * 최초 분할
	 * 최초 피벗 3
	 * 왼쪽포인터 0 , 오른쪽 포인터 6
	 * 1.왼쪽 포인터의 값이 피벗의 값 보다 작으면 왼쪽포인터 오른쪽으로 1이동
	 * 2.오른쪽 포인터의 값이 피벗의 값 보다 크면 오른쪽 포인터 왼쪽으로 1이동
	 * 3.왼쪽포인터 > 오른쪽 포인터 이면 포인터들의 값 교환 
	 * 4.왼쪽포인터 오른쪽으로 이동후 피벗보다 크거나 같은 값이 나올때 까지 오른쪽으로 이동
	 * 5.왼쪽포인터와 오른쪽 포인터의 값이 같으면 중지
	 * 6.왼쪽 포인터값과 피벗 교환 
	 * 
	 */
	private void division() {
		int pivot = arr.length-1;
		int left_pointer = 0; 
		int right_pointer = arr.length-2;
		
		System.out.println("1.초기값");
		System.out.println("피벗 : "+pivot);
		System.out.println("left_pointer : "+left_pointer);
		System.out.println("right_pointer : "+right_pointer);
		System.out.println("arr :"+Arrays.toString(arr));
		
		//포인터이동
		while (arr[left_pointer] < arr[pivot]) {
			left_pointer++;
		}
		
		System.out.println("2.왼쪽포인터 이동");
		System.out.println("left_pointer : "+left_pointer);
		
		while (arr[right_pointer] > arr[pivot]) {
			right_pointer--;
		}
		
		System.out.println("2-1.오른쪽 포인터 이동");
		System.out.println("right_pointer : "+right_pointer);
		
		// 교환
		if (arr[left_pointer] > arr[right_pointer]) {
			swap(left_pointer, right_pointer);
		}
		
		System.out.println("3.교환후 값");
		System.out.println(Arrays.toString(arr));
		
		while (arr[left_pointer] < arr[pivot]) {
			left_pointer++;
		}
		
		System.out.println("4.왼쪽포인터 이동");
		System.out.println("left_pointer : "+left_pointer);
		
		//교환
		swap(left_pointer, pivot);
		
		System.out.println("5.교환후 값");
		System.out.println(Arrays.toString(arr));
	}

	private void swap(int left_pointer, int right_pointer) {
		int tmp = arr[left_pointer];
		arr[left_pointer] = arr[right_pointer];
		arr[right_pointer] = tmp;
	}
}
