// how to find the middle point
// while(current.next() != null){
 //          length++;
 //          if(length%2 ==0){
 //              middle = middle.next();
 //          }
 //          current = current.next();
 //      }
    
 // if(length%2 == 1){
 //          middle = middle.next();
 //      }


public class Solution {
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

        cur = head;
        while (mid != null) {
        	if (cur.val != mid.val) return false;
        	cur = cur.next;
        	mid = mid.next;
        }

        return true;

    }
}