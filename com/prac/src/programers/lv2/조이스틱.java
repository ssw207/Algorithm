package com.prac.src.programers.lv2;

import java.util.*;

/*
알고리즘 : 그리디
조건
  1)맨 첫글자는 A다
  2)조이스틱을 움직일때 동작
    ▲ - 다음 알파벳
    ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
    ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
    ▶ - 커서를 오른쪽으로 이동
  3)리턴 : 만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값
 제약
  1)name은 알파벳 대문자로만 이루어져 있습니다.
  2)name의 길이는 1 이상 20 이하입니다.
 */
public class 조이스틱 {
    public static void main(String[] args) {
        조이스틱 init = new 조이스틱();
        String name="ZAAAZZZZZZZ";// 1 / 4+1 /
        int result = init.solution(name);
        System.out.println(result);
    }

    public int solution(String name) {
        Map<Character, Integer> alphaMap = getAlphaMap();
        //상하이동 총합
        int cntUpDown = getMovesUpAndDown(alphaMap, name);
        //좌우이동 총합
        int cntLeftRight = getMovesLeftRight(name);

        return cntUpDown + cntLeftRight;
    }

    /**
     * 좌이우동 합계 구하기
     * 1)좌우이동 결정
     *   - 현재 위치에서 A가 아닌문자열을 만날때까지 왼쪽 or 오른쪽으로 이동했을때 최소값
     * 2)좌표이동 하기
     * 3)1~2 반복
     *   - 다음 위치가 처음이면 종료 ?
     * @param name 대상 이름 ABAAAAAAAAABB
     * @return
     */
    private int getMovesLeftRight(String name) {

        int rightFirstA = name.indexOf("A");
        int rightLastA = name.lastIndexOf("A");

        int rightFirstNonA = rightFirstA + 1;
        int rightLastNonA = rightLastA + 1;

        int pos = 0; //현재위치
        return 0;
    }

    //상하이동 합계
    private int getMovesUpAndDown(Map<Character, Integer> alphaMap, String name) {
        int sum = 0;
        for (int i = 0; i < name.length(); i++) {
            sum += alphaMap.get(name.charAt(i));
        }

        return sum;
    }

    //시작위치는 0 고정되어있으므로 목표 문자열까지의 거리는 고정임
    private Map<Character,Integer> getAlphaMap() {
        Map<Character, Integer> map = new HashMap<>();
        //위로이동시 A ~ M
        map.put('A', 0);
        map.put('B', 1);
        map.put('C', 2);
        map.put('D', 3);
        map.put('E', 4);
        map.put('F', 5);
        map.put('G', 6);
        map.put('H', 7);
        map.put('I', 8);
        map.put('J', 9);
        map.put('K', 10);
        map.put('L', 11);
        map.put('M', 12);
        
        //어느쪽이든 같음
        map.put('N', 13);

        //아래로이동시 Z ~ O
        map.put('O', 12);
        map.put('P', 11);
        map.put('Q', 10);
        map.put('R', 9);
        map.put('S', 8);
        map.put('T', 7);
        map.put('U', 6);
        map.put('V', 5);
        map.put('W', 4);
        map.put('X', 3);
        map.put('Y', 2);
        map.put('Z', 1);
        return map;
    }
}
