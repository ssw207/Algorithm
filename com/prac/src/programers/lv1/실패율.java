package com.prac.src.programers.lv1;

import java.util.*;


//https://programmers.co.kr/learn/courses/30/lessons/42889
public class 실패율 {
    public static void main(String[] args) {
        실패율 init = new 실패율();
        int n = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] result = init.solution(n, stages);
        System.out.println(Arrays.toString(result)); //3,4,2,1,5
    }
    /*
    실패율 : 도착 BUT 못깬 플레이어수 / 도착 플레이어수
    stages : 사용자가 실패한 스테이지
    N + 1 스테이지 : 모든 스테이지 클리어
    스테이지의 실패율이 같으면 스테이지 숫자가 작은 순서로 정렬
    한명도 도착하지 않은 스테이지의 실패율은 0
     */
    public int[] solution(int N, int[] stages) {
        // 각 스테이지의 실패율.
        // ex)key:1, value: 1/8 = 1번째 스테이지 실패율 1/8
        Map<Integer, Double> stageFailRto = new HashMap<>();

        // 스테이별 클리어 실패 인원수
        // 인덱스를 0번대신 1번부터 이용하기위해 +1
        // 스테이지를 모드 클리어한 경우 표시하기위해 +1
        int[] stageStayTotal = new int [N + 2];
        for (int i = 0; i < stages.length; i++) {
            int stayStage = stages[i]; //도전 스테이지
            stageStayTotal[stayStage]++; //스테이지를 도전한 사람수를 더함
        }

        System.out.println(String.format("스테이지별 실패자수 %s", Arrays.toString(stageStayTotal)));

        /*
        실패율 구하기
        현재스테이지 도전자 : stages[스테이지숫자]
        현재스테이지도전한 사람 : 현재스테이지 이상에서 실패한 사람 총합
         */
        for (int stage = 1; stage <= N; stage++) { //1번 ~ N번 스테이지 순회
            //스테이지 도전자수
            int cntTryTotal = 0;

            //스테이지 도전자수 구하기
            for (int stageStay = stage; stageStay < stageStayTotal.length; stageStay++) { //현재 스테이지 이후의 모든스테이지 도전자를 더한다.
                cntTryTotal += stageStayTotal[stageStay]; //총 도전자를 구하려는 스테이지 이후의 모든스테이지 사람수를 더한다.
            }

            System.out.println(String.format("스테이지(%s) 실패자(%s) / 도전자(%s)",stage, stageStayTotal[stage], cntTryTotal));

            //스테이지 실패율
            double rtoFail = (cntTryTotal == 0) ? 0.0 : (double) stageStayTotal[stage] / (double) cntTryTotal; // cntTryTotal이 0인경우 NaN 출력되므로 예외처리
            stageFailRto.put(stage, rtoFail); // key:스테이지, value:실패율
        }

        System.out.println(String.format("스테이지 실패율 : %s", stageFailRto.toString()));

        //실패율 순으로 정렬한 스테이지 배열 리턴
        int[] result = stageFailRto.entrySet().stream()
                .sorted((entry1, entry2) -> {
                    double rtoFail1 = entry1.getValue();
                    double rtoFail2 = entry2.getValue();

                    //실패율이 같은경우
                    if (rtoFail1 == rtoFail2) {
                        return (entry1.getKey() > entry2.getKey()) ? 1 : -1; //스테이지가 더 작은 순서 기준으로 정렬
                    }
                    return (rtoFail1 > rtoFail2) ? -1 : 1; // 실패율이 큰 순서로 정렬
                })
                .mapToInt(entry -> entry.getKey()) // key Intger -> int변환
                .toArray(); // 배열생성

        return result;
    }
}
