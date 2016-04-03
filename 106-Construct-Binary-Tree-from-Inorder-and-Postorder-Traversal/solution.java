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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int pos = findRoot(inorder, inStart, inEnd, postorder[postEnd]);
        
        root.left = helper(inorder, inStart, pos - 1, postorder, postStart, postStart + (pos - inStart - 1));
        root.right = helper(inorder, pos + 1,  inEnd, postorder, postStart + pos - inStart, postEnd - 1);
        
        return root;
    }
    
    public int findRoot(int[] inorder, int start, int end, int root) {
        for (; start <= end; start++) {
            if (inorder[start] == root) {
                return start;
            }
        }
        
        return -1;
    }
}