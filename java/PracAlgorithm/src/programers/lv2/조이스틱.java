package prac.programers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

/*
1.문자를 바꾸는방법는 위로 올리거나 아래를 방법중 지정된 문자가 되는데 움직이는 횟수가 낮은 방법을 택한다.
2.문자열 배열 alpha A~Z까지 순서로 탐색시 0번째 있는 문자열에서 문자열 S 움직이는 횟수는
  1)indexOf(S)로 이동하려는 문자열의 index확인
  2)정순으로 이동 = 0 + index
    ex)문자열S가 'C'
       - index = 2
       - 2 - 0 = 2번이동
  3)역순으로 이동 = 끝인덱스(alpha.length - 1) - 문자열인덱스
    ex)문자열S가 'X'
       - index = 23
       - 끝인덱스 = 26(alpha.length)
       -> 26 - 23 = 2
   4)정순과 역순이동중 숫자가 낮은 방식 선택(Integer.min(a,b)
   5)선택한 방법의 이동횟수를 moves 값에 더함
 3.name의 다음문자열중 A가 아닌문자열까지 이동횟수
   1)for문으로 name 문자열을 순회하면서
     - A이면 continue
     - A가 아니면 현재위치 nowPositionIndex에서 대상문자열 까지 정순 역순 이동횟수 확인
       ex)'IAAKAAN' K에서 N이동시
          - nowPositionIndex = 3
          - target = 6
          1)정순
             - 이동횟수 = 6(target) - 3(nowPosition) = 3
          2)역순
            - 이동횟수 = 5(name.length -1) - 1(nowPosition) = 4
     - 정순,역순중 최소이동횟수를 moves에 더함.
 */
public class 조이스틱 {
    public static void main(String[] args) {
        조이스틱 init = new 조이스틱();
        String name="ZAAAZZZZZZZ";// 1 / 4+1 /
        int result = init.solution(name);
        System.out.println(result);
    }

    public int solution(String name) {
        Character[] alphas ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        List<Character> alphs = Arrays.asList(alphas);

        int moves = 0; //이동횟수
        int start = 0; //현재 문자열 index
        char[] nameChars = name.toCharArray();

        List<Integer> nameIdxs = new ArrayList<>();
        //name중 바궈야하는 name index
        for (int i = 0; i < nameChars.length; i++) {
            if (nameChars[i] == 'A') {
                continue;;
            }
            int next = i + 1;

            //다음문자 찾기
            System.out.println(String.format("***** 1.다음문자 이동횟수 현재위치(start)[%s], next[%s] max[%s]",start,next, nameChars.length-1));
            moves += getCntMoves(start, next, nameChars.length-1);
            System.out.println("moves:"+moves);

            //현재 문자 위치변경
            start = next;
        }

        System.out.println(String.format("문자열 [%s] 변경해야알 문자열 인덱스[%s]", name, nameIdxs.toString()));

        //ex)JEROEN
        for (int i = 0; i < nameIdxs.size(); i++) {
            //알파벳 찾기
            char targetChar = nameChars[nameIdxs.get(i)]; //ex)J

            //A~Z 알파벳선택시 이동횟수
            System.out.println(String.format("\n***** 2.알파벳찾기 name idx[%s], str[%s]", alphs.indexOf(targetChar), targetChar));
            moves += getCntMoves(0, alphs.indexOf(targetChar), alphas.length-1);
            System.out.println("moves:"+moves);
        }
        
        return moves;
    }

    private int getCntMoves(int start, int next, int max) {
        //입력값은 항상 A부터 들어오므로 0부터시작
        int cntMovesAsc = getCntMovesAsc(start, next);
        int cntMovesDesc= getCntMovesDesc(start, next, max);
        int min = Integer.min(cntMovesAsc, cntMovesDesc);
        System.out.println(String.format("start[%s], max[%s], end[%s] => cntMovesAsc[%s], cntMovesDesc[%s] => min[%s]",start, max, next, cntMovesAsc, cntMovesDesc, min));
        return min;
    }

    //{0,1,2,3,4,5}
    //1번인덱스에서 4번인덱스 이동
    //4-1 = 3
    private int getCntMovesAsc (int start, int end) {
        return end - start;
    }

    //{0,1,2,3,4,5}
    //1번인덱스에서 4)번인덱스 이동
    //1(1~ 0번인덱스까지 이동) + 1(끝으로 이동) + (5-4)(끝에서4번인덱스까지이동) = 3
    private int getCntMovesDesc (int start, int end, int max) {
        int startToZero = start;
        int toEnd = 1;
        int maxToEnd = (max - end);
        int sum = startToZero + toEnd + maxToEnd;
        System.out.println(String.format("- Desc계산 : startToZero[%s] + toEnd[%s] + maxToEnd[%s] = [%s]", startToZero,toEnd,maxToEnd,sum));
        return sum;
    }
}
