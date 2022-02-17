package java.prac.src.programers.lv1;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/81301
 */
public class Exam3 {
    public static void main(String[] args) {
        Exam3 exam1 = new Exam3();

        String s = "one4seveneight";
        int result = exam1.solution(s);

        System.out.println(result);
    }

    public int solution(String s) {
        Map<String, String> map = converMap();

        for (String key : map.keySet()) {
            //영어순자 문자열을 숫자 문자열로 변환
            s = s.replaceAll(key, map.get(key));
        }

        //숫자로 변환처리 (s가 숫자 형식이 아니면 에러가 떨어짐)
        return Integer.parseInt(s);
    }

    //치환할 문자열 map
    public Map<String, String> converMap() {
        Map<String,String> map = new HashMap<>();
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");
        return map;
    }
}
