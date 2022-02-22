package com.edu.list._02_list_02;

import java.util.HashMap;
import java.util.Map;

public class LinkedList {

    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(4));

        list.print();
        LinkedNode node = list.findFromLast2(2);
        System.out.println(node.number);
    }

    /**
     * TODO 단일 연결 리스트의 끝에서 n번째에 위치한 노드를 찾는 함수를 구현하라.
     *  예) findFromLast(1 -> 4 -> 2 -> 3, 2), 끝에서 2번째에 위치한 2를 리턴한다.
     *
     *  해시맵 방법 (시간복잡도 O(N), 공간복잡도 O(N)
     *  1) 해시맵에 모든 노드를 넣는다.
     *  2) 해시맵의 사이즈 - n 번째의 인덱스를 뽑으면 끝에서 n번째인 값이다.
     *     ex) 1, 2, 3, 4 인경우 size() = 4 끝에서 2번째는 index 2
     * @param n
     * @return
     */
    private LinkedNode findFromLast(int n) {
        Map<Integer, LinkedNode> map = new HashMap<>();
        int idx = 0;
        LinkedNode current = this.head;
        while (current.next != null) {
            map.put(idx++, current);
            current = current.next;
        }

        return map.get(map.size() - n);
    }

    /**
     * 순회방식
     * 1) 총 갯수를 알기위해 순회한다 O(N)
     * 2) 끝에서 2번째 노드까지 가기위해 순회한다 O(N)
     * -> 저장하지 않으므로 공간복잡도 O(1), 2O(N)이므로 시간복잡도 O(N)
     * @param n
     * @return
     */
    private LinkedNode findFromLast2(int n) {
        LinkedNode current = this.head; // 최초 시작 노드를
        int length = 0; // 링크드 리스트의 길이를 저장하는 변수

        while (current.next != null) { // 마지막 노드를 체크
            length++; // 순회를 할때마다 length의 길이를 늘리고
            current= current.next; // next를 current에 세팅하면서 전체를 순회
        }

        // 0 1 2  -> 3 - 2 = 1
        current = this.head; // 시작 노드부터 끝에서 n번째까지 순회해야하므로 current를 다시 시작노드로 세팅해줍니다.
        for (int i = 0; i < length - n; i++) { // 처음부터 순회하며 끝에서 n번째 노드를 찾습니다.
            current = current.next;
        }

        return current;
    }

    /**
     * 순회를 한번하는 방식
     * - 2칸 짜리 집게가 있다고 가정
     * - 집가는 최초 head에 같은 위치에 있다가 R이 L과 2칸이상 떨어질때부터 같이 움직임
     * - node가 끝에 동작했을때 L 의 위치가 마지막 n 번째 노드
     *
     * @param n
     * @return
     */
    private LinkedNode findFromLast3(int n) {
        LinkedNode left = this.head, right = this.head;
        int dis = 0;
        while (right.next != null) { // null이면 끝까지 순회한것
            right = right.next; // R이동

            if (dis <= n) { //R이 n회만큼 순회 하지 않았으면 건너뜀
                dis++;
                continue;
            }

            left = left.next; // n회 순회이후 L과 R 같이 이동처리
        }

        return left;
    }


    private void print() {
        LinkedNode nodeToPrint = this.head;
        while(nodeToPrint != null) {
            System.out.println(nodeToPrint.number);
            nodeToPrint = nodeToPrint.next;
        }
    }

    private void add(LinkedNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else if (tail != null) {
            tail.next = node;
            tail = tail.next;
        }
    }

}
