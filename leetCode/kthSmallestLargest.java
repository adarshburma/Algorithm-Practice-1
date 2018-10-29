package org.practice.courses.courseapi;

import java.util.Stack;

public class KSmallestInBst {

    static Stack<Node> stack = new Stack<Node>();
    static class Node {
        Node left;
        Node right;
        int val;

        Node (int data){
            val = data;
        }
    }

    static void insert(int i, Node root){
        if(root.val < i){
            if(root.right != null){
                insert(i, root.right);
            } else {
                root.right = new Node(i);
            }
        } else if(root.val > i){
            if(root.left != null){
                insert(i, root.left);
            } else {
                root.left = new Node(i);
            }
        }
    }

    static void print(Node root){
        if(root.left != null){
            print(root.left);
        }

        System.out.print(" " + root.val);

        if(root.right != null){
            print(root.right);
        }
    }


    static int kSmallest(Node root, int k){
        int result = 0;
        Node p = root;
        while(!stack.isEmpty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            } else {
                Node t = stack.pop();
                k--;
                if(k == 0){
                    result =  t.val;
                }
                p = t.right;
            }
        }

        return result;
    }

    public static int kthLargest(Node root, int k){
        int result = 0;
        Node p = root;
        while(!stack.isEmpty() || p!= null){
            if(p != null){
                stack.push(p);
                p = p.right;
            } else {
                Node t = stack.pop();
                k--;
                if(k == 0){
                    result = t.val;
                    break;
                }

                p = t.left;
            }
        }

        return result;
    }

    public static void main(String[] args){
        Node root = new Node(5);
        insert(2, root);
        insert(1, root);
        insert(3, root);
        insert(7, root);
        insert(6, root);
        insert(8, root);

        print(root);

        System.out.print("Kth smallest: " + kSmallest(root, 3));
        System.out.print("Kth largest: " + kthLargest(root, 3));
    }
}
