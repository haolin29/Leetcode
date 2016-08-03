/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        
        ListNode runner = head.next;
        ListNode walker = head;
        
        while (runner != null && runner.next != null) {
            if(walker == runner) {
                return true;
            }
            runner = runner.next.next;
            waler = walker.next;
            
        }
        
        return false;
    }
}