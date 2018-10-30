package com.iheartmedia.salesforce.controller.sorting;

import java.util.ArrayDeque;
import java.util.Deque;

public class IsBST {
    static class Node{
        Node left;
        Node right;
        int data;

        Node(int val){
            data = val;
        }
    }

    static void insert(int val, Node root){
        if(root.data < val){
            if(root.right != null){
                insert(val, root.right);
            } else {
                root.right = new Node(val);
            }
        }

        if(root.data > val){
            if(root.left != null){
                insert(val, root.left);
            } else {
                root.left = new Node(val);
            }
        }
    }

    static void print(Node root){
        if(root.left != null){
            print(root.left);
        }
        System.out.println(root.data);
        if(root.right != null){
            print(root.right);
        }
    }

    static class NodeBounds{
        Node node;
        int lower;
        int upper;

        NodeBounds(Node node, int lower, int upper){
            this.node = node;
            this.lower = lower;
            this.upper = upper;
        }
    }

    static boolean isBST(Node root){
        Deque<NodeBounds> queue = new ArrayDeque<>();
        NodeBounds node = new NodeBounds(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        queue.push(node);

        while (!queue.isEmpty()){
            NodeBounds nb = queue.pop();
            Node nbNode  = nb.node;
            int lowerBound = nb.lower;
            int upperBound = nb.upper;

            if(nbNode.data <= lowerBound || nbNode.data >= upperBound){
                return false;
            }

            if(nbNode.left != null){
                queue.push(new NodeBounds(nbNode.left, lowerBound, nbNode.data));
            }

            if(nbNode.right != null){
                queue.push(new NodeBounds(nbNode.right, nbNode.data, upperBound));
            }
        }

        return true;
    }


    static class NodeBounds2{
        Node node;
        int lower;
        int upper;

        NodeBounds2(Node node, int lower, int upper){
            this.node = node;
            this.lower = lower;
            this.upper = upper;
        }
    }

    static boolean isBST2(Node root){
        Deque<NodeBounds2> queue = new ArrayDeque<>();
        queue.push(new NodeBounds2(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        while(!queue.isEmpty()){
            NodeBounds2 nodeBounds2 = queue.pop();
            Node nb2 = nodeBounds2.node;
            int lowerbound = nodeBounds2.lower;
            int upperbound = nodeBounds2.upper;

            if(nb2.data < lowerbound || nb2.data > upperbound){
                return false;
            }

            if(nb2.left != null) {
                queue.push(new NodeBounds2(nb2.left, lowerbound, nb2.data));
            }

            if(nb2.right != null){
                queue.push(new NodeBounds2(nb2.right, nb2.data, upperbound));
            }
        }

        return true;
    }

    public static void main(String[] args){
        Node root = new Node(5);
        insert(2,root);
        insert(1,root);
        insert(3,root);
        insert(7,root);
        insert(6,root);
        insert(8,root);

        print(root);

        Node root2 = new Node(5);
        root2.right= new Node (2);
        root2.left = new Node(6);


        System.out.println("IS BST:" + isBST(root2));
        System.out.println("IS BST2: " + isBST2(root));
    }
}
