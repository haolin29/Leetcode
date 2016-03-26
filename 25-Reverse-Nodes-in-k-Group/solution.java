/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        head = dummy;
        while(head.next != null) { // clever 
            head = reverseNextK(head,k);
        }
        
        return dummy.next;
    }
    
    private ListNode reverseNextK(ListNode head, int k) {
        // check if there is enough nodes to reverse
        ListNode nextNode = head;
        for (int i = 0; i < k; i++) {
            if (nextNode.next == null) {
                return nextNode;
            }
            nextNode = nextNode.next;
        }
        
        // start reverse
        ListNode newHead = head.next;
        ListNode prev = head, cur = head.next;
        for (int i = 0; i < k; i++) {
            ListNode post = cur.next;
            cur.next = prev;
            prev = cur;
            cur = post;
        }
        
        newHead.next = cur;
        head.next = prev;
        return newHead;
        
    }
}