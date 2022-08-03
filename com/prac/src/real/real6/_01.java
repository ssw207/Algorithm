package com.prac.src.real.real6;

public class _01 {
    public static void main(String[] args) {
        _01 run = new _01();

        int m = 3;
        int limit = 5;
        run.solution(m, limit);
    }

    /*
    처음에는 1일 이체 한도만큼 송금을 시도합니다.
    송금에 성공한 경우, 성공한 금액만큼 한 번 더 송금을 시도합니다.
    송금에 실패한 경우, 시도했던 금액을 2로 나눈 몫만큼 줄여서 다시 송금을 시도합니다
    단, 첫 송금에 성공하거나, 송금을 두 번 연속 성공하거나, 1원 송금에 실패하면 작업을 종료합니다.
    */
    public int[] solution(int amtBalance, int amtLimit) {
        // 첫송금 성공시 종료
        if (amtBalance == amtLimit) {
            return new int[] {1, 0};
        }

        int cntSuccess = 0;
        int cntFail = 0;
        int cntConseQuense = 0;
        int amtSend = amtLimit / 2;

        while (cntConseQuense != 2 && amtBalance != 0) {
            if (amtSend <= amtBalance) {
                cntSuccess ++;
                cntConseQuense ++;
                continue;
            }

            cntFail++;
            cntConseQuense = 0;
        }

        return new int[] {cntSuccess, cntFail};
    }
}