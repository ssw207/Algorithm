package prac.programers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/77484
 */
public class Exam1 {
    /*
    win_nums : 당첨번호 6자리, 중복없음, 정렬없음
    lottos : 선택한번호 6자리, 0은 알아볼수 없는숫자, 중복없음, 정렬안됨
    return [최고순위 ,최저순위]
    */
    public static void main(String[] args) {
        Exam1 exam1 = new Exam1();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] result = exam1.solution(lottos, win_nums);

        System.out.println(String.format("result : %s", Arrays.toString(result)));
    }

    /*
   1.lottos 배열에서 값이 0인 갯수확인
   2.win_nums배열에서 lottos 배열과 같은값 확인후 카운팅 = 맞춘갯수
   3.최대값은 2.맞춘갯수 + 0의갯수 (0인 경우는 모든 들어갈수 있으므로 )
   4.최소값 2.맞춘갯수 - 0의갯수 (0인 경우는 모든 들어갈수 있으므로 )
   5.맞춘갯수에 따라 등수환산
   */
    public int[] solution(int[] lottos, int[] win_nums) {
        //0을제외한 당첨번호 map
        //Map의 contains 매소드는 상수시간 복잡도를 가지므로 사용
        Map<Integer, Integer> lottosMap = new HashMap<>();

        //1
        int cntZero = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                cntZero++;
            }

            lottosMap.put(lotto, 0); //key가 있는지만 체크하면되므로 value는 임의값을 넣어줌
        }

        System.out.println(String.format("cntZero %d", cntZero));

        //2
        int cntMatch = 0;
        for (int num : win_nums) {
            //당첨번호가 있는지 검증 (상수시간 복잡도)
            if (lottosMap.containsKey(num)) {
                cntMatch++;
            }
        }

        System.out.println(String.format("cntMatch %d", cntMatch));

        //3
        int maxRank = 7 - (cntMatch + cntZero);
        int minRank = 7 - cntMatch;

        //0이 없고, 일치하는갯수가 0인경우 7등이 나오므로 보정처리함
        if (maxRank > 6) maxRank = 6;
        if(minRank > 6) minRank = 6;

        return new int[] {maxRank, minRank};
    }
}
