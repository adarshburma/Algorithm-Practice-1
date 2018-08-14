import java.util.HashSet;

public class LinkedList {

    Node head;

    public class Node{
        Node next;
        int data;

        public Node(int data){
            this.data = data;
        }
    }

    public void insert(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public Node reversePractice(Node node){
        Node prev = null;
        Node next = null;
        Node current = node;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        node = prev;
        return node;

    }
    public Node reverse(Node node){

        Node current = node;
        Node prev = null;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        node = prev;
        return node;
    }

    public int pop(){
        Node current = head;
        int poped = 0;
        while(current != null){
            System.out.println(current.data);
            if(current.next.next != null){
                System.out.println(current.data);
                poped = current.next.data;
                current.next = null;
            }
            current = current.next;
        }

        return poped;
    }

    public void deleteNodeFromEnd(int n){
        Node fast = head;
        Node slow = head;
        int fast_ctr = 0;
        int slow_ctr = 0;

        while(fast != null){
            fast = fast.next;
            fast_ctr++;
        }

        int offset = fast_ctr - n;
        while (slow_ctr < offset){
            if(slow_ctr == offset-1){
                slow.next = slow.next.next;
                break;
            }
            slow_ctr++;
            slow = slow.next;
        }
    }

    public void removeDuplicatesWithStorage(){
        Node previous = head;
        Node current = head.next;
        HashSet<Integer> hash = new HashSet<>();
        while(current != null){
            if(hash.contains(current.data)){
                previous.next = current.next;
            }else{
                hash.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    public void deleteNodeFromEnd2(int n){
        Node fast = head;
        Node slow = head;
        int fast_ctr = 0;

        while(fast_ctr < n+1){
            fast = fast.next;
            fast_ctr++;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
    }

    public void removeDuplicatesNoStorage(){
        Node slow = head;
        Node fast = null;

        while(slow != null){
            fast = slow;
            while(fast.next != null){
                if(fast.next.data == slow.data){
                    fast.next = fast.next.next;
                }else{
                    fast = fast.next;
                }
            }
            slow = slow.next;
        }
    }

    public void printListFrom(Node node) {
        Node current = node;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
}
