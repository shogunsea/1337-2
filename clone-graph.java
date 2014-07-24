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

 		UndirectedGraphNode runner = node;
 		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
 		Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
 		queue.add(node);

 		while(!queue.isEmpty()){
 			UndirectedGraphNode current = queue.poll();

 			if(current != null && !visited.contains(current)){
 				visited.add(current);
 				if(!map.containsKey(current)){
  	    			UndirectedGraphNode copy = new UndirectedGraphNode(current.label);
 		    		map.put(current, copy);
 				}

 				for(UndirectedGraphNode n : current.neighbors){
 				    if(map.containsKey(n)){
 				        map.get(current).neighbors.add(map.get(n));
 				    }else{
 				        UndirectedGraphNode copyN = new UndirectedGraphNode(n.label);
 				        map.put(n, copyN);
 				        map.get(current).neighbors.add(copyN);
 				    }
 					queue.add(n);
 				}
 			}
 		}  

 		return map.get(node); 
    }
}