//숫자더하기
public class 필수3 {
    public static void main(String[] args) {
        필수3 exam = new 필수3();
        String[] n = {"3:1", "2:2", "1:3"};
        int result = exam.solution(n);
        System.out.println(result);
    }

    private int solution(String[] arr) {
        int sum = 0;
        for (String s : arr) {
            String[] scores = s.split(":");

            int my = Integer.parseInt(scores[0]);
            int other = Integer.parseInt(scores[1]);

            int diff = my - other;
            if (diff > 0)  {
                sum += 3;
            }
            else if (diff == 0)  {
                sum += 1;
            }
            else if (diff < 0)  {
                sum += 0;
            }
        }
        return sum;
    }
}
