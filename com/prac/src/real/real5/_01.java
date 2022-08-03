package com.prac.src.real.real5;

public class _01 {
    public static void main(String[] args) {
        /**
         * 자동차 과속단속
         * 1. 평균속도 계산
         * 2. 제한속도, 평균속도 비교해 과속 판단
         * return 과속 횟숫
         */
        _01 exam = new _01();
//        int p1 = 60;
//        int[][] arr = {{60, 1}, {130, 2}, {240, 4}, {432, 7}};
        int p1 = 30;
        //int [][] arr = {{60, 3}, {60, 6}, {240, 9}};
        int [][] arr = {{60, 3}, {120, 3}};

        int solution = exam.solution(p1, arr);
        System.out.println("solution = " + solution);
    }

    public int solution(int speed_limit, int[][] cameras) {
        double limit = speed_limit;
        int cntOver = 0;

        for (int i = 1; i < cameras.length; i++) { //현재 ~ 이전을 비교하므로 인덱스1부터 시작
            int[] current = cameras[i];
            int[] before = cameras[i-1];

            double dis = current[0] - before[0];
            double time = current[1] - before[1];

            double speed = dis / time;

            System.out.println("=============속도체크=========" + i);
            System.out.println("time = " + time);
            System.out.println("dis = " + dis);
            System.out.println("speed = " + speed);

            if (speed > limit) {
                cntOver++;
                System.out.println("cntOver 과속수 = " + cntOver);
            }
        }

        return cntOver;
    }
}
