package org.practice.courses.courseapi;
/*
* Rank is all numbers less than a number in a array
* */
public class GetRankOfNumber {
    static Node root = null;
    static class Node{
        int left_size = 0;
        Node left;
        Node right;
        int data;

        Node(int data){
            this.data = data;
        }
    }

    static void track(int d){
        if(root == null){
            root = new Node(d);
        }else{
            insert(d, root);
        }
    }

    static void insert(int d, Node root){
        if(root.data >= d){
            if(root.left != null){
                insert(d, root.left);
            }else {
                root.left = new Node(d);
            }
            root.left_size++;
        }else {
            if(root.right != null){
                insert(d,root.right);
            } else{
                root.right = new Node(d);
            }
        }
    }

    static int getRank(int d, Node root){
        if(root.data == d){
            return root.left_size;
        }

        if(root.data > d){
            if(root.left == null){
                return -1;
            } else{
                return getRank(d, root.left);
            }
        } else {
            if(root.right == null){
                return -1;
            }else{
                return root.left_size + 1 + getRank(d, root.right);
            }
        }
    }

    static void print(Node root){
        if(root.left != null){
            print(root.left);
        }

        System.out.print(root.data + "(" + root.left_size + ") " );

        if(root.right != null){
            print(root.right);
        }
    }

    public static void main(String[] args){
        track(20);
        track(15);
        track(25);
        track(10);
        track(5);
        track(13);
        track(23);
        track(24);
        print(root);
        System.out.println();

        System.out.println("Rank of 15 is: "+ getRank(20, root));

    }
}
