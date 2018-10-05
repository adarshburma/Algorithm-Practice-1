
class LinkedListPalindrome{
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode secondhead = slow.next;
        slow.next = null;
        
        ListNode p1 = secondhead;
        ListNode p2 = p1.next;
        
        while(p1 != null && p2 != null){
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        
        secondhead.next = null;
        
        ListNode p = (p2 == null) ? p1 : p2;
        ListNode q = head;
        
        while(p != null){
            if(p.val != q.val){
                return false;
            }
            
            p = p.next;
            q = q.next;
        }
        
        return true;
    }
}
