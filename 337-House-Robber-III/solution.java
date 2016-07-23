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
    class Result {
        int global;
        int local;

        Result() {
            this.global = 0;
            this.local = 0;
        }
    }

    public int rob(TreeNode root) {
        // global(root) = max{global(root.left) + global(root.right) ,
        // local(root.left) + local(root.right) + root.val)}
        // local(root) = max(root.left, root.right)
        return dfs(root).global;
    }

    public Result dfs(TreeNode root) {
        Result res = new Result();

        if (root != null) {
            Result left = dfs(root.left);
            Result right = dfs(root.right);

            res.local = left.global + right.global;
            res.global = Math.max(left.local + right.local + root.val, res.local);
        }

        return res;

    }
}