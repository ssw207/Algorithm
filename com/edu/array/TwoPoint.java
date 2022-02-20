package com.edu.array;

public class TwoPoint {
    /*
    부분합이 M과 일치하는 개수 구하기
    1.시작점 S와 끝점E를 최초 0에 위치한다.
    2.현재 부분합이 M보다 크거나 같다면 E를 1증가 시킨다.
    3.현재 부분합이 M보다 작다면 S를 1증가 시킨다.
    4.현재 부분합이 M과 같다면 카운트한다.
    5.배열의 끝에 이동하면 더이상 이동하지 않는다.
    6.모든경우를 확인할때 까지 반복한다.
    */
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,5}; // 원본 배열
        int end = 0; // 끝포인터
        int sum = 0; // 부분합
        int m = 5; // 목표합
        int n = arr.length; // 전체 데이터 개수
        int result = 0; // 부분합과 목표합이 일치하는 개수

        //end를 끝까지 이동후 start를 순차적으로 한칸씩 이동한다.
        for (int start=0; start < 5; ++start) { // 시작포인터는 순차적으로 1씩 증가 ++start이기때문에 1회전후 1증가한다
            //부분합이 목표보다 작고, end를 끝까지 이동할때까지 반복한다.
            while (sum < m && end < n) {
                //end가 1증가하면 부분합 범위가 커지기 때문에 부분합에 더한다.
                sum += arr[end];
                end++;
            }

            // start ~ end 부분합이 목표합과 같으면 결과값 카운트
            if (sum == m) {
                result++;
            }

            System.out.println(String.format(">>>>start:%d end:%d sum:%d", start,end,sum));

            //start가 1증가하면 부분합 범위가 작아지기때문에 sum에서 빼준다.
            sum -=arr[start];
        }
        System.out.println(result);
    }
}
