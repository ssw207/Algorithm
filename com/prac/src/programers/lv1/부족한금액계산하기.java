package com.prac.src.programers.lv1;

//https://school.programmers.co.kr/learn/courses/30/lessons/82612
public class 부족한금액계산하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long result = solution.solution(3, 20, 4);
        System.out.println("result = " + result);
    }

    static class Solution {
        public long solution(int price, int money, int count) {

            long totalPrice = 0;

            for (int i = 1; i <= count; i++) {
                totalPrice += price * i;
            }

            long balance = money - totalPrice;
            return (balance < 0) ? Math.abs(balance) : 0;
        }
    }
}
