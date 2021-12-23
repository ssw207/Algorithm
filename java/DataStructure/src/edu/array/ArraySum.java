package array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraySum {
    /*
    배열의 구간 합을 쉽게 구하는 알고리즘
    1.배열의 구간별 합을 구해서 PrefixSum테이블에 저장한다 ex) 0까지 합, 1까지합, 2까지합 ... N까지합
    2.L에서 R까지 구간합을 구할떄 P[R]-P[L-1] 로 빠르게 계산 가능하다
    3.시간복잡도 O(N + M)
    */
    public static void main(String[] args) {
        int[] data = {10,20,30,40,50}; // 주어진 값

        //PrefixSum 테이블 구하기
        // 배열생성
        int[] prefixSum = new int[data.length+1];

        // 구간합 구하기
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
            prefixSum[i+1] = sum; // 최초 0부터 시작하기위해 인덱스 1부터 저장한다.
        }

        System.out.println(Arrays.toString(prefixSum));

        //구간합 구하기
        int left = 0;
        int right = 1;
        System.out.println(prefixSum[right] - prefixSum[left]);
    }
}
