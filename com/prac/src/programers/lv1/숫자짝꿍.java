package com.prac.src.programers.lv1;

import java.util.*;
import java.util.stream.Collectors;

public class 숫자짝꿍 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String solution1 = solution.solution("00",	"00");
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public String solution(String X, String Y) {
            Map<String, Long> cntMapX = getCntMap(X);
            Map<String, Long> cntMapY = getCntMap(Y);

            Map<String, Long> resultMap = getResult(cntMapX, cntMapY);

            String result = resultMap.entrySet()
                    .stream()
                    .sorted(Comparator.<Map.Entry<String, Long>, String>comparing(Map.Entry::getKey).reversed())
                    .map(e -> toStr(e))
                    .collect(Collectors.joining());

            if ("".equals(result)) {
                return "-1";
            }

            if (isZero(result)) {
                return "0";
            }

            return result;
        }

        private boolean isZero(String result) {
            for (String s : result.split("")) {
                if (!"0".equals(s)) {
                    return false;
                }
            }

            return true;
        }

        private String toStr(Map.Entry<String, Long> e) {
            StringBuilder sb = new StringBuilder();
            for (long i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }

            return sb.toString();
        }


        private static Map<String, Long> getResult(Map<String, Long> cntMapX, Map<String, Long> cntMapY) {
            Map<String, Long> result = new HashMap<>();
            for (String s : cntMapY.keySet()) {
                Long cntX = cntMapX.getOrDefault(s, 0L);
                Long cntY = cntMapY.getOrDefault(s, 0L);

                result.put(s, Long.min(cntX, cntY));
            }

            return result;
        }

        private Map<String, Long> getCntMap(String X) {
            Map<String, Long> map = new HashMap<>();

            for (String str : X.split("")) {
                map.merge(str, map.getOrDefault(str, 1L), (v1, v2) -> v2 + 1);
            }
            return map;
        }
    }
}

