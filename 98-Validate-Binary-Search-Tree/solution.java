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
        traversal(root);
        return isAscend();
    }
    
    public void traversal(TreeNode root) {
        if(root == null) {
            return;
        }
        
        traversal(root.left);
        
        list.add(root.val);
        
        traversal(root.right);
        
    }
    
    public boolean isAscend() {
        int prev = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) <= prev) {
                return false;
            }
            
            prev = list.get(i);
        }
        
        return true;
    }
}