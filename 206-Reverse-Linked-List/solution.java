/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode tail = null;
        while(head != null) {
            ListNode post = head.next;
            head.next = tail;
            tail = head;
            head = post;
        }
        
        return tail;
    }
}