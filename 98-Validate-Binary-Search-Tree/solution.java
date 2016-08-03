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
    ArrayList<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        list.add(null);
        return traversal(root);
    }
    
    public boolean traversal(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        boolean left = traversal(root.left);
        
        if(list.get(0) != null && root.val <= list.get(0)) {
            return false;
        }
        
        list.set(0, root.val);
        
        boolean right = traversal(root.right);
        return left && right;
        
    }
    

}