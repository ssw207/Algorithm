package com.prac.src.programers.lv1;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/17682
public class 다트게임 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int result = solution.solution("10S1S0S*");
        System.out.println("solution1 = " + result);
    }

    static class Solution {
        /**
         * 1. 입렬된 문자열을 한글자씩 순회
         * 2. 숫자면 변수에 더하고 continue
         * 3. 보너스, 옵션이면  연산실행후 변수를 비운다
         * 4. 연산이 끝나면 배열에 할당
         * 5. 반복
         */
        public int solution(String dartResult) {
            int[] nums = new int[3];

            String toCalcNumberStr = "";
            int cntNum = 0;
            
            for (int i = 0; i < dartResult.length(); i++) {
                char c = dartResult.charAt(i);

                //숫자만들기
                if (Character.isDigit(c)) {
                    toCalcNumberStr = toCalcNumberStr + c;
                    continue;
                }

                //연산시작
                if (toCalcNumberStr.equals("")) {
                    break;
                }

                Integer num = Integer.valueOf(toCalcNumberStr);

                Optional<BONUS> bonus = BONUS.getValue(c);
                Optional<OPTION> option = OPTION.getValue(c);

                if (bonus.isPresent()) {
                    nums[cntNum] = (int) Math.pow(num, bonus.get().value);
                } else if (option.isPresent()) {
                    if (option.get() == OPTION.DOUBLE) {
                        nums[cntNum] = nums[cntNum] * option.get().value;
                        if (cntNum != 0) {
                            nums[cntNum-1] = nums[cntNum-1] * option.get().value;
                        }
                    } else {
                        nums[cntNum] = nums[cntNum] * option.get().value;
                    }
                }

                // 다음 문자가 숫자가 아니면 연산종료 숫자판단 종료조건
                if (i != (dartResult.length() -1)
                        && Character.isDigit(dartResult.charAt(i+1))) {
                    cntNum++;
                    toCalcNumberStr = "";
                }
            }
            System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
            return Arrays.stream(nums).reduce(0, (i, e) -> i + e);
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
            DOUBLE('*', 2),
            MINUS('#', -1);

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
