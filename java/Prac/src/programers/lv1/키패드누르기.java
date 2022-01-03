package prac.programers.lv1;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/67256
public class 키패드누르기 {
    public static void main(String[] args) {
        키패드누르기 init = new 키패드누르기();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right"; // left, right
        String result = init.solution(numbers, hand);
        System.out.println(result);
    }

    //숫자패드 좌표
    private static int[][] numberPosition = {
            {1,0}, // 0
            {0,3}, // 1
            {1,3}, // 2
            {2,3}, // 3
            {0,2}, // 4
            {1,2}, // 5
            {2,2}, // 6
            {0,1}, // 7
            {1,1}, // 8
            {2,1} // 9
    };

    public String solution(int[] numbers, String hand) {
        StringBuilder result = new StringBuilder();
        int[] rightHandPosition = {2,0};
        int[] leftHandPosition = {0,0};

        for (int number : numbers) {
            //1)number를 어느 손으로 누르는지 판단
            String clickHand = getClickHand(number, leftHandPosition, rightHandPosition, hand);

            //2)클릭한 손의 좌표 이동
            if ("L".equals(clickHand)) {
                leftHandPosition = numberPosition[number];
            }  else if ("R".equals(clickHand)) {
                rightHandPosition = numberPosition[number];
            }

            //3)결과값 StringBuilder에 더하기
            result.append(clickHand);
            //System.out.println(String.format("왼:%s, 오:%s, 눌러야할숫자:%s, 사용할손:%s", Arrays.toString(rightHandPosition), Arrays.toString(leftHandPosition), number, clickHand));
        }

        //3)결과값리턴
        return result.toString();
    }

    /**
     * 클릭한 손 선택
     * @param number *, #는 누르지 않음
     * @param leftHandPosition
     * @param rightHandPosition
     * @param hand
     * @return
     */
    private String getClickHand(int number, int[] leftHandPosition, int[] rightHandPosition, String hand) {

        //왼쪽 키패드
        if (number == 1 || number == 4 || number == 7) {
            return "L";
        }

        //오른쪽 키패드
        if (number == 3 || number == 6 || number == 9) {
            return "R";
        }

        //중앙키패드
        int[] targetNumberPosition = numberPosition[number]; // 입력해야할 숫자 좌표

        //현재 손의 위치와 입력한 키패드의 거리
        int leftHandDistance = getDistance(targetNumberPosition, leftHandPosition);
        int rightHandDistance = getDistance(targetNumberPosition, rightHandPosition);

        if (leftHandDistance < rightHandDistance) {
            return "L";
        }

        if (leftHandDistance > rightHandDistance) {
            return "R";
        }

        //같은경우
        return "left".equals(hand) ? "L" : "R";
    }

    /**
     * 입력한 숫자패드와 현재손의 거리 계산
     * x축 차이 + y축 차이 = 거리 (문제 예제에서 도출)
     * @param targetNumberPosition
     * @param handPosition
     * @return
     */
    private int getDistance(int[] targetNumberPosition, int[] handPosition) {
        int dx = Math.abs(handPosition[0] - targetNumberPosition[0]) ;
        int dy = Math.abs(handPosition[1] - targetNumberPosition[1]) ;
        return dx + dy;
    }
}
