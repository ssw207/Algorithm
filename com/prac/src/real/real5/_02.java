package com.prac.src.real.real5;

import java.util.*;

public class _02 {
    /**
     * 입력받은 배열의 값이 1인 좌표값으로 이동가능한 정류장을 알수있음

     입력값
     {0, 0, 1}, // 1 -> 3
     {0, 1, 1}, // 2 -> 1, 2 -> 3
     {0, 1, 0}  // 3 -> 2
     
     Map
     key 1, value 3
     key 2, value 3
     key 3, value 2
     
     검증시 from에 매칭되는 key가 있으면 vlaue리턴 
     value가 이동대상이면 true
     아니면 다시반복

     출력값
     {0, 1, 1}, // 불가능, 가능(1-3-2), 가능(1-3)
     {1, 1, 1}, // 가능(2-1), 가능(2-3-2), 가능(2-3)
     {0, 1, 1}  // 불가능, 가능(3-2), 가능(3-2-3)

     */
    public static void main(String[] args) {
        _02 exam = new _02();

        int n = 4;
        //int [][] arr = {{60, 3}, {60, 6}, {240, 9}};

        // A 가로 B 세로
        int [][] arr = {
                {0, 0, 1}, // 1 -> 3
                {1, 1, 1}, // 2 -> 3, 2 -> 2
                {0, 1, 0}  // 3 -> 2
        };

        int[][] solution = exam.solution(n, arr);
        for (int[] ints : solution) {
            System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
        }

    }


    //k : from, v : to
    Map<Integer, Set<Integer>> map = new HashMap<>();

    /**
     * from, to 를 받고 이동가능한지 판단하는 메소드 작성 (가능하면 1, 불가능하면0리턴)
     * 모든 배열을 순회하면서 검증후 이런값 세팅
     */
    int[][] solution(int n, int[][] signs){
        int[][] answer = {{0,0,0},{0,0,0},{0,0,0}};

        for (int i = 0; i < signs.length; i++) {
            for (int j = 0; j < signs.length; j++) {
                int chk = signs[i][j];
                if (chk == 0) continue;

                Set<Integer> set = map.getOrDefault(i, new HashSet<Integer>());
                set.add(j);
                map.put(i, set);
            }
        }

        System.out.println("map = " + map);

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (canMove(i, j, n)) {
                    answer[i][j] = 1;
                }
            }
        }

        return answer;
    }

    public boolean canMove(int k, int v, int n) {
        System.out.println("_02.canMove");
        System.out.println("k = " + k);
        System.out.println("v = " + v);
        if (n == 0) return false;

        int from = k;

        //이동가능한 위치확인
        Set<Integer> set = map.get(from);
        if (set == null) return false; // 없으면 false

        System.out.println("from = " + from);
        System.out.println("to = " + set.toString());

        //이동가능한 위치가 대상과 같으면 true
        set.contains(v);
        if (set.contains(v)) return true;

        //이동가능한 위치가 대상과 다르면 이동후 검증
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            from = iter.next();
            n--;

            System.out.println("======== 검증실패 파라미터 재세팅 ======");
            System.out.println("from = " + from);
            System.out.println("n = " + n);
            System.out.println("======== 검증실패 파라미터 재세팅 end ======");
            return canMove(from, v, n);
        }

        return true;
    }

}
