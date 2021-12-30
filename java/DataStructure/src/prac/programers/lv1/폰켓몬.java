package prac.programers.lv1;

import com.sun.source.doctree.SeeTree;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

//https://programmers.co.kr/learn/courses/30/lessons/1845
public class 폰켓몬 {
    public static void main(String[] args) {
        폰켓몬 init = new 폰켓몬();
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
        //가져갈수 있는 최대수
        int max = nums.length / 2; //항상짝수

        //중복제거
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        //폰켓몬 종류
        int kinds = set.size();

        //폰켓몬종류가 가져갈수 있는 최대 숫자보다 크면 최대수 리턴 아니면 종류 리턴
        return (max < kinds) ? max : kinds;
    }
}
