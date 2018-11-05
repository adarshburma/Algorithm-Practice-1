package com.iheartmedia.salesforce.controller.sorting;

public class BoundryTraversalBT {
    static class Node{
        Node left;
        Node right;
        int val;

        public Node(int val){
            this.val = val;
        }
    }

    static void insert(int data, Node root){
        if(root.val < data){
            if(root.right != null){
                insert(data, root.right);
            } else {
                root.right = new Node(data);
            }
        }

        if(root.val > data){
            if(root.left != null){
                insert(data, root.left);
            } else {
                root.left = new Node(data);
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

    static void printBoundrys(Node root){
        if(root != null){
            System.out.print(root.val);
            printLeftSubtree(root.left);
            printLeaftNode(root.left);
            printLeaftNode(root.right);
            printRightSubtree(root.right);
        }
    }

    static void printRightSubtree(Node root){
        if(root != null){
            if(root.right != null){
                System.out.print(" " + root.val);
                printRightSubtree(root.right);
            } else if(root.left != null){
                System.out.print(" " + root.val);
                printRightSubtree(root.left);
            }

        }
    }

    static void printLeftSubtree(Node root){
        if(root != null){
            if(root.left != null){
                System.out.print(" " +root.val);
                printLeftSubtree(root.left);
            }
            else if(root.right != null){
                System.out.print(" "+ root.val);
                printLeftSubtree(root.right);
            }
        }
    }

    static void printLeaftNode(Node root){
        if(root != null){
            printLeaftNode(root.left);
            if(root.left == null && root.right == null){
                System.out.print(" "+ root.val);
            }

            printLeaftNode(root.right);
        }
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
        System.out.println();
        printBoundrys(root);
    }
}
