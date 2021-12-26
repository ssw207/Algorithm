package prac.programers.highkit.serach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//https://programmers.co.kr/learn/courses/30/lessons/42840
public class 모의고사 {
    //사람별 찍는 패턴
    private static int[] choice1 = {1, 2, 3, 4, 5};
    private static int[] choice2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private static int[] choice3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static void main(String[] args) {
        모의고사 init = new 모의고사();
        int[] answers = {1,2,3,4,5};
        System.out.println(Arrays.toString(init.solution(answers)));
    }

    public int[] solution(int[] answers) {
        //정답수
        int match1 = 0;
        int match2 = 0;
        int match3 = 0;

        //사람별 정답 체크
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            //무한으로 순회하기 위해 찍는개수만큼 모듈러스처리
            if (choice1[i % 5] == answer) match1 ++;
            if (choice2[i % 8] == answer) match2 ++;
            if (choice3[i % 10] == answer) match3 ++;
        }

        //최대 정답수 체크
        int max = 0;
        max = (match1 > match2) ? match1 : match2;
        max = (max > match3) ? max : match3;

        List<Integer> list = new ArrayList<>();
        if (max == match1) list.add(1);
        if (max == match2) list.add(2);
        if (max == match3) list.add(3);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
