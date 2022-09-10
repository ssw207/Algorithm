package com.prac.src.programers.lv1;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/17682
public class 다트게임 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int result = solution.solution("1S2D*3T");
        System.out.println("solution1 = " + result);
    }

    static class Solution {
        public int solution(String dartResult) {
            int result = 0;
            String toCalcNumberStr = "";

            for (int i = 0; i < dartResult.length(); i++) {
                char c = dartResult.charAt(i);

                if (Character.isDigit(c)) {
                    toCalcNumberStr = toCalcNumberStr + c;
                    continue;
                }

                Integer num = Integer.valueOf(toCalcNumberStr);
                if (num == 0) {
                    continue;
                }

                Optional<BONUS> bonus = BONUS.getValue(c);
                Optional<OPTION> option = OPTION.getValue(c);

                if (bonus.isPresent()) {
                    result += Math.pow(num, bonus.get().value);
                } else if (option.isPresent()) {
                    result += num * option.get().value;
                }

                if (i != (dartResult.length() -1)
                        && Character.isDigit(dartResult.charAt(i+1))) {
                    toCalcNumberStr = "";
                }
            }

            return result;
        }

        enum BONUS {
            S('S',1),
            D('D',2),
            T('T',3);

            private final char code;
            private final int value;

            BONUS(char code, int value) {
                this.code = code;
                this.value = value;
            }

            static Optional<BONUS> getValue(char c) {
                return Arrays.stream(values())
                        .filter(e -> e.code == c)
                        .findAny();
            }
        }

        enum OPTION {
            DOUBLE('*', -1),
            MINUS('#', 2);

            private final char code;
            private final int value;

            OPTION(char code, int value) {
                this.code = code;
                this.value = value;
            }

            static Optional<OPTION> getValue(char c) {
                return Arrays.stream(values())
                        .filter(e -> e.code == c)
                        .findAny();
            }
        }
    }
}
