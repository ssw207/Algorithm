package com.prac.src.programers.lv1;

//https://programmers.co.kr/learn/courses/30/lessons/76501?language=java
public class 음양더하기 {
    public static void main(String[] args) {
        음양더하기 init = new 음양더하기();
        int[] numbers = {4,7,12};
        boolean[] signs = {true,false,true};
        int result = init.solution(numbers, signs);
        System.out.println(result);
    }

    public int solution(int[] numbers, boolean[] signs) {
        int total = 0;
        for (int i = 0; i < numbers.length; i++) {
            int num = (signs[i]) ? numbers[i] : numbers[i] * -1 ;
            total += num;
        }

        return total;
    }
}
