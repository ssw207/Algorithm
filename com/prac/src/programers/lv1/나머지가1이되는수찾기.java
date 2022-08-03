package com.prac.src.programers.lv1;

//https://school.programmers.co.kr/learn/courses/30/lessons/87389?language=java
public class 나머지가1이되는수찾기 {

    public static void main(String[] args) {
        int solution = solution(10);
        System.out.println("solution = " + solution);
    }

    public static int solution(int n) {
        int x = 1;
        while (!(n%x == 1)) {
            x++;
        }
        return x;
    }
}
