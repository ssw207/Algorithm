package prac.real;

import java.util.*;

public class Real_20220108 {


    public static void main(String[] args) {
        Real_20220108 real = new Real_20220108();
        //{{1,0,11}}
        //
        /**
         * data = {{1,0,11}}
         * 월요일
         * - 하늘상태코드 : 맑음
         * - 강수상태 : 없음
         * - 온도 : 11도
         */
        int[][] data = {{1, 0, 11}, {3, 1, 15}, {2, 0, 16}, {4, 0, 17}, {2, 0, 15}, {2, 1, 14}, {2, 0, 12}};
        int[] arr = real.solution(data); //2,5
        System.out.println(Arrays.toString(arr));
    }

    public int[] solution(int[][] data) {
        List<Map<String,Integer>> days = toDay(data);

        //요일별 점수 계산
        calcDayScore(days);

        //소개팅하기 좋은날
        Map<String, Integer> bestDay = getBestDay(days);

        //소개팅하기 나쁜날
        Map<String, Integer> worstDay = getWorstDay(days);

        return new int[]{bestDay.get("요일"), (worstDay == null) ? -1 : worstDay.get("요일")};
    }

    /**
     * Map으로 변환
     * @param data
     * @return
     */
    private List<Map<String,Integer>> toDay(int[][] data) {
        List<Map<String,Integer>> days = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            int[] day = data[i];

            Map<String, Integer> map = new HashMap<>();
            map.put("요일", i);
            map.put("하늘", day[0]);
            map.put("강수", day[1]);
            map.put("온도", day[2]);

            days.add(map);
        }
        //System.out.println(days.toString());
        return days;
    }

    /**
     * 점수계산
     * @param days
     */
    private void calcDayScore (List<Map<String, Integer>> days) {
        for (Map<String, Integer> day : days) {
            //온도점수 구하기
            int scoreT = 20 - Math.abs(22-day.get("온도"));
            if (scoreT > 20) {
                scoreT = 20;
            }

            //강수점수 구하기
            int scoreW = getWeatherScore(day.get("하늘"), day.get("강수"));
            if (scoreW > 20) {
                scoreW = 20;
            }

            //점수 합산
            day.put("점수", scoreT + scoreW);
        }
    }

    /**
     * 날씨점수 계산
     * @param weatherCode
     * @param rainCode
     * @return
     */
    private int getWeatherScore(int weatherCode, int rainCode) {
        //하늘상태코드    [맑음(1), 구름조금(2), 구름많음(3), 흐림(4)]
        //강수상태코드	[없음(0), 비(1), 눈(2)]

        if (weatherCode == 1 || weatherCode == 2) { //맑음 구름조금
            return 20;
        }

        if (weatherCode == 3) { // 구름많음
            return 17;
        }

        if (weatherCode == 4) { // 흐림
            return 10;
        }

        if (rainCode == 1) { // 비
            return 5;
        }

        if (rainCode == 2) { // 눈
            return 15;
        }

        throw new IllegalArgumentException("부적절한 코드입니다");
    }

    /**
     * 데이트하기 가장 좋은날 구하기
     * @param days
     * @return
     */
    private Map<String, Integer> getBestDay (List<Map<String, Integer>> days) {
        Map<String, Integer> bestDay = null;
        for (Map<String, Integer> day : days) {
            if (bestDay == null || bestDay.get("점수") < day.get("점수")) {
                bestDay = day;
                continue;
            }

            if ((bestDay.get("점수") == day.get("점수"))
                    && bestDay.get("요일") < day.get("요일")) {
                bestDay = day;
                continue;
            }
        }
        return bestDay;
    }

    /**
     * 데이트하기 가장안좋은날 구하기
     * @param days
     * @return
     */
    private Map<String, Integer> getWorstDay(List<Map<String, Integer>> days) {
        List<Map<String, Integer>> badDays = new ArrayList<>();

        for (Map<String, Integer> day : days) {
            if (day.get("하늘") == 4 // 흐림
                    || day.get("강수") == 1 // 비
                    || day.get("온도") >= 30
                    || day.get("온도") <= 0) {
                badDays.add(day);
            }
        }

        System.out.println(badDays.toString());

        if (badDays.isEmpty()) {
            return null;
        }

        // 점수가 가장 낮은날
        Map<String, Integer> worstDay = null;
        for (Map<String, Integer> badDay : badDays) {
            if (worstDay == null || worstDay.get("점수") > badDay.get("점수")) {
                worstDay = badDay;
            }
        }

        return worstDay;
    }
}

