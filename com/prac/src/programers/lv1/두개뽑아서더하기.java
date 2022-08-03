package com.prac.src.programers.lv1;

import java.util.*;
import java.util.stream.Stream;

/**
 * TreeSet은 이진탐색트리 - 레드블랙트리로 되어있다.
 * 추가 삭제는 시간이 더 걸리지만 정렬, 검색에 성능이 더 좋은게 특징이다.
 * 레드 블랙 트리는 부모 노드보다 작은 값을 가지는 노드는 왼쪽 큰 노드는 오른쪽으로 정렬한다.
 * 이터레이터로 순회시 오름차순으로 순회한다
 * descendingIterator 이용시 내림차순으로 순회한다
 */
public class 두개뽑아서더하기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2,1,3,4,1};
        int[] result = solution.solution(arr);
        System.out.println("result = " + Arrays.toString(result));
    }

    static class Solution {

        public int[] solution(int[] numbers) {
            //배열에서 두수를 뽑는다

            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < numbers.length; j++) {
                    if (i == j) continue;
                    set.add(numbers[i] + numbers[j]);

                }
            }

            int[] result = new int[set.size()];
            int cnt = 0;
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()) {
                result[cnt] = iterator.next();
                cnt++;
            }

            return result;
        }
    }
}
