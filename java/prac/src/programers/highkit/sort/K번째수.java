package java.prac.src.programers.highkit.sort;


import java.util.Arrays;

//문제 https://programmers.co.kr/learn/courses/30/lessons/42748
public class K번째수 {
    public static void main(String[] args) {
        K번째수 run = new K번째수();
        int[] array= {1, 5, 2, 6, 3, 7, 4};
        int[][] commands= {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] result = run.solution(array, commands);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];

        //4)1~3 단계를 commands 배열의 길이만큼 반복
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];

            //1)시작 ~ 종료 길이만큼 배열을 자른다
            int start = command[0] - 1;
            int end = command[1] ;
            int[] sub = Arrays.copyOfRange(array,start,end);;

            //2)ASC 정렬
            Arrays.sort(sub);

            //3)inex로 조회
            int idx = command[2] - 1;
            result[i] = (sub[idx]);
        }

        return result;
    }
}
