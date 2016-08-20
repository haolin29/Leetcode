/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        int min = 0;
        if (left > 0 && right > 0) {
            min = Math.min(left, right);
        } else {
            min = left == 0 ? right : left;
        }
        return min + 1;
        
    }
}