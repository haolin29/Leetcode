/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        
        return divideLists(lists, 0, lists.length - 1);
    }
    
    public ListNode divideLists(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }
        
        int mid = (start + end) / 2;
        
        ListNode left = divideLists(lists, start, mid);
        ListNode right = divideLists(lists, mid + 1, end);
        
        return mergeTwo(left, right);
    }
    
    public ListNode mergeTwo(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while(left != null && right != null) {
            if(left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            
            cur = cur.next;
        }
        
        if(left != null) {
            cur.next = left;
        }
        
        if(right != null) {
            cur.next = right;
        }
        
        return dummy.next;
    }
}