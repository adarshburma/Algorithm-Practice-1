package com.iheartmedia.salesforce.config.handler;

import java.util.Stack;

public class TreeSpiral {

    static class Node{
        Node left;
        Node right;
        int data;

        Node(int data){
            this.data = data;
        }

        void insert(int data){

            if(this.data > data){
                if(this.right != null){
                    right.insert(data);
                }else{
                    right = new Node(data);
                }
            }

            if(this.data < data){
               if(this.left != null){
                   left.insert(data);
               }else{
                   left = new Node(data);
               }
            }
        }

        public void print(){
            if(this.left != null){
                left.print();
            }

            System.out.print(data + " ->");

            if(this.right != null){
                right.print();
            }
        }
    }

    public void printSpiral(Node root){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while(!s1.empty() || !s2.empty()){
            while(!s1.empty()){
                Node temp = s1.peek();
                s1.pop();
                System.out.print(temp.data + "-> ");
                if(temp.right != null){
                    s2.push(temp.right);
                }
                if(temp.left != null){
                    s2.push(temp.left);
                }
            }

            while(!s2.empty()){
                Node temp = s2.peek();
                s2.pop();
                System.out.print(temp.data + "-> ");
                if(temp.left != null){
                    s1.push(temp.left);
                }
                if(temp.right != null){
                    s1.push(temp.right);
                }
            }
        }
    }

    public void printTreeSpiral(Node root){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while(!s1.empty() || !s2.empty()){
            while(!s1.empty()){
                Node temp = s1.peek();
                s1.pop();
                System.out.print(temp.data + "-> ");
                if(temp.right != null){
                    s2.push(temp.right);
                }
                if(temp.left != null){
                    s2.push(temp.left);
                }
            }

            while(!s2.empty()){
                Node temp = s2.peek();
                s2.pop();
                System.out.print(temp.data + "-> ");
                if(temp.left!= null){
                    s1.push(temp.left);
                }
                if(temp.right != null){
                    s1.push(temp.right);
                }
            }
        }
    }

    public static void main(String args[]){
        TreeSpiral.Node node = new Node(5);
        node.insert(2);
        node.insert(1);
        node.insert(3);
        node.insert(7);
        node.insert(6);
        node.insert(8);

        node.print();

        System.out.println();
        TreeSpiral treeSpiral = new TreeSpiral();
        treeSpiral.printTreeSpiral(node);
    }
}
