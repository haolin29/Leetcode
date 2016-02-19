

public class Solution {

	// approach 1: non concise
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        if (head.next.next == null) {
        	if (head.val != head.next.val) return false;
        	else return true;
        }
        ListNode cur = head, mid = head;
        int len = 0;
        while (cur.next != null) {
        	len++;
        	if (len % 2 == 0) mid = mid.next;
        	cur = cur.next;
        }
        if (len % 2 == 1) mid = mid.next;

        ListNode prev = null;

        while(mid != null) {
        	ListNode post = mid.next;
        	mid.next = prev;
        	prev = mid;
        	mid = post;
        }

        cur = head;
        while (prev != null) {
        	if (cur.val != prev.val) return false;
        	cur = cur.next;
        	prev = prev.next;
        }

        return true;

    }
    // approach 2: more concise 
    // 
    public boolean isPalindrome(ListNode head) {
    	ListNode fast = head, 
    			 slow = head;

    	while (fast != null && fast.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	if (fast != null) slow = slow.next;

		slow = reverse(slow);

		// bravo!!
		while (slow != null && head.val == slow.val) {
			slow = slow.next;
			head = head.next;
		}

		return slow == null;

    }

    public ListNode reverse(ListNode head) {
    	ListNode pre = null;
    	while (head != null) {
    		ListNode post = head.next;
    		head.next = pre;
    		pre = head;
    		head = post;
    	}
    	return pre;
    }
}