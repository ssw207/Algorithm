package sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

	/*
	 * 
	 * 정렬할 배열 {0,5,2,1,6,3}
	 * 
	 * 최초 분할
	 * 최초 피벗 3
	 * 왼쪽포인터 0 , 오른쪽 포인터 6
	 * 1.피벗(3)보다 크거나 같은 값이 나올때 까지 왼쪽포인터 오른쪽으로 이동(5)후 멈춤
	 * 2.피벗(3)보다 작거나 같은 값이 나올때 까지 오른쪽 포인터 왼쪽으로 이동(1)후 멈춤
	 * 3.왼쪽포인터 > 오른쪽 포인터 이면 포인터들의 값 교환 
	 * 4.왼쪽포인터 오른쪽으로 이동후 피벗보다 크거나 같은 값이 나올때 까지 오른쪽으로 이동
	 * 5.왼쪽포인터와 오른쪽 포인터의 값이 같으면 중지
	 * 6.왼쪽 포인터값과 피벗 교환 
	 * 
	 */
	private void mian() {
		int[] arr= {0,5,2,1,6,3};
		quickSort(arr);
	}

	private int[] quickSort(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : arr) {
			list.add(i);
		}
		
		int pivot = list.get(list.size()-1);
		list.remove(list.size()-1);
		
		int left_pointer = list.get(0); 
		int right_pointer = list.get(list.size()-1);
				
		return null;
	}
	
	
}
