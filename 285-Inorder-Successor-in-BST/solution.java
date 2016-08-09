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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        // find p
        while(root != null && root != p) {
            if(root.val < p.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        
        if(root == null) {
            return null;
        }
        
        if(root.right == null) {
            return successor;
        }
        
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        
        return root;
    }
}