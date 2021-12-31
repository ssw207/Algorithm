package prac.programers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//https://programmers.co.kr/learn/courses/30/lessons/12977
public class 소수만들기 {
    public static void main(String[] args) {
        소수만들기 init = new 소수만들기();
        int[] nums = {1,2,3,4}; // 항상짝수
        int result = init.solution(nums);
        System.out.println(result); //4
    }
    /*
       1.n : 3 ~ 50 중복x
       2.소수는 1과 자신외에 나눠지면 안됨 => 자신 % 1 ~ 자신까지의 수 == 0 이면 false
       3.n중 3개를 선택후 합한값이 소수가 되는조합의 갯수를 리턴
    */
    public int solution(int[] nums) {
        //검증한 숫자 map
        Map<Integer, Boolean> map = new HashMap<>();

        int sum = 0;
        int cnt = 0;

        //모든 3자리수 조합
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                for (int k = 2; k < nums.length; k++) {
                    //같은숙자는 허용하지 않음
                    if (nums[i] == nums[k] || nums[i] == nums[j] || nums[j] == nums[k]) {
                        continue;
                    }

                    sum = nums[i] + nums[j] + nums[k];

                    //검증한 숫자면 스킵
                    Boolean isDecimal = map.get(sum);
                    if (isDecimal != null) {
                        if (isDecimal){
                            System.out.println(String.format("%d+%d+%d=%d 소수",nums[i],nums[j],nums[k],sum));
                            cnt++;
                        }
                        continue;
                    }

                    //1과 자기자신은 검증에서 제외
                    if (isDecimal(sum)) {
                        System.out.println(String.format("%d+%d+%d=%d 소수",nums[i],nums[j],nums[k],sum));
                        map.put(sum, true);
                        cnt++;
                    } else {
                        map.put(sum, false);
                    }
                }
            }
        }

        return cnt;
    }

    public boolean isDecimal(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
