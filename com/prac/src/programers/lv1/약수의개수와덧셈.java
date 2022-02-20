package com.prac.src.programers.lv1;

//https://programmers.co.kr/learn/courses/30/lessons/1845
public class 약수의개수와덧셈 {
    public static void main(String[] args) {
        약수의개수와덧셈 init = new 약수의개수와덧셈();
        int left = 13;
        int right = 17;
        int result = init.solution(left, right);
        System.out.println(result); //43
    }

    /*
    대상 : left ~ right 까지 모든수
    판별 : 약수=짝수 더하기, 약수=홀수 빼기
     */
    public int solution(int left, int right) {
        int sum = 0;
        for (int num = left; num <= right; num++) {
            if (getCntDivisor(num) %2 == 0) {
                sum += num;
                System.out.println(String.format("약수가 짝수(%s) 더하기 = 결과(%s)",num, sum));
            } else {
                sum -= num;
                System.out.println(String.format("약수가 홀수(%s) 더하기 = 결과(%s)",num, sum));
            }
        }

        return sum;
    }

    /**
     * 약수 갯수 계산
     * TODO 최적화 필요. 현재는 전체 를 순회하므로 시간복잡도 O(N)임
     */
    private int getCntDivisor(int num) {
        int total = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i ==0) {
                //System.out.println(String.format("=> 숫자(%s) 약수(%s)",num, i));
                total += 1;
            }
        }
        System.out.println(String.format("숫자(%s) 약수의 갯수(%s)",num, total));
        return total;
    }
}
