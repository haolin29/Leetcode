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
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        return helper(lists, 0 , lists.length - 1);
    }
    
    private ListNode helper(ListNode[] lists, int start, int end) {
        // divide and conquer
        // base case
        if (start == end) {
            return lists[start];
        }
        
        int mid = start + (end - start) / 2;
        // divide
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        
        // conquer
        return mergeTwoList(left,right);
        
    }
    
    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                cur = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                cur = list1;
                list1 = list1.next;
            }
        }
        
        if (list1 != null) {
            cur.next = list1;
        }
        
        if (list2 != null) {
            cur.next = list2;
        }
        return dummy.next;
    }
}