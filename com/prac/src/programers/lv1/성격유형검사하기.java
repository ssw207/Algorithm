package com.prac.src.programers.lv1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/118666?language=java
public class 성격유형검사하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String solution1 = solution.solution(survey, choices);
        System.out.println("solution1 = " + solution1);
    }
}

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> score = new LinkedHashMap<>();


        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];
            int num = choices[i];

            if (num == 4) {
                System.out.println("4번이면 스킵");
                continue;
            }

            if (num < 4) {
                score.put(s.substring(0, 1), convertToScore(num));
            } else {
                score.put(s.substring(1, 2), convertToScore(num));
            }
        }

        return getResult(score);
    }

    private int convertToScore(int num) {
        switch (num) {
            case 1: return 3;
            case 2: return 2;
            case 3: return 1;
            case 4: return 0;
            case 5: return 1;
            case 6: return 2;
            case 7: return 3;
            default: throw new IllegalArgumentException();
        }
    }

    public String getResult(Map<String, Integer> score) {
        String[] group1 = {"R","C","J","A"};
        String[] group2 = {"T","F","M","N"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < group1.length; i++) {
            Integer scoure1 = score.getOrDefault(group1[i], 0);
            Integer scoure2 = score.getOrDefault(group1[i], 0);

            int diff = scoure2 - scoure1;
            if (diff == 0) {
                sb.append(group1[i].compareTo(group2[i]));
                continue;
            }

            sb.append(diff > 0 ? scoure1 : scoure2);
        }

        return sb.toString();
    }
}


