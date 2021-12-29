package prac.programers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://programmers.co.kr/learn/courses/30/lessons/42862
public class 체육복 {
    public static void main(String[] args) {
        체육복 init = new 체육복();
        int n = 5; //학생수 2 ~ 30
        int[] lost = {2, 4}; //도난다한 학생수 1 ~ n, 중복X
        int[] reserve = {3}; //여벌이있는사람이 도난가능,

        int result = init.solution(n, lost, reserve);
        System.out.println(result);
    }

    public int solution(int n, int[] lost, int[] reserve) {

        Map<Integer,String> reserveMap = new HashMap<>();
        for (int i : reserve) {
            reserveMap.put(i,"");
        }

        int cntBorrow = 0;

        //잃어버린 사람수만큼 반복
        for (int i = 0; i < lost.length; i++) {
            //잃어버린 사람의 번호확인
            int numLost = lost[i];

            //빌릴수 있는사람 확인 - 잃어 버린 사람의 앞뒤 번호 확인
            int numBorrowFront = numLost - 1;
            int numBorrowBack = numLost + 1;

            //앞사람한테 빌리기
            String isExists = "";
            if (numBorrowFront > 0) {
                isExists = reserveMap.get(numBorrowFront);
                if (isExists != null) {
                    cntBorrow++;
                    reserveMap.remove(numBorrowFront);
                    continue;
                }
            }

            //뒷사람한테 빌리기
            if (numBorrowBack <= n) {
                isExists = reserveMap.get(numBorrowBack);
                if (isExists != null) {
                    cntBorrow++;
                    reserveMap.remove(numBorrowBack);
                }
            }
        }
        //전체체육복이 있는사람 = 전체사람수 - 잃어버린사람수 + 빌린사람수
        return n - lost.length + cntBorrow;
    }
}
