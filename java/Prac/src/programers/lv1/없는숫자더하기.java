package prac.programers.lv1;

import java.util.HashMap;
import java.util.Map;

//https://programmers.co.kr/learn/courses/30/lessons/86051
public class 없는숫자더하기 {
    public static void main(String[] args) {
        없는숫자더하기 init = new 없는숫자더하기();
        int[] numbers = {1,2,3,4,6,7,8,0};
        int result = init.solution(numbers);
        System.out.println(result);
    }

    public int solution(int[] numbers) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;

        for (int num : numbers) {
            map.put(num,1);
        }

        for (int i = 0; i < 10; i++) {
            Integer num = map.get(i);
            if (num == null) {
                resultMap.put(i, 1);
            }
        }

        for (Integer num : resultMap.keySet()) {
            total += num;
        }
        return total;
    }
}
