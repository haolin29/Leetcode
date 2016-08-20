/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        TreeLinkNode lastHead = root, lastCur = null, currHead = null, cur = null;
        
        while(lastHead != null) {
            lastCur = lastHead;
            
            while(lastCur != null) {
                if(currHead == null) {
                    currHead = lastHead.left;
                    cur = currHead;
                } else {
                    cur.next = lastCur.left;
                    cur = cur.next;
                }
                
                if(currHead != null) {
                    cur.next = lastCur.right;
                    cur = cur.next;
                }
                
                lastCur = lastCur.next;
            }
            
            lastHead = currHead;
            currHead = null;
        }
    }
}