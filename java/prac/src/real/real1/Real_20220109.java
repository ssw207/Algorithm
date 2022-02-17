package java.prac.src.real.real1;

import java.util.ArrayList;
import java.util.List;

public class Real_20220109 {


    public static void main(String[] args) {
        Real_20220109 real = new Real_20220109();
        String[] scores = {"AAFAFA", "FEECAA", "FABBCB", "CBEDEE", "CCCCCC"};
        //String[] scores = {"BCD","ABB","FEE"};

        int resut = real.solution(scores);
        System.out.println(resut); //3
    }

    public int solution(String[] grades) {
        int answer = 0;

        for (String grade : grades) {
            if (isPass(grade)) {
                //System.out.println(String.format("%s 통과", grade));
                answer++;
            }
        }

        return answer;
    }

    private boolean isPass(String grade) {
        final char FAIL = 'F';
        final char PASS = 'A';

        if (grade == null || grade == "") {
            return false;
        }

        //F가 2개 이상이면 탈락
        if (getCntMatch(grade, FAIL) >= 2) {
            //System.out.println(String.format("%s F2개이상 실패", grade));
            return false;
        }

        //A가 2개 이상이면 합격
        if (getCntMatch(grade, PASS) >= 2) {
            //System.out.println(String.format("%s F2개이상 통과", grade));
            return true;
        }

        if (calcScore(grade) >= 3) {
            return true;
        }

        return false;
    }

    private int getCntMatch(String score, char target) {
        int match = 0;
        for (char c : score.toCharArray()) {
            if (c == target) {
                match++;
            }
        }
        return match;
    }

    private int calcScore(String grades) {
        List<Integer> scores = new ArrayList<>();

        char[] arr = grades.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            scores.add(convertGradeToScore(arr[i]));
        }

        //오름차순 정렬
        scores.sort((o1, o2) -> {
            return (o1 > o2) ? 1 : -1;
        });

        //최소, 최대값 제거하고 합산
        int totalScore = 0;

        for (int i = 1; i < scores.size() -1; i++) {
            totalScore += scores.get(i);
        }
        return (totalScore == 0) ? 0 : totalScore / (scores.size() -2);
    }

    private Integer convertGradeToScore(char c) {
        if (c == 'A') return 5;
        if (c == 'B') return 4;
        if (c == 'C') return 3;
        if (c == 'D') return 2;
        if (c == 'E') return 1;
        if (c == 'F') return 0;

        throw new IllegalArgumentException(String.format("부적절한 등급입니다. %s",c));
    }
}

