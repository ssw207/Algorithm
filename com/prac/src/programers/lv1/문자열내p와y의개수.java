package com.prac.src.programers.lv1;

public class 문자열내p와y의개수 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean pPoooyY = solution.solution("pPoooyY");
        System.out.println("pPoooyY = " + pPoooyY);
    }

    static class Solution {
        boolean solution(String s) {

            int cntP = 0;
            int cntY = 0;

            for (int i = 0; i < s.length(); i++) {
                String c = s.charAt(i) + "";
                if (c.equalsIgnoreCase("p")) {
                    cntP++;
                } else if (c.equalsIgnoreCase("y")) {
                    cntY++;
                }
            }

            return cntP == cntY;
        }
    }
}
