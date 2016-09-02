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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) {
            return result;
        }
        
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        dfs(root, sum - root.val, result, path);
        return result;
    }
    
    public void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
        if(root == null) {
            return;
        }
        
        if(sum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList(path));
            return;
        }
        
        if(root.left != null) {
            path.add(root.left.val);
            dfs(root.left, sum - root.left.val, result, path);
            path.remove(path.size() - 1);
        }
        
        if(root.right != null) {
            path.add(root.right.val);
            dfs(root.right, sum - root.right.val, result, path);
            path.remove(path.size() - 1);
        }
    }
}