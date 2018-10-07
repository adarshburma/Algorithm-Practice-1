class Solution {
    
    public ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode curr = last.next;
        
        while(curr != next){
            last.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = last.next;
        }
        
        return last;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        int i = 0;
        ListNode curr = head;
        
        while(curr != null){
            i++;
            if(i % k == 0){
                pre = reverse(pre, curr.next);
                curr = pre.next;
            } else{
                curr = curr.next;
            }
        }
        
        return fake.next;
    }
}
