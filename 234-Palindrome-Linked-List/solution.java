/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null ||  head.next == null) {
            return true;
        }
        
        ListNode left = head, right = head;
        
        Stack<Integer> stack = new Stack<>();
        
        while(right != null && right.next != null) {
            stack.push(left.val);
            left = left.next;
            right = right.next.next;
        }
        if(right != null) stack.pop();
        while(left != null) {
            if(stack.pop() != left.val) {
                return false;
            }
            
            left = left.next;
        }
        
        return true;
        

        
    }
    
    // public ListNode findMiddle(ListNode head) {
    //     ListNode left = head, right = head;
        
    //     while(right != null && right.next != null) {
    //         left = left.next;
    //         right = right.next.next;
    //     }
        
    //     return left;
    // }
    
    // public ListNode reverse(ListNode head) {
    //     if(head == null || head.next == null) {
    //         return head;
    //     }
        
    //     ListNode next = head.next;
    //     ListNode newHead = reverse(next);
    //     next.next = head;
    //     head = null;
        
    //     return newHead;
    // }
}