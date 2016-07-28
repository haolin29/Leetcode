/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            cur.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val) / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        
        while (l1 != null) {
            cur.next = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
            cur = cur.next;
        }
        
        while (l2 != null) {
            cur.next = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            l2 = l1.next;
            cur = cur.next;
        }
        
        return dummy.next;
    }
}