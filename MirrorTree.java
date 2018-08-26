package org.practice.courses.courseapi;

public class MirrorTree {
    static class Node{
        Node left;
        Node right;
        int data;

        Node (int data){
            this.data = data;
        }

        public int getData(){
            return this.data;
        }

        public Node getLeft(){
            return this.left;
        }

        public Node getRight(){
            return this.right;
        }

        public void setLeft(Node left){
            this.left = left;
        }

        public void setRight(Node right){
            this.right = right;
        }

    }

    public boolean isValidBST(Node head, int min, int max){
        if(head == null){
            return true;
        }

        if(head.data <= min || head.data > max){
            return false;
        }

        return isValidBST(head.left, min, head.data) && isValidBST(head.right, head.data, max);
    }

    public void withinRange(Node head, int low, int high){
        if(head == null){
            return;
        }

        if(low <= head.data){
            withinRange(head.left, low, high);
        }

        if(low <= head.data && high >= head.data){
            System.out.println(head.data);
        }

        if(high > head.data){
            withinRange(head.right, low, high);
        }
    }

    public void printTree(Node head){
        if(head != null){
            System.out.println(head.data);
        }

        if(head.left != null){
            printTree(head.left);
        }

        if(head.right != null){
            printTree(head.right);
        }
    }

    public void mirrorTree(Node head){
        if(head == null){
            return;
        }

        mirrorTree(head.left);
        mirrorTree(head.right);

        Node temp = head.left;
        head.left = head.right;
        head.right = temp;
    }

    public int maxDepth(Node head){
        if(head == null){
            return Integer.MIN_VALUE;
        }

        if(head.right == null && head.left == null){
            return 1;
        }

        int maxDepthleft = 1 + maxDepth(head.left);
        int maxDepthright = 1 + maxDepth(head.right);

        return Math.max(maxDepthleft, maxDepthright);
    }

    public int minValueBST(Node head){
        if(head == null){
            return -1;
        }

        if(head.left == null){
            return head.data;
        }

        return minValueBST(head.left);
    }

    public static void main(String args[]){
        MirrorTree mirrorTreeClass = new MirrorTree();
        Node head1 = new Node(4);
        head1.left = new Node(2);
        head1.left.left = new Node(1);
        head1.left.right = new Node(3);
        head1.right = new Node(7);
        System.out.println("Before Mirror : ");
        mirrorTreeClass.printTree(head1);
        System.out.println("Max Depth: " + mirrorTreeClass.maxDepth(head1));
        System.out.println("Min Value: " + mirrorTreeClass.minValueBST(head1));
        mirrorTreeClass.withinRange(head1, 3,7);
        System.out.println("Is valid BST:" + mirrorTreeClass.isValidBST(head1, 1, 8));
    }


}
