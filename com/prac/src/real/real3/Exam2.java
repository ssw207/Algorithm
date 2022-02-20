package com.prac.src.real.real3;


import java.util.HashSet;
import java.util.Set;

public class Exam2 {
    /**
     *
     *
     */
    public static void main(String[] args) {
        Exam2 exam = new Exam2();
        int[] T = {0, 0, 0, 0, 2, 3, 3}; //습득대상, index 스킬번호, value 사전습득
        int[] A = {2,5,6}; // 습득한스킬
        int rs = exam.solution(T, A);
        System.out.println(rs);
    }

    public int solution(int[] T, int[] A) {
        //습득해야하는 스킬체크
        Set<Integer> set = new HashSet<>();
        for (int num : T) {
            set.add(num);
        }

        for (int num : A) {
            set.add(num);
        }
        //System.out.println(set.toString());
        //최소 습득 스킬
        return set.size();
    }
}
