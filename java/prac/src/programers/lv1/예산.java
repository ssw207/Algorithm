package java.prac.src.programers.lv1;

//https://programmers.co.kr/learn/courses/30/lessons/1845
public class 예산 {
    public static void main(String[] args) {
        예산 init = new 예산();
        int[] nums = {1,3,2}; // 항상짝수
        int budget = 9;
        int result = init.solution(nums, budget);
        System.out.println(result);
    }

    public int solution(int[] d, int budget) {
        int cntBuy = 0;

        //조합 3!
        for (int i = 0; i < d.length; i++) {
            for (int j = i+1; j < d.length; j++) {
                for (int k = j+1; k < d.length; k++) {
                    int sum = d[i] + d[j] + d[k];

                    if (budget > sum) {
                        cntBuy++;
                        //System.out.println(String.format("i(%s) + j(%s) + k(%s) = (%s) vs 예산(%s) 구매수(%s)", d[i],d[j],d[k],sum,budget,cntBuy));
                    }
                    System.out.println(String.format("i(%s) + j(%s) + k(%s)", i,j,k));
                }
            }
        }
        return cntBuy;
    }
}
