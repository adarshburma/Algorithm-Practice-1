package org.practice.courses.courseapi;

public class SimilarTrees {

    public boolean isSubtree(Node head1, Node head2){

        if(head2 == null){
            return true;
        }

        if(head1 == null){
            return false;
        }

        if(areIdentical(head1, head2)){
            return true;
        }

        return isSubtree(head1.left , head2) || isSubtree(head1.right, head2);
    }

    public boolean areIdentical(Node head1, Node head2){
        if(head1 == null && head2 == null){
            return true;
        }

        if (head1 == null || head2 == null){
            return false;
        }

        return (head1.data == head2.data && areIdentical(head1.left , head2.left) && areIdentical(head1.right, head2.right));
    }

    public boolean checkSimilar(Node head1, Node head2){

        if(head1 == null && head2 == null){
            return true;
        }

        if(head1 == null){
            return false;
        }else if(head2 == null){
            return false;
        }

        if(checkSimilar(head1.left, head2.left) && checkSimilar(head1.right, head2.right)){
            return head1.data == head2.data;
        }

        return false;
    }

    public static void main(String args[]){
        SimilarTrees similarTrees = new SimilarTrees();
        Node head1 = new Node(1);
        Node head1_left = new Node(2);
        head1_left.addChildren(new Node(4), null);
        Node head1_right= new Node(3);
        head1_right.addChildren(new Node(4), null);
        head1.addChildren(head1_left, head1_right);

        Node head2 = new Node(1);
        Node head2_left = new Node(2);
        head2_left.addChildren(new Node(4), null);
        Node head2_right = new Node(3);
        head2_right.addChildren(new Node(4), null);
        head2.addChildren(head2_left, head2_right);
        System.out.println(similarTrees.areIdentical(head1, head2));


        Node head3 = new Node(5);
        Node left = new Node(3);
        Node left_l = new Node(2);
        Node left_r = new Node(4);
        Node right = new Node(7);
        Node right_l = new Node(6);
        Node right_r = new Node(8);
        right.addChildren(right_l,right_r);
        left.addChildren(left_l, left_r);
        head3.addChildren(left, right);

        Node head4 = new Node(7);
        Node left2 = new Node(6);
        Node right2 = new Node(8);
        head4.addChildren(left2, right2);

        System.out.println(similarTrees.isSubtree(head3, head4));
    }
}
