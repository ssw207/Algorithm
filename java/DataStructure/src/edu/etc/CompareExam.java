package edu.etc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CompareExam {
    public static void main(String[] args) {
        CompareExam compareExam = new CompareExam();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);

        compareExam.comparatorSortAsc(list);
        compareExam.comparatorSortDes(list);
        compareExam.streamSortAsc(list);
        compareExam.streamSortDesc(list);
    }

    //두수를 비교해 첫번째 값이 큰 경우 1을 리턴하면 오름차순 정렬
    private void comparatorSortAsc(List<Integer> list) {
        list.sort((o1, o2) -> {
            return (o1 > o2) ? 1 : -1;
        } );
        System.out.println(list.toString());
    }

    //두수를 비교해 첫번째 값이 큰 경우 1을 리턴하면 내림차순 정렬
    private void comparatorSortDes(List<Integer> list) {
        list.sort((o1, o2) -> {
            return (o1 > o2) ? -1 : 1;
        } );
        System.out.println(list.toString());
    }

    //stream사용해 오름차순 정렬
    private void streamSortAsc(List<Integer> list) {
        List<Integer> result = list.stream()
                //.sorted() // 객체를 주어진 Comparator에 따라 정렬
                //.sorted(Comparator.naturalOrder())
                .sorted((a,b) -> a.compareTo(b))
                .collect(Collectors.toList());
        System.out.println(result.toString());
    }

    //stream사용해 정렬
    private void streamSortDesc(List<Integer> list) {
        List<Integer> result = list.stream()
                //.sorted((a,b) -> b.compareTo(a))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(result.toString());
    }
}
