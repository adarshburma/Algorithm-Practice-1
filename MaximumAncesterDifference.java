package com.iheartmedia.salesforce.config.handler;

public class MaximumAncesterDifference {
    static int res = Integer.MIN_VALUE;
    static class Node{
        Node left;
        Node right;
        int data;

        Node(int data){
            this.data = data;
        }
    }

    public static void insert(Node root, int value){
        if(root.data < value){
            if(root.left != null){
                insert(root.left, value);
            }else{
                root.left = new Node(value);
            }
        }

        if(root.data > value) {
            if(root.right != null){
                insert(root.right, value);
            }else{
                root.right = new Node(value);
            }
        }

    }

    public static void print(Node root){
        if(root.left != null){
            print(root.left);
        }

        System.out.println(root.data + " -> ");

        if(root.right != null){
            print(root.right);
        }
    }

    static int diffUtil(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }

        if(root.left == null && root.right == null){
            return root.data;
        }

        int val = Math.min(diffUtil(root.left), diffUtil(root.right));

        res = Math.max(root.data - val, res);

        return Math.min(val, root.data);
    }

    public static void main(String[] args){
        Node root = new Node (5);
        insert(root, 2);
        insert(root, 1);
        insert(root, 3);
        insert(root, 7);
        insert(root, 6);
        insert(root, 8);

        print(root);

        diffUtil(root);
        System.out.println("Maximum Difference: " + res);
    }
}
