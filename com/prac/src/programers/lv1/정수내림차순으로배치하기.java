package com.prac.src.programers.lv1;

import java.util.Arrays;

/**
 * Created by seungwoo.song on 2022-09-29
 */
//https://school.programmers.co.kr/learn/courses/30/lessons/12933
public class 정수내림차순으로배치하기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        long solution1 = solution.solution(523512);
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public long solution(long n) {
            int[] arr = getArr(n);
            for (int i = 1; i < arr.length; i++) { // 1번 인덱스부터 시작
                switchValue(arr, i);
//                System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
            }

            return getResult(arr);
        }

        private void switchValue(int[] arr, int i) {
            for (int j = i; j >= 1; j--) { // i번째부터 0번까지 왼쪽으로 순회
//                System.out.println("i =" + i +" j = " + j);
                if (isNotSwith(arr[j], arr[j -1])) { // 삽입위치 판단
                    break;
                }

                swithLeft(arr, j); // 왼쪽과 자리교체
            }
        }

        private void swithLeft(int[] arr, int nowPosition) {
            int leftPosition = nowPosition - 1;
            int leftValue = arr[leftPosition];
            arr[leftPosition] = arr[nowPosition];
            arr[nowPosition] = leftValue;
        }

        private boolean isNotSwith(int now, int left) {
//            System.out.println("now = " + now + " left :" + left + " now > left "+ (now > left));
            return now < left;
        }

        private Long getResult(int[] arr) {
            String result = "";

            for (int i : arr) {
                result += i;
            }
            return Long.valueOf(result);
        }

        private int[] getArr(long n) {
            String s = n + "";
            int[] arr =new int[s.length()];
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                arr[i] = Character.getNumericValue(chars[i]);
            }

            return arr;
        }
    }
}
