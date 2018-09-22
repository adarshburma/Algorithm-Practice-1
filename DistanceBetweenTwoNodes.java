package com.iheartmedia.salesforce.config.handler;

public class DistanceBetweenTwoNodes {

    static class Node{
        Node left;
        Node right;
        int data;

        Node(int data){
            this.data = data;
        }
    }

    public static void insert(Node root, int value){
        if(root.data > value){
            if(root.left != null){
                insert(root.left, value);
            }else{
                root.left = new Node(value);
            }
        }

        if(root.data < value) {
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

    public static Node Lca(Node root, int a , int b){
        if(root == null){
            return root;
        }

        if(root.data == a || root.data == b){
            return root;
        }

        Node left = Lca(root.left, a, b);
        Node right = Lca(root.right, a, b);

        if(left != null && right != null){
            return root;
        }

        if(left != null){
            return Lca(root.left, a, b);
        }

        return Lca(root.right, a, b);
    }

    public static int level(Node root, int a, int level){
        if(root == null){
            return -1;
        }

        if(root.data == a){
            return level;
        }

        int left = level(root.left, a, level+1);
        if(left == -1){
            return level(root.right, a, level+1);
        }

        return left;
    }

    public static int findDistance(Node root, int a, int b){
        Node lca = Lca(root, a, b);
        int d1= level(lca, a, 0);
        int d2 = level(lca, b, 0);
        return d1 + d2;
    }

    public static void main(String args[]){
        Node root = new Node(5);
        insert(root, 2);
        insert(root, 1);
        insert(root, 3);
        insert(root, 7);
        insert(root, 6);
        insert(root, 8);

        print(root);

        System.out.println(" Distance between 1 and 7: " + findDistance(root, 1,7));
    }
}
