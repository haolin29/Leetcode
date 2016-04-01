/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int getLength(ListNode head) {
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = getLength(head);
        k = k % length;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        head = dummy;

        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        
        while (head.next != null) {
            head = head.next;
            tail = tail.next;
        }
        
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
        
        
        
        
        
        
    }
}