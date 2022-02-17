package java.prac.src.real.real2;

//숫자더하기
public class 필수4 {
    public static void main(String[] args) {
        필수4 exam = new 필수4();
        int n = 999;
        String result = exam.solution(n);
        System.out.println(result);
    }

    private String solution(int n) {
        int result = rec(n);
        return getName(result);
    }

    private int rec(int n) {
        String s = n +"";
        System.out.println(s);

        if (s.length() == 1) {
            return n;
        }

        int sum = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            int i = Integer.parseInt(c+"");
            sum += i;
        }
        return rec(sum);
    }

    private String getName(int n) {
        if (n == 1) return "kiwi";
        if (n == 2) return "pear";
        if (n == 3) return "kiwi";
        if (n == 4) return "banana";
        if (n == 5) return "melon";
        if (n == 6) return "banana";
        if (n == 7) return "melon";
        if (n == 8) return "pineapple";
        if (n == 9) return "apple";

        return "";
    }
}
