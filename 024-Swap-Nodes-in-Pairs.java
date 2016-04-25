public class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;

		while (pre.next != null && pre.next.next != null) {
			ListNode first = pre.next;
			ListNode second = pre.next.next;
			first.next = second.next;
			second.next = first;
			pre.next = second;
			pre = pre.next.next;

		}

		return dummy.next;
	}
}