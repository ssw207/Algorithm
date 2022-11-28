package com.prac.src.programers.lv2;


import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class 카펫 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] solution1 = solution.solution(24, 24);
        System.out.println(Arrays.toString(solution1));
    }

    /*
        리턴은 가로 * 세로 => 리턴의 곱 = b + y
        가로는 세로보다 같거나 길어야 한다

        1. 숫자를 나누어떨어지는 수를 구한다. (약수)
           - 가로, 세로는 3 이상이다
           - 합에서 3보다 큰수를 순차적으로 나눠서 떨어지는 수를 찾는다.
        2. 쌍중에 큰값을 가로, 짧은값을 세로에 할당한다
     */
    static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = {};

            int sum = brown + yellow;
            int num = getTargetNumber(sum);
            int num2 = (sum / num);

            if (num < num2) {
                return new int[] {num2, num};
            }

            return new int[] {num, num2};
        }

        private int getTargetNumber(int sum) {
            for (int i = 3; i < sum; i++) {
                if (sum % i == 0) {
                    return i;
                }
            }

            throw new IllegalArgumentException();
        }
    }
}
