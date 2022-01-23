package prac.real.kakaoblind2022;

import java.util.*;

public class Exam1 {
    public static void main(String[] args) {
        Exam1 exam = new Exam1();
        String[] id_lst = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] rs = exam.solution(id_lst, report, k); // 정지메일 발송횟수
        System.out.println(Arrays.toString(rs));
    }

    public int[] solution(String[] id_list, String[] reports, int k) {//신고자, 신고한사람 신고자, 몆회이상 신고당해야 정지당하는지 판단하는 플래그
        int[] answer = new int[id_list.length];

        //1)각유저가, 누구를 신고했는지 -> 신고처리결과 몇명이 정지됐는지 메일을 보내줘야 하니까요
        //2)각유저가 신고를 몆회당했는지 알아야합니다 .-> 그래 k번이상 신고를 당하면 메일을 보낸것으로 판단하기 때문입니다.

        Map<String, Integer> 동일인중복신고 = new HashMap();
        Map<String, List<String>> 신고정보 = new HashMap<>(); // 신고당한사람id, {신고자id}
        Map<String, Integer> 메일발송 = new HashMap<>(); // 신고자id, 메일발송횟수

        for (String report : reports) { // muzi
            if (동일인중복신고.containsKey(report)) {
                continue;
            }

            동일인중복신고.put(report, 0); // muzi frodo

            //신고정보 추가
            String[] rpArr = report.split(" ");
            String 신고자 = rpArr[0]; // frodo
            String 신고당한사람 = rpArr[1]; // frodo

            List<String> list = 신고정보.get(신고당한사람);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(신고자);
            신고정보.put(신고당한사람, list);
        }

        //신고메일발송
        for (String id : id_list) {
            List<String> 신고자정보 = 신고정보.get(id);
            if (신고자정보 == null) continue;

            //메일발송
            if (신고자정보.size() >= k) {
                //신고한사람에게 메일발송함
                for (String id2 : 신고자정보) {
                    Integer cnt = 메일발송.get(id2);
                    메일발송.put(id2, ((cnt == null) ? 0 : cnt) + 1); // 메일발송획수 증가처리
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            Integer cnt = 메일발송.get(id_list[i]);
            if (cnt != null) {
                answer[i] = cnt;
            }
        }

        return answer;
    }
}
