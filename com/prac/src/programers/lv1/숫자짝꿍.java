package com.prac.src.programers.lv1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 숫자짝꿍 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String solution1 = solution.solution("100",	"200");
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public String solution(String X, String Y) {
            List<String> targets = Arrays.asList(X.split(""));
            Map<String, List<String>> compares = Stream.of(Y.split("")).collect(Collectors.groupingBy(s -> s));

            String collect = targets.stream()
                    .filter(s -> {
                        if (!compares.containsKey(s) || compares.get(s).isEmpty()) {
                            return false;
                        }

                        compares.get(s).remove(s);
                        return true;
                    })
                    .sorted(Comparator.<String, String>comparing(s -> s).reversed())
                    .collect(Collectors.joining());

            String result = Optional.ofNullable(collect)
                    .filter(s -> !s.isBlank())
                    .orElse("-1");
            Long.valueOf(result);
            return ifZeroCompress(result);
        }

        private Set<String> getSet(String num) {
            return new HashSet<String>(Arrays.asList(num.split("")));
        }

        private String ifZeroCompress(String s) {
            if (!isZeroStr(s)) {
                return s;
            }

            return "0";
        }

        private boolean isZeroStr(String s) {
            for (String str : s.split("")) {
                if (!"0".equals(str)) {
                    return false;
                }
            }

            return true;
        }
    }
}

