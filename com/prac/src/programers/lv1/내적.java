package com.prac.src.programers.lv1;

//https://programmers.co.kr/learn/courses/30/lessons/70128
public class 내적 {
    public static void main(String[] args) {
        내적 init = new 내적();
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};
        int result = init.solution(a, b);
        System.out.println(result);
    }

    public int solution(int[] a, int[] b) {
        int result = recursion(a, b, a.length - 1);
        return result;
    }

    public int recursion(int[] a, int[]b, int idx) {
        //연산 실행
        int result = a[idx] * b[idx];

        //연산이 모두 종료되면 리턴
        if (idx == 0) {
            return result;
        }

        // idx감소
        idx--;

        //반복
        result += recursion(a,b, idx);
        return result;
    }
}
