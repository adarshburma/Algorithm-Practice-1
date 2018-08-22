package com.iheartmedia.salesforceproxy.service.properties;

import java.util.ArrayList;
import java.util.List;

public class DetectUniqueElements {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node (int data){
            this.data = data;
        }

        boolean hasChildren(){
            if(left != null || right != null){
                return true;
            }

            return false;
        }

        List<Node> getChildren(){
            List<Node> children = new ArrayList<>();
            if(left != null){
                children.add(left);
            }

            if(right != null){
                children.add(right);
            }

            return children;
        }
    }


    public void inOrderTraversal(Node head){
        if(head == null){
            return;
        }

        inOrderTraversal(head.left);
        System.out.println(head.data);
        inOrderTraversal(head.right);
    }

    public void deleteNode(int data, Node head){
        if(head == null){
            return;
        }

        if(head.left != null && head.left.data == data){
            head.left = null;
        }else if(head.left != null){
            deleteNode(data, head.left);
        }

        if(head.right != null && head.right.data == data){
            head.right = null;
        }else if(head.right != null){
            deleteNode(data, head.right);
        }
    }

    static class Queue{
        List<Node> queue = new ArrayList<>();

        public void insert(Node node){
            queue.add(node);
        }

        public Node remove(){
            Node node= queue.get(0);
            queue.remove(queue.get(0));
            return node;
        }

        public void printQueue(){
            for(Node node : queue){
                System.out.println(node.data);
            }
        }

        public boolean isEmpty(){
            if(queue.size() != 0){
                return false;
            }
            return true;
        }

    }

    public void breadthFirstSearch(Node head){
        if(head == null){
            return;
        }
        Queue queue = new Queue();
        queue.insert(head);
        System.out.println(head.data);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(node.hasChildren()){
                for(Node child : node.getChildren()){
                    System.out.println(child.data);
                    queue.insert(child);
                }
            }
        }
    }

    public void selectThresholdPath(Node node, List<String> path_list, String path, int sum, int threshold, Node head){
        if(node == null){
            return;
        }
        path = path + node.data+ "->";
        sum = sum + node.data;
        if(node.left == null && node.right == null){
            if(sum > threshold){
                path_list.add(path);
            }else{
                System.out.println("data to be deleted: "+ node.data);
                deleteNode(node.data, head);
            }
            path = "";
            sum = 0;
        }else{
            selectThresholdPath(node.left, path_list, path, sum, threshold, head);
            selectThresholdPath(node.right, path_list, path, sum, threshold, head);
        }
    }

    static class DoublyLinkedList{
        Node head;
        class Node{
            Node prev;
            Node next;
            int data;

            Node(int data){
                this.data = data;
            }
        }

        public void insert(int data){
            Node newNode= new Node(data);
            newNode.next = head;
            newNode.prev = null;

            if(head != null){
                head.prev = newNode;
            }

            head = newNode;
        }

        public void printNodes(){
            Node current = head;
            Node last = null;
            System.out.println("Printing forwards ....");
            while(current != null){
                System.out.println(current.data);
                current = current.next;
                if(current.next == null){
                    last = current;
                }
            }

            current = last;
            System.out.println("Printing Backwards ....");
            while(current != null){
                System.out.println(current.data);
                current = current.prev;
            }
        }


    }

    public void detectUnique(int[] arr){
        List<Integer> set = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();
        for(int i=0; i< arr.length; i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
            } else {
                set2.add(arr[i]);
            }
        }
        set.removeAll(set2);
        System.out.println(set);
    }

    public static void main(String args[]){
        List<String> path_list = new ArrayList<>();
        String path = "";
        int sum = 0;
        DetectUniqueElements detectUniqueElements = new DetectUniqueElements();
        detectUniqueElements.detectUnique(new int[] {1,1,3,4,6,7,8,8});

        Node head = new Node(5);
        head.left = new Node(2);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right = new Node(7);
        head.right.left = new Node(6);
        head.right.right = new Node(8);

        detectUniqueElements.selectThresholdPath(head, path_list, path, sum, 8, head);
        System.out.println(path_list);
        System.out.println("InOrder: ");
        detectUniqueElements.inOrderTraversal(head);
        System.out.println("Breadth first search: ");
        detectUniqueElements.breadthFirstSearch(head);
        System.out.println("Doubly linked list forwards and backwards: .... ");
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insert(1);
        doublyLinkedList.insert(2);
        doublyLinkedList.insert(3);
        doublyLinkedList.insert(4);
        doublyLinkedList.printNodes();
    }
}
