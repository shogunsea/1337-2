// Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.



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
        if(node == null) return node;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        if (node.label % 2 == 0) {
            return bfs(node, map);
        } else {
            if (node.label == 0) {
                UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
                map.put(node, copy);
                dfsRecur(node, map);
                return map.get(node);
            } else {
                return dfsIter(node, map);
            }
        }
    }

    public void dfsRecur(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        // node is already copied
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                UndirectedGraphNode copy = new UndirectedGraphNode(neighbor.label);
                map.put(neighbor, copy);
                dfsRecur(neighbor, map);
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }

    public UndirectedGraphNode dfsIter(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        Stack<UndirectedGraphNode> st = new Stack<UndirectedGraphNode>();
        st.push(node);

        while (!st.isEmpty()) {
            UndirectedGraphNode temp = st.pop();
            for (UndirectedGraphNode neighbor : temp.neighbors) {
                if (!map.containsKey(neighbor)) {
                    UndirectedGraphNode copyN = new UndirectedGraphNode(neighbor.label);
                    st.push(neighbor);
                    map.put(neighbor, copyN);
                }
                map.get(temp).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    
    public UndirectedGraphNode bfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        queue.add(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode current = queue.poll();
            for(UndirectedGraphNode n : current.neighbors){
                if(map.containsKey(n)){
                    map.get(current).neighbors.add(map.get(n));
                }else{
                    queue.add(n);
                    UndirectedGraphNode copyN = new UndirectedGraphNode(n.label);
                    map.put(n, copyN);
                    map.get(current).neighbors.add(copyN);
                }
            }
        }  

        return map.get(node); 
    }
    
}