package com.prac.src.programers.lv1;

//https://programmers.co.kr/learn/courses/30/lessons/42862
public class 체육복 {
    public static void main(String[] args) {
        체육복 init = new 체육복();
        int n = 5; //학생수 2 ~ 30
        int[] lost = {2, 4}; //도난다한 학생수 1 ~ n, 중복X
        int[] reserve = {1,3,5}; //여벌이있는사람이 도난당한 사람이면 못빌려줌

        int result = init.solution(n, lost, reserve);
        System.out.println(result);
    }
    public int solution(int n, int[] lost, int[] reserve) {
        /*
            n명 만큼 사람 배열생성
            0 : 옷을 잃어버렸지만 여벌이 있는사람
            -1 : 옷을 잃어버린사람
            1 : 옷도 안잃어버리고 여벌도 있는사람
         */
        int[] persons = new int[n];

        //옷을 잃어버린사람은 배열에서 -1
        for (int i = 0; i < lost.length; i++) {
            int personNum = lost[i];
            persons[personNum - 1]--; // 사람의 인덱스는 personNum - 1
        }

        //여벌옷이 있는사람은 배열에서 +1
        for (int i = 0; i < reserve.length; i++) {
            int personNum = reserve[i];
            persons[personNum - 1]++; // 사람의 인덱스는 personNum - 1
        }

        //옷빌리기
        for (int i = 0; i < persons.length; i++) {
            int cnt = persons[i]; // i번째 사람이 가진 여벌옷 수
            int beforePersonNum = i - 1; // i번째 사람의 앞사람
            int afterPersonNum = i + 1; // i번째 사람의 뒷사람

            //옷을 빌릴 필요가 없는 사람이면 스킵
            if (cnt > -1) {
                continue;
            }

            //앞사람이 있고 빌려줄 옷이 있으면 빌리기
            if (beforePersonNum >= 0 && persons[beforePersonNum] == 1) {
                persons[beforePersonNum]--;
                persons[i]++;
                continue;
            }

            //뒷사람이 있고 빌려줄 옷이 있으면 빌리기
            if (afterPersonNum < persons.length && persons[afterPersonNum] == 1) {
                persons[afterPersonNum]--;
                persons[i]++;
                continue;
            }

            //옷을 못빌린경우
            n--;
        }
        return n;
    }
}
