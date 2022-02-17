package java.prac.src.programers.highkit.sort;

import java.util.HashMap;
import java.util.Map;

//https://programmers.co.kr/learn/courses/30/lessons/42746
public class 가장큰수 {
    public static void main(String[] args) {
        가장큰수 init = new 가장큰수();
        int[] numbers = {6, 10, 2};
        String result = init.solution(numbers);
        System.out.println(result);
    }

    public String solution(int[] numbers) {
        //중복된 숫자를 허용하지 않으므로 사용한 숫자를 판단하는 map을 초기화
        Map<Integer, Integer> used = new HashMap<>();

        //0)가장 큰수를 판단하는 변수 int max를 0으로 초기화한다.
        int max = 0;

        //1)numbers로 만들수 있는 모든 조합을 만든다. 만든조합이 max보다 큰경우 max에 할당한다.
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                for (int k = 0; k < numbers.length; k++) {
                    if (i == k || i == j || k == j) {
                        continue;
                    }

                    int combainNumber = Integer.parseInt("" + numbers[i] +  numbers[j] + numbers[k]);
                    if (max < combainNumber) {
                        max = combainNumber;
                    }
                }
            }
        }

        //2)max를 String으로 바꿔 return
        return max + "";
    }
}
