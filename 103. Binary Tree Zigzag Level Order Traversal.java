public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean order = true; // 定义一个变量 每次都改变方向
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                if (order) {
                    level.add(node.val);
                } else {
                    level.add(0,node.val); // arraylist 逆序插入
                }
                
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            order = !order; // 改变方向 elegant way!
            result.add(level);
        }
     
        return result;
            
    }
}