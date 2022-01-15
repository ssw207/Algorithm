//분기숫자구하기
public class 필수1 {
    public static void main(String[] args) {
        필수1 exam = new 필수1();
        int n = 0;
        String result = exam.solution(n);
        System.out.println(result);
    }

    private String solution(int n) {
        if (n >= 1 && n <= 3) return "1분기";
        if (n >= 4 && n <= 6) return "2분기";
        if (n >= 7 && n <= 9) return "3분기";
        if (n >= 10 && n <= 12) return "4분기";

        throw new IllegalArgumentException("입력값 오류");
    }
}
