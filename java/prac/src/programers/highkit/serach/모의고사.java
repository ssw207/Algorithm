package java.prac.src.programers.highkit.serach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//https://programmers.co.kr/learn/courses/30/lessons/42840
public class 모의고사 {
    public static void main(String[] args) {
        모의고사 init = new 모의고사();
        int[] answers = {1,2,3,4,5};
        System.out.println(Arrays.toString(init.solution(answers)));
    }

    //지원자별 찍는 패턴
    private static int[][] choices = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        //지원자 정답수 배열
        int[] matchs = new int[3];

        //정답 체크
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];

            //사람별 정답체크
            for (int j = 0; j < matchs.length; j++) {
                int[] choice = choices[j]; // j번째 사람이 선택한 답 배열
                int choiceOne = choice[i % choice.length]; // i번 문제에 j번사람이 선택한 답

                if (answer == choiceOne) {
                    matchs[j] = matchs[j] + 1; // 정답인경우 j번째사람 정답수 + 1
                }
            }
        }

        //최대 정답수 체크
        int max = 0;
        for (int match : matchs) {
            max = Integer.max(max, match);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matchs.length ; i++) {
            //i번재 사람이 최대점수인경우
            if (matchs[i] == max) {
                list.add(i+1);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
