package java.prac.src.real.real3;


public class Exam3 {

    public static void main(String[] args) {
        Exam3 exam = new Exam3();
        int[] T = {3, 2, 3, 1}; //습득대상, index 스킬번호, value 사전습득
        int rs = exam.solution(T);
        System.out.println(rs);
    }

    /**
     * 1)배열의 길이부터 1씩줄여가며 배열을 순회
     *   ex)[7, 4, -2, 4, -2, -9] 주어진 경우
     */
    public int solution(int[] A) {
        int max = A.length;
        //최대길이부터 2까지 체크 1은 무조건 통과이므로 의미없음
        for (int pos = A.length; pos > 1; pos--) { //5
            int[] target = A;

            if (pos != A.length) {

            }

            //배열 데이터 검증
            if (!isSameEvenOdd(target)) {
                //틀리다면 이전의 값이
                return max;
            }

            max = pos;
        }
        boolean rs = isSameEvenOdd(A);
        System.out.println(rs);
        return 0;
    }

    //입력받은 배열이 짝수,홀수가 모두 같은지 체크
    public boolean isSameEvenOdd(int[] arr) {
        int even = 0;
        int odd = 0;

        for (int i = 1; i <= arr.length; i++) {
            int val = arr[i-1];

            //짝수
            if (i % 2 == 0) {
                if (even == 0) {
                    even = val;
                    continue;
                }

                if (even != val) {
                    return false;
                }
            } else {
                if (odd == 0) {
                    odd = val;
                    continue;
                }

                if (odd != val) {
                    return false;
                }
            }
        }

        return true;
    }
}
