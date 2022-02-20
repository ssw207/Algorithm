package com.prac.src.real.real2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//숫자더하기
public class 선택4 {
    public static void main(String[] args) {
        선택4 exam = new 선택4();
        String n = "1 2 1 1";
        int result = exam.solution(n);
        System.out.println(result);
    }

    private int solution(String str) {
        String[] arr = str.split(" ");
        List<String> even =new ArrayList<>();
        List<String> odd =new ArrayList<>();

        for (String s : arr) {
            int i = Integer.parseInt(s);
            if (i%2 == 0) {
                even.add(s);
                continue;
            }

            odd.add(s);
        }
        //System.out.println("even : "+even.toString());
        //System.out.println("odd : "+odd.toString());
        String target = (even.size() == 1) ? even.get(0) : odd.get(0);
        //System.out.println(target);
        return Arrays.asList(arr).indexOf(target) + 1;
    }
}
