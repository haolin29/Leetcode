/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        
        if (p1 == null || p2 == null) {
            return null;
        }
        
        int lenA = 0;
        int lenB = 0;
        
        while(p1 != null) {
            lenA++;
            p1 = p1.next;
        }
        
        while(p2 != null) {
            lenB++
            p2 = p2.next;
        }
        
        int diff = 0;
        
        if(lenA > lenB){
            diff = lenA-lenB;
            int i=0;
            while(i<diff){
                p1 = p1.next;
                i++;
            }
        }else{
            diff = lenB-lenA;
            int i=0;
            while(i<diff){
                p2 = p2.next;
                i++;
            }
        }
 
        while(p1 != null && p2 != null){
            if(p1.val == p2.val){
                return p1;
            }else{
 
            }
            p1 = p1.next;
            p2 = p2.next;
        }
 
        return null;
        
    }
}