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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int cur = 1;
        int next = 0;
        int level = 0;
        
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            cur--;
            
            if(node.left != null) {
                q.add(node.left);
                next++;
            }
            
            if(node.right != null) {
                q.add(node.right);
                next++;
            }
            
            if(cur == 0) {
                cur = next;
                next = 0;
                level++;
            }
        }
        
        return level;
    }
}