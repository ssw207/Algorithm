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

    public String solution(int[] numbers, String hand) {
        StringBuilder result = new StringBuilder();
        int[] rightHandPosition = {2,0};
        int[] leftHandPosition = {0,0};

        for (int number : numbers) {
            //1)number를 어느 엄지로 누르는지 판단 (입력값 누르는 숫자, 현재위치, 왼손오른손)
            String clickHand = getClickHand(number, leftHandPosition, rightHandPosition, hand);

            //2)결과값 StringBuilder에 더하기
            result.append(clickHand);

            System.out.println(String.format("왼:%s, 오:%s, 눌러야할숫자:%s, 사용할손:%s", Arrays.toString(rightHandPosition), Arrays.toString(leftHandPosition), number, clickHand));
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
        String clickHand = ""; // 클릭한 손
        int[] targetNumberPosition = getPosition(number); // 입력해야할 숫자 좌표

        //왼쪽 키패드
        if (number == 1 || number == 4 || number == 7) {
            clickHand = "L";

        //오른쪽 키패드
        } else  if (number == 3 || number == 6 || number == 9) {
            clickHand = "R";

        //중앙키패드
        } else {
            //현재 손의 위치와 입력한 키패드의 거리
            int leftHandDistance = getDistance(targetNumberPosition, leftHandPosition);
            int rightHandDistance = getDistance(targetNumberPosition, rightHandPosition);

            if (leftHandDistance == rightHandDistance) {
                clickHand = "left".equals(hand) ? "L" : "R";
            } else if (leftHandDistance < rightHandDistance) {
                clickHand = "L";
            } else {
                clickHand = "R";
            }
        }

        //클릭한 손의 좌표 이동
        if ("L".equals(clickHand)) {
            leftHandPosition[0] = targetNumberPosition[0];
            leftHandPosition[1] = targetNumberPosition[1];
        } else {
            rightHandPosition[0] = targetNumberPosition[0];
            rightHandPosition[1] = targetNumberPosition[1];
        }

        return clickHand;
    }

    /**
     * 입력할 숫자패드의 좌표 조회
     * @param number
     * @return
     */
    private int[] getPosition(int number) {
        switch (number) {
            //왼쪽 키패드
            case 7 : return new int[] {0,1};
            case 4 : return new int[] {0,2};
            case 1 : return new int[] {0,3};

            //중앙 키패드
            case 0 : return new int[] {1,0};
            case 8 : return new int[] {1,1};
            case 5 : return new int[] {1,2};
            case 2 : return new int[] {1,3};
            
            //오른쪽 키패드
            case 9 : return new int[] {2,1};
            case 6 : return new int[] {2,2};
            case 3 : return new int[] {2,3};

            default:
                throw new IllegalStateException("Unexpected value: " + number);
        }
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
