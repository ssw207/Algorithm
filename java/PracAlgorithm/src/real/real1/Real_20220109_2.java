package prac.real;

import java.util.*;

public class Real_20220109_2 {


    public static void main(String[] args) {
        Real_20220109_2 real = new Real_20220109_2();

        int[][] needs = {{1,0,0},{1,1,0},{1,1,0},{1,0,1},{1,1,0},{0,1,1}};
        int r = 2;
        int resut = real.solution(needs, r);
        System.out.println(resut); //3
    }

    public int solution(int[][] needs, int r) {
        int answer = 0;

        //key 완제품번호
        //value : 필요한 부품 list
        Map<Integer, String> products = toMap(needs);
        System.out.println(products.toString());

        //필요한 부품들
        Set<Integer> partsSet = new HashSet<>();
        for (String part : products.values()) {
            for (char c : part.toCharArray()) {
                partsSet.add(Integer.parseInt(c+""));
            }
        }

        System.out.println(partsSet.toString());

        //구매할 부품조합
        List<List<Integer>> buyPartCombinations = getCombination(new ArrayList<>(partsSet), r);

        //최대 몆종류의 완제품을 만들수 있는지
        return getMaxCnt(products, buyPartCombinations);
    }

    private Map<Integer, String> toMap(int[][] needs) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < needs.length; i++) {
            String parts = "";
            int[] need = needs[i];
            for (int j = 0; j < need.length; j++) {
                //사용하는 부품인경우
                if (needs[i][j] == 1) {
                    //부품추가
                    parts = parts + i;
                }
            }

            map.put(i, parts);
        }

        return map;
    }

    private List<List<Integer>> getCombination(List<Integer> list, int r) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp1 = new ArrayList<>();
        tmp1.add(0);
        tmp1.add(1);
        result.add(tmp1);

        List<Integer> tmp2 = new ArrayList<>();
        tmp2.add(0);
        tmp2.add(2);
        result.add(tmp2);

        List<Integer> tmp3 = new ArrayList<>();
        tmp3.add(1);
        tmp3.add(2);
        result.add(tmp3);
        return result;
    }

    private int getMaxCnt(Map<Integer, String> products, List<List<Integer>> buyParts) {
        int max = 0;
        Collection<String> values = products.values();

        for (List<Integer> buyPart : buyParts) {
            boolean isBuy = true;
            int cnt = 0;
            //부품번호 순회
            for (Integer buy: buyPart) {

                if (!values.contains(buy)) {
                    isBuy = false;
                }
            }

            if (isBuy) {
                cnt++;
            }

            max = Math.max(cnt, max);
        }

        return max;
    }
}

