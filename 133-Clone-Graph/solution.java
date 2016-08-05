/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        map.put(node, new UndirectedGraphNode(node.label));
        
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        
        // new a node
        while(!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            for(UndirectedGraphNode next: cur.neighbors) {
                if(!map.containsKey(next)) {
                    map.put(next,new UndirectedGraphNode(next.label));
                    q.offer(next);
                }
            }
        }
        
        // copy neighbors
        
        for(UndirectedGraphNode cur : map.keySet()) {
            
            for(UndirectedGraphNode neighbor : cur.neighbors) {
                map.get(cur).neighbors.add(map.get(neighbor));
            }
            
        }
        
        return map.get(node);
        
        
    }
}