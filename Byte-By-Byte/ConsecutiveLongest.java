package org.practice.courses.courseapi.practice12;

public class ConsecutiveLongest {

    static class Node{
        Node left;
        Node right;
        int val;

        Node(int val){
            this.val = val;
        }
    }

    static void insert(Node root, int data){
        if(root.val >= data) {
            if(root.left != null){
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

    static int max(int ... values){
        int max = Integer.MIN_VALUE;
        for(int i : values){
            if(i > max){
                max = i;
            }
        }

        return max;
    }

    static int consecutive(Node root){
        if(root == null) return 0;
        return max(consecutive(root.left, root.val, 1), consecutive(root.right, root.val, 1));
    }

    static int consecutive(Node root, int prev, int length){
        if(root == null){
            return length;
        }

        if(root.val == prev + 1){
            int left = consecutive(root.left, root.val, length+1);
            int right = consecutive(root.right, root.val, length+1);
            return max(left, right);
        } else {
            int left = consecutive(root.left, root.val, 1);
            int right = consecutive(root.right, root.val, 1);
            return max(left, right, length);
        }
    }

    public static void main(String[] args){
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(2);
        root.right.left = new Node(1);
        root.right.right = new Node(3);

        print(root);

        System.out.println("Longest consecutive branch: " + consecutive(root));
    }
}
