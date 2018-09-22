package com.iheartmedia.salesforce.config.handler;

public class FlattenLinkedList {
    static Node head1;
    static Node head2 ;
    static Node head3 ;
    static Node head4 ;
    static Node result;

    static class Node{
        int data;
        Node down;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static void insertHead1(int data){
        Node newNode = new Node(data);
        newNode.down = head1;
        head1 = newNode;
    }

    public static void insertHead2(int data){
        Node newNode = new Node(data);
        newNode.down = head2;
        head2 = newNode;
    }

    public static void insertHead3(int data){
        Node newNode = new Node(data);
        newNode.down = head3;
        head3 = newNode;
    }

    public static void insertHead4(int data){
        Node newNode = new Node(data);
        newNode.down = head4;
        head4 = newNode;
    }

    public static void insertRes(int data){
        Node newNode = new Node(data);
        newNode.down = result;
        result = newNode;
    }

    public static void print(Node head){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.down;
        }
        System.out.println();
    }

    public static Node merge(Node a, Node b){
        Node res = null;
        if(a == null) return b;
        if(b == null) return a;

        if(a != null &&  b != null){
            if(a.data < b.data){
                res = a;
                res.down = merge(a.down, b);
            }else{
                res = b;
                res.down = merge(a, b.down);
            }
        }
        return res;
    }

    public static Node flatten(Node root){
        if(root == null || root.right == null){
            return root;
        }

        root.right = flatten(root.right);

        root = merge(root, root.right);

        return root;
    }


    public static void main(String args[]){

        insertHead1(30);
        insertHead1(8);
        insertHead1(7);
        insertHead1(5);

        print(head1);

        insertHead2(20);
        insertHead2(10);

        print(head2);

        insertHead3(50);
        insertHead3(22);
        insertHead3(19);

        print(head3);

        insertHead4(45);
        insertHead4(40);
        insertHead4(35);
        insertHead4(28);

        print(head4);

        head1.right = head2;
        head2.right = head3;
        head3.right = head4;

        Node res = flatten(head1);
        print(res);
    }
}
