package org.practice.courses.courseapi.practice12;

import java.util.Stack;

public class InorderNoRecursion {
    static class Node{
        Node left;
        Node right;
        int val;

        Node(int data){
            this.val = data;
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
    static void printNoRecursion(Node root){
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while(!stack.isEmpty() || p != null){
            if(p != null){
                stack.push(p);
                p = p .left;
            } else {
                Node n = stack.pop();
                System.out.print(n.val + " ");
                p = n.right;
            }
        }
    }


    //Sams solution ...
    
    static void inOrderPrint(Node root){
        Stack<Node> stack = new Stack<>();
        addLeftToStack(stack, root);
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            System.out.print(curr.val + " ");
            if(curr.right != null){
                addLeftToStack(stack, curr.right);
            }
        }
    }

    static void addLeftToStack(Stack<Node> stack ,Node root){
        while(root != null){
            stack.push(root);
            root =root.left;
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

        print(root);
        System.out.println();
        printNoRecursion(root);
        System.out.println();
        inOrderPrint(root);
    }
}
