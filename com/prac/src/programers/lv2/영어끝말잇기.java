package com.prac.src.programers.lv2;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/12981
public class 영어끝말잇기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(2, new String[] {"hello", "one", "even", "never", "now", "world", "draw"});
        System.out.println("Arrays.toString(so) = " + Arrays.toString(solution1));
    }

    static class Solution {
        Map<Integer, Set<String>> personMap = new HashMap<>();
        Map<String, Integer> totalMap = new HashMap<>();
        int person = 1;
        String beforeWord = "";

        public int[] solution(int n, String[] words) {
            int max = n + 1;
            for (int i = 0; i < words.length; i++) {
                String word = words[i];

                Set<String> personWords = getPersonWords();

                if (isWongWord(word)) {
                    return new int[] {person, personWords.size() + 1};
                }

                putWord(word, personWords);
                changeToNextPersonNumber(max);
            }

            return new int[] {0, 0};
        }

        private Set<String> getPersonWords() {
            Set<String> personWords = personMap.getOrDefault(person, new HashSet<>());
            return personWords;
        }

        private boolean isWongWord(String word) {
            if (beforeWord == "") {
                return false;
            }

            if (totalMap.get(word) != null) {
                return true;
            }

            char last = beforeWord.charAt(beforeWord.length() - 1);
            char first = word.charAt(0);

            return last != first;
        }

        private void putWord(String word, Set<String> personWords) {
            beforeWord = word;
            personWords.add(word);
            personMap.put(person, personWords);
            totalMap.put(word, 1);
        }

        private void changeToNextPersonNumber(int max) {
            person++;
            if (person == max) {
                person = 1;
            }
        }
    }
}
