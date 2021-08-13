/* 
	Solution 1 
	
	Implementing either DFS or BFS can solve this problem. This solution implements BFS.

	Tradeoffs:
		DFS is simpler to implement since it can be done with recursion.
		BFS can be useful to also find the shortest path.
*/


/* 
	Time Complexity: 
	Space Complexity: 
*/

enum State { Unvisited, Visited, Visiting; }

boolean search(Graph g, Node start, Node end){
	if(start == end) return true;

	//operates as a queue
	LinkedList<Node> q = new LinkedList<Node>();

	for(Node u : g.getNodes()){
		u.state = State.Unvisited;
	}

	start.state = State.Visiting;
	q.add(start);
	Node u;
	while(!q.isEmpty()){
		u = q.removeFirst(); //i.e. dequeue
		if(u != null){
			for(Node v : u.getAdjacent()){
				if(v.state = State.Unvisited){
					if(v == end){
						return true;
					} else {
						v.state = State.Visiting;
						q.add(v);
					}
				}
			}
			u.state = State.Visited;
		}
	}
	return false;
}