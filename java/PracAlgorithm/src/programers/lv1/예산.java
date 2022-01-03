package prac.programers.lv1;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://programmers.co.kr/learn/courses/30/lessons/1845
public class 예산 {
    public static void main(String[] args) {
        예산 init = new 예산();
        int[] nums = {3,1,2,3}; // 항상짝수
        int result = init.solution(nums);
        System.out.println(result);
    }
    /*
       1.총 n/2만큼 가져갈수 있음
       2.번호가 같으면 같은 폰켓몬
       3.최대한 많은종류를 가져가야함
    */
    public int solution(int[] nums) {
        return Arrays.stream(nums)
                .boxed() // Intger변환
                .collect(Collectors.collectingAndThen(
                        Collectors.toSet() // Set으로 변환
                        , (monsterKindSet) -> Integer.min(monsterKindSet.size(), nums.length / 2))); //폰켓몬종류가 가져갈수 있는 최대 숫자보다 크면 최대수 리턴 아니면 종류 리턴

    }
}
