/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }

        RandomListNode current = head;
        while(current != null){
            RandomListNode newNode = new RandomListNode(current.label);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        current = head;
        //copy random pointers.
        while(current != null){
            if(current.random != null){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        current = head;
        RandomListNode newHead = head.next;
        while(current != null){
            RandomListNode temp = current.next;
            current.next = temp.next;
            if(temp.next != null){
                temp.next = temp.next.next;
            }
            current = current.next;
        }

        return newHead;

    }
}
