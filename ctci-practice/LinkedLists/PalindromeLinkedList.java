package org.practice.courses.courseapi;

import java.util.Stack;

public class PalindromeLinkedList {
    static Node head;
    static class Node{
        Node next;
        int data;

        Node(int data){
            this.data = data;
        }
    }

    static void insert(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    static void print(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ->");
            current = current.next;
        }
        System.out.println();
    }

    static boolean isPallindrome(){
        Stack<Integer> stack = new Stack<>();
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            stack.push(slow.data);
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null){
            slow = slow.next;
        }

        while (slow != null){
            int pop = stack.pop();
            if(slow.data != pop){
                return false;
            }
            slow = slow.next;
        }

        return true;
    }


    public static void main(String[] args){
        insert(1);
        insert(2);
        insert(3);
        insert(2);
        insert(1);

        System.out.println("Is palindrome: " + isPallindrome());


    }

}
