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
    public class Result {
        int single;
        int max;
        Result(int single, int max) {
            this.single = single;
            this.max = max;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        return helper(root).max;
    }
    
    public Result helper(TreeNode root) {
        if(root == null) {
            return new Result(0, Integer.MIN_VALUE);
        }
        
        Result left = helper(root.left);
        Result right = helper(root.right);
        
        int single = root.val + Math.max(left.single, right.single);
        single = Math.max(0, single);
        
        int max = Math.max(left.max, right.max);
        max = Math.max(max, root.val + left.single + right.single);
        
        return new Result(single, max);
        
    }
}