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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) {
            return null;
        }
        TreeNode large = p > q ? p : q;
        TreeNode small = p < q ? p : q;
        if(root.val > large) {
            return lowestCommonAncestor(root.left, p,q);
        } else if (root.val < small) {
            return lowestCommonAncestor(root.right, p,q)
        } else if(root.val <= large.val && root.val >= small.val) {
            return root;
        }
    }
}