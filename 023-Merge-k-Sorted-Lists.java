public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		ListNode head = mergeHelper(lists, 0, lists.length - 1);
		return head;
	}


	public ListNode mergeHelper(ListNode[] lists, int start, int end) {
		// base case 
		if (start == end) {
			return lists[start];
		}

		int mid = start + (end - start) / 2;
		ListNode left = mergeHelper(lists, start, mid);
		ListNode right = mergeHelper(lists, mid + 1, end);

		return mergeTwo(left,right);
	}

	public ListNode mergeTwo(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;

		while (left != null && right != null) {
			if (left.val > right.val) {
				cur.next = right;
				right = right.next;
			} else {
				cur.next = left;
				left = left.next;
			}
			cur = cur.next;

		}

		if (left != null) {
			cur.next = left;
		}

		if (right != null) {
			cur.next = right;
		}

		return dummy.next;
	}
}