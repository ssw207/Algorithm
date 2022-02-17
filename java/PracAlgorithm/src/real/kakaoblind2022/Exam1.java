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

    /**
     * 15줄 이내 메서드로 분리
     * 메서드는 단일책임
     * 1뎁스 이하로
     */
    public int[] solution(String[] id_list, String[] reports, int k) {//신고자, 신고한사람 신고자, 몆회이상 신고당해야 정지당하는지 판단하는 플래그
        //1)각유저가, 누구를 신고했는지 -> 신고처리결과 몇명이 정지됐는지 메일을 보내줘야 하니까요
        //2)각유저가 신고를 몆회당했는지 알아야합니다 .-> 그래 k번이상 신고를 당하면 메일을 보낸것으로 판단하기 때문입니다.

        //신고정보 map으로 전환
        Map<String, List<String>> reportMap = getReportMap(reports);

        //신고자 메일발송 정보구하기
        Map<String, Integer> sendMailMap = getSendMailMap(id_list, k, reportMap);

        //신고자의 메일발송횟수를 저장한 배열 리턴
        return getSendMailCnt(id_list, sendMailMap);
    }

    /**
     * 신고정보를 map으로 반환
     * TODO 이미 신고한지 체크하지 않고 신고자를 List가 아니라 Set으로 처리하면 중복체크를 하지 않아도됨. 중복일경우 스킵하는게 성능상 약간이라도 이득이지만 set으로 처리하는게 코드가더 짧다.
     */
    private Map<String, List<String>> getReportMap(String[] reports) {
        Map<String, Integer> dupReportMap = new HashMap();
        Map<String, List<String>> reportMap = new HashMap<>(); // 신고정보 : key:신고당한사람id, value:{신고자id}

        for (String report : reports) {
            //존재하면 이미 신고한 정보이므로 스킵
            if (dupReportMap.containsKey(report)) {
                continue;
            }

            //신고정보 추가
            addReportInfo(reportMap, report);
            dupReportMap.put(report, 0);
        }

        return reportMap;
    }

    /**
     * 신고정보를 map에 추가
     */
    private void addReportInfo(Map<String, List<String>> reportMap, String report) {
        String[] reportInfoArr = report.split(" ");
        String reporter = reportInfoArr[0]; // frodo
        String respondent = reportInfoArr[1]; // frodo

        List<String> reporters = reportMap.getOrDefault(respondent, new ArrayList<>());
        reporters.add(reporter);
        reportMap.put(respondent, reporters);
    }

    /**
     * 메일발송정보 map
     *  @return Map -> key:사용자Id, value:신고메일발송횟수
     */
    private Map<String, Integer> getSendMailMap(String[] id_list, int cntMaxReport, Map<String, List<String>> reportMap) {
        Map<String, Integer> sendMailMap = new HashMap<>(); //신고자id, 메일발송횟수

        //신고메일발송
        for (String id : id_list) {
            List<String> reporters = reportMap.get(id);
            if (reporters == null) continue;

            //신고자수가 cntMaxReport 이상이면 메일발송
            if (reporters.size() >= cntMaxReport) {

                //신고한사람에게 메일발송함
                for (String reporter : reporters) {
                    Integer cntSendMail = sendMailMap.getOrDefault(reporter, 0);
                    sendMailMap.put(reporter, cntSendMail + 1); // 메일발송횟수 증가처리
                }
            }
        }
        return sendMailMap;
    }

    /**
     * 사용자별 메일발송 횟수가 담긴 배열 리턴
     */
    private int[] getSendMailCnt(String[] id_list, Map<String, Integer> sendMailMap) {
        int[] sendMailArr = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            Integer cnt = sendMailMap.get(id_list[i]);
            if (cnt == null) continue;

            sendMailArr[i] = cnt;
        }
        return sendMailArr;
    }
}
