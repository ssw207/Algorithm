package prac.programers.lv1;

import java.util.Arrays;

/**
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/77484
 */
public class Lotto {
    /*
    win_nums : 당첨번호 6자리, 중복없음, 정렬없음
    lottos : 선택한번호 6자리, 0은 알아볼수 없는숫자, 중복없음, 정렬안됨
    return [최고순위 ,최저순위]
    */
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] result = lotto.solution(lottos, win_nums);

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
        //1
        int cntZero = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                cntZero++;
            }
        }
        System.out.println(String.format("cntZero %d", cntZero));
        //2
        int cntMatch = 0;
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    cntMatch++;
                }
            }
        }
        System.out.println(String.format("cntMatch %d", cntMatch));

        //3
        int cntMax = cntMatch + cntZero;
        int cntMin = cntMatch;

        return new int[] {convertToGrade(cntMax), convertToGrade(cntMin)};
    }

    public int convertToGrade(int cntMatch) {
        switch (cntMatch) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default : return 6;
        }

    }
}
