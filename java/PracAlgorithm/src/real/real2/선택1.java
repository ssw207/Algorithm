import java.util.HashMap;
import java.util.Map;

//숫자더하기
public class 선택1 {
    public static void main(String[] args) {
        선택1 exam = new 선택1();
        String n = "abracadabra";
        int result = exam.solution(n);
        System.out.println(result);
    }

    private int solution(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);

        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) cnt++;
        }
        return cnt;
    }
}
