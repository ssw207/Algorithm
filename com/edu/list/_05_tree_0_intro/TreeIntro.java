package com.edu.list._05_tree_0_intro;

import javax.lang.model.SourceVersion;
import java.util.Stack;

public class TreeIntro {

    static private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        TreeIntro treeIntro = new TreeIntro();
        treeIntro.ldr1(root);
    }
    
    //중위 순회 왼 중 오 순서
    // 4 ,2 ,5 ,1,6,3,7
    private void ldr1(Node root) {
        if (root != null) {
            ldr1(root.left); // 루트 왼쪽출력
            System.out.println("root.value = " + root.value);
            ldr1(root.right); // 루트 오른쪽출력        }
        }
    }


}
