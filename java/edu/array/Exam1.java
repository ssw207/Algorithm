package prac.edu.array;

import java.util.Arrays;

public class Exam1 {

    public static void main(String[] args) {
        Exam1 exam = new Exam1();

        int[] numbers = {1, 2, 6, 8};
        int target = 9;

        int[] rs = exam.solution(numbers, target);
        System.out.println(Arrays.toString(rs));
    }

    private int[] solution(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] {i,j};
                }
            }
        }

        return null;
    }
}
