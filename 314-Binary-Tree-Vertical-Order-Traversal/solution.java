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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        map.put(0, list);
        traversal(root, map, 0);
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(Integer i : map.keySet()) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        
        for(int i = max; i >= min; i-- ) {
            result.add(map.get(i));
        }
        
        return result;
        
    }
    
    public void traversal(TreeNode root, HashMap<Integer, List<Integer>> map, int col) {
        if(root == null) {
            return;
        }
        
        if(root.left != null) {
            if(!map.containsKey(col + 1)) {
                List<Integer> list = new ArrayList<>();
                list.add(root.left.val);
                map.put(col + 1, list);
            } else {
                map.get(col + 1).insert(0,root.left.val);
            } 
        }
        
        if(root.right != null) {
            if(!map.containsKey(col - 1)) {
                List<Integer> list = new ArrayList<>();
                list.add(root.right.val);
                map.put(col - 1, list);
            } else {
                map.get(col - 1).insert(0,root.right.val);
            }  
        }
        
        traversal(root.left, map, col + 1);
        traversal(root.right, map, col - 1);
        
    }
}