import java.util.Arrays;

//숫자더하기
public class 필수2 {
    public static void main(String[] args) {
        필수2 exam = new 필수2();
        int[] n = {0,1,2,3,4,5,6};
        int result = exam.solution(n);
        System.out.println(result);
    }

    private int solution(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1) {
                return arr[i] + 1;
            }

            if (arr[i+1] - arr[i] > 1) {
                return arr[i]+1;
            }
        }
        return 0;
    }
}
