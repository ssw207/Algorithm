package java.prac.src.programers.lv1;

//https://programmers.co.kr/learn/courses/30/lessons/12977
public class 소수만들기 {
    public static void main(String[] args) {
        소수만들기 init = new 소수만들기();
        int[] nums = {1,2,7,6,4}; // 항상짝수
        int result = init.solution(nums);
        System.out.println(result); //4
    }
    /*
       1.n : 3 ~ 50 중복x
       2.소수는 1과 자신외에 나눠지면 안됨 => 자신 % 1 ~ 자신까지의 수 == 0 이면 false
       3.n중 3개를 선택후 합한값이 소수가 되는 조합의 갯수를 리턴
    */
    public int solution(int[] nums) {
        //소수 갯수
        int cnt = 0;

        //모든 3자리수 조합 (n!)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) { //앞에서 선택한 숫자는 제외해야하므로 + 1처리
                for (int k = j+1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    System.out.println(String.format("==> %d+%d+%d=%d",nums[i],nums[j],nums[k],sum));

                    //소수판별
                    if (isDecimal(sum)) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    public boolean isDecimal(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
