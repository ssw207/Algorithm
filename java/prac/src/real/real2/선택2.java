package java.prac.src.real.real2;

import java.util.Arrays;

//숫자더하기
public class 선택2 {
    public static void main(String[] args) {
        선택2 exam = new 선택2();
        int[] n = {5,1,2};
        int result = exam.solution(n);
        System.out.println(result);
    }

    private int solution(int[] arr) {
        int[] sorted = Arrays.stream(arr).sorted().toArray();
        return (arr[sorted[1]]);
    }
}
