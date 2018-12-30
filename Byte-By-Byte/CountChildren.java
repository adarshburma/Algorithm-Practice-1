package org.practice.courses.courseapi.practice12;

public class CountChildren {
    static class Node{
        Node left;
        Node right;
        int val;
        int children;

        Node(int data){
            this.val = data;
        }
    }

    static void insert(Node root, int data){
        if(root.val >= data){
            if(root.left != null) {
                insert(root.left, data);
            } else {
                root.left = new Node(data);
            }
        }

        if(root.val < data){
            if(root.right != null){
                insert(root.right, data);
            } else {
                root.right = new Node(data);
            }
        }
    }

    static void print(Node root){
        if(root.left != null){
            print(root.left);
        }

        System.out.print(root.val + " ");

        if(root.right != null){
            print(root.right);
        }
    }

    static void dfsHelper(Node root){
        if(root == null) return;

        int left = dfs(root.left);
        int right = dfs(root.right);

        root.children = left + right;
        //removeNullCount(root);
    }

    static int dfs(Node root) {
        if(root.left == null && root.right == null) return 1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        root.children = 1+ left + right;
        return root.children;
    }

//    static void removeNullCount(Node root){
////        if(root.left != null){
////            removeNullCount(root.left);
////        }
////
////        root.children = root.children-2;
////
////        if(root.right != null){
////            removeNullCount(root.right);
////        }
////    }

    static void printChildren(Node root){
        if(root.left != null){
            printChildren(root.left);
        }

        System.out.print(" " + root.children);

        if(root.right != null){
            printChildren(root.right);
        }
    }

    public static void main(String[] args){
        Node root = new Node(5);
        insert(root, 2);
        insert(root, 1);
        insert(root, 3);
        insert(root, 4);
        insert(root, 7);
        insert(root, 6);
        insert(root, 8);

        Node root2 = new Node (5);
        root2.left = new Node(2);
        root2.left.left = new Node(1);
        root2.left.right = new Node(3);
        root2.left.right.right = new Node(4);
        root2.left.right.left = new Node(-1);
        root2.right = new Node(7);
        root2.right.left = new Node(6);
        root2.right.right = new Node(8);

        print(root2);
        dfsHelper(root2);
        printChildren(root2);
    }
}
