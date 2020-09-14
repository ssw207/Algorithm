package sort;

import java.util.Arrays;

public class InsertsionSort {
  public static void main(String[] args) {
	  /**
	   * 삽입정렬
	   * 1.배열에서 비교할 값을 추출한다.
	   * 2.이전값들과 추출한 값을 비교한다.
	   * 3.이전값이 더 크면 이전값을 우측으로 밀어낸다.
	   * 4.배열의 첫번째가 공백이 되거나 이전값보다 추출값이 크면 공백의 위치 추출값을 삽입한다.
	   * 5.배열의 인덱스1 ~ 마지막 인덱스 까지 순회한다.
	   */
	  
	  int[] arr = {5,4,3,2,1};
	  System.out.println("시작");
	  for (int i = 1; i < arr.length; i++) {
		  System.out.println("============="+i);
		  int targetValue = arr[i]; // 정렬값
		  int emptyPosision = i; // 공백위치
		  int compareValue = 0;
		  
		  do {
			  compareValue = arr[emptyPosision-1]; // 비교값 
			  arr[emptyPosision] = compareValue; // 값 우측이동
			  emptyPosision--; // 공백위치 이동 
			  System.out.println("순회 "+Arrays.toString(arr));
		  } while (emptyPosision != 0 && targetValue < compareValue);
		  
		  
		  arr[emptyPosision] = targetValue;
		  System.out.println("삽입 "+Arrays.toString(arr));
	  }
  }
}
