package org.practice.courses.courseapi.practice12;
import java.util.LinkedList;

public class BalanceTree {

    static class Node{
        Node left;
        Node right;
        int val;
        int children;

        Node(int data){
            this.val = data;
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

    static int height(Node root){
        if(root == null) return 0;

        if(root.left == null && root.right == null){
            return 0;
        }

        int left =  height(root.left);
        int right = height(root.right);

        return 1+ Math.max(left,right);
    }

    static int balancedHeight(Node root){
        if(root == null) return 0;
        int h1= balancedHeight(root.left);
        int h2 = balancedHeight(root.right);

        if(h1 == -1 || h2 == -1) return -1;
        if(Math.abs(h1-h2) > 1) return -1;

        if(h1 > h2) return 1 + h1;
        return 1 + h2;
    }

    static boolean isBalanced2(Node root){
        if (balancedHeight(root) > -1) return true;
        return false;
    }

    static boolean isBalanced(Node root){
        if(root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight-rightHeight) < 1){
            return true;
        }

        return false;
    }

    static class BNode{
        Node node;
        int min;
        int max;

        BNode(Node node, int min, int max){
            this.node = node;
            this.min = min;
            this.max = max;
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

    
    // Sams Solution
    
    static boolean isBSTHelper(Node root){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBST(Node root, int min, int max){
        if(root == null) return true;
        if(root.val < min || root.val > max) return false;
        return isBST(root.left, min, root.val) && isBST(root.right, root.val+1, max);
    }


    static boolean isvalidBST(Node root){
        LinkedList<BNode> queue= new LinkedList<>();
        queue.addLast(new BNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        while(!queue.isEmpty()){
            BNode bnode = queue.removeFirst();
            Node cur = bnode.node;

            if(cur.val <= bnode.min || cur.val >= bnode.max){
                return false;
            }

            if(cur.left != null){
                queue.add(new BNode(cur.left, bnode.min, cur.val));
            }

            if(cur.right != null){
                queue.add(new BNode(cur.right, cur.val+1, bnode.max));
            }
        }

        return true;
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
        System.out.println("is Balanced" + isBalanced2(root2));

        System.out.println("is valid BST" + isvalidBST(root2));
    }
}
