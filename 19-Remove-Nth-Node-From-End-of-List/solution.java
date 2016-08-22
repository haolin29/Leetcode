/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = dummy;
        
        for(int i = 0; i < n; i++) {
            runner = runner.next;
        }
        
        ListNode walker = dummy;
        while(runner.next != null) {
            runner = runner.next;
            walker = walker.next;
        }
        
        if(walker.next != null) {
            walker.next = walker.next.next;
        }
        
        return dummy.next;
        
    }
}