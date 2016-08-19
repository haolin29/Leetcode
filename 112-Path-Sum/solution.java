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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return helper(root, sum, 0);
    }
    
    public boolean helper(TreeNode root, int sum, int path) {
        if(root == null) {
            return false;
        }
        
        path += root.val;
        
        if(root.left == null && root.right == null && path == sum) {
            return true;
        }
        
        
        return helper(root.left, sum, path) || helper(root.right, sum, path);
    }
    
}