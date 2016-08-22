/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode cur = dummy;
        
        while(cur.next != null && cur.next.next != null) {
            ListNode n1 = cur.next, n2 = cur.next.next;
            
            // cur -> n1 -> n2 -> ...
            // cur -> n2 -> n1 -> ...
            
            n1.next = n2.next;
            n2.next = n1;
            cur.next = n2;
            
            cur = n1;
        }
        
        return dummy.next;
    }
}