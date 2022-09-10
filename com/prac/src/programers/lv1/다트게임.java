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
                Optional<BONUS> value = BONUS.getValue(c);
                Optional<BONUS> value = BONUS.getValue(c);

                if (value.isPresent()) {
                    result += Math.pow(num, c);

                    if (i != (dartResult.length() -1)
                            && OPTION.contains(dartResult.charAt(i+1))) {
                        toCalcNumberStr = "";
                    }
                } else if (OPTION.contains(c + "")) {
                    num;
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
