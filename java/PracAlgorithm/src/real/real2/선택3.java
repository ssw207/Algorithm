import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//숫자더하기
public class 선택3 {
    public static void main(String[] args) {
        선택3 exam = new 선택3();
        String[] arr = {"Ryan", "Kieran", "Mark"};
        List<String> result = exam.solution(arr);

        for (String s : result) {
            System.out.println(s);
        }
    }

    private List<String> solution(String[] arr) {
        List<String> list = new ArrayList<>();
        for (String s : arr) {
            if (s.length() == 4) {
                list.add(s);
            }
        }
        return list;
    }
}
