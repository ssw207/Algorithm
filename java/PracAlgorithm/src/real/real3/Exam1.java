package prac.real.real3;

import javax.swing.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Exam1 {
    public static void main(String[] args) {
        Exam1 exam = new Exam1();
        String s = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
//        String s = "Jane Doe, James Doe, John Doe";
        String rs = exam.solution(s,"Example");
        System.out.println(rs.equals(s));

        System.out.println(rs);
        //System.out.println("12345".substring(0,2));

//        "John Doe <jdoe@example.com>, Peter Parker <pparker@example.com>, Mary Jane Watson-Parker <mjwatsonpa@example.com>, James Doe <jdoe2@example.com>, John Elvis Doe <jedoe@example.com>, Jane Doe <jdoe3@example.com>, Penny Parker <pparker2@example.com>"
//        "John Doe <jdoe@example.com>, Peter Parker <pparker@example.com>, Mary Jane Watson-Parker <mjwatsonpa@example.com>, James Doe <jdoe2@example.com>, John Elvis Doe <jedoe@example.com>, Jane Doe <jdoe2@example.com>, Penny Parker <pparker2@example.com>"
    }

    /**
     * 직원들의 주소를 만들어야됨
     * 이름은 2~3 부분으로 나눠짐
     *  - firt, middle(추가적), last (스페이스로 나눔)
     *  - 영문자
     *  ex) FiestMiddleLast@compay.com
     *      - last이름은 8자리 까지 끊을것(하이픈 사전에 지울것)
     *  - 소문자, 하이픈제외
     *  - 이메일중복시 id@, id2@ 처리
     *  이름 <이메일>,
     */
    public String solution(String names, String compName) {
        String[] nameArr = names.split(",");

        //중복된 사용자명 수를 체크하기 위한 map
        Map<String, Integer> dupNameChkMap = new HashMap<>();

        //최종결과
        StringBuilder result = new StringBuilder();

        for (String name : nameArr) {
            String mailName = getMailName(name);

            //중복된 이름수
            Integer cnt = dupNameChkMap.get(mailName);

            if (cnt == null) {
                dupNameChkMap.put(mailName, 1);
            } else {
                dupNameChkMap.put(mailName, (cnt+1));
                mailName = mailName + (cnt+1);
            }

            // 이메일 만들기
            String email = mailName + "@" + compName.toLowerCase() + ".com";

            System.out.println(result.length());
            if (result.length() != 0) {
                result.append(",");
            }

            // 기존이름 + < 만든이름 + @ + 회사명 + .com)
            result.append(name + " <" + email + ">");
        }
        return result.toString();
    }

    /**
     * 이메일 이름 구하기
     */
    private String getMailName(String name) {
        String replacedName = name.trim().replaceAll("-","");

        String[] parts = replacedName.split(" ");

        String first = "";
        String middle = "";
        String last = "";

        first = parts[0].substring(0,1);

        if (parts.length == 3) {
            middle = parts[1].substring(0,1);
        }

        last = parts[parts.length-1];
        if (parts[parts.length-1].length() > 8) {
            last = last.substring(0,8);
        }

        String mailName = first + middle + last;
        return mailName.toLowerCase();
    }
}
