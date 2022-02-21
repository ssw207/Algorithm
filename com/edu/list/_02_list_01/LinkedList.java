package com.edu.list._02_list_01;

public class LinkedList {

    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));

        //list.print();
        list.reverse();

        //list.print();
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

    /**
     * TODO 단일 연결 리스트를 뒤집는 함수를 구현하라.
     *  예) 1 -> 2 -> 3 -> null  =>   3 -> 2 -> 1
     *  1.현재 노드의 next 가 prev를 보게한다.
     *  2.포인터를 이동한다
     * @return
     */
    private void reverse() {
        LinkedNode prev = null;
        LinkedNode current = this.head; // (1)
        LinkedNode next = null;

        /*

        1회전
        null(P) -> 1(C) -> 2(N) -> 3 null
        null(N) <- 1(P) -> 2(C) -> 3 null

        2회전
        null(N) <- 1(P) 2(C) -> 3 null
        null <- 1(N) <- 2(C) -> 3 null
        null <- 1(N) <- 2(P) -> 3(C) null

        3회전
        null <- 1(N) <- 2(P) -> 3(C) null
        null <- 1 <- 2(N) <- 3(C) null
        null <- 1 <- 2 <- 3(P) null(C)

         */
        int cnt = 0;
        while (current != null) { //모두 순회하면 null이므로 current가 null이면 종료한다
            next = current.next; //next가 사라지지않도록 임시저장 (2) / (3)

            current.next = prev; // 순회 방샹을 바꾼다.

            //포인터를 한칸이동한다.
            prev = current; // (1 1 null 3 null) / (2 2 1 3 null)
            current = next; // (1 2 null 3 null) / (2 1 1 3 null)
        }

        this.tail = this.head;
        this.head = prev;
    }
}
