/* 
	Solution 2 
	
	Use DFS to find the build path and keep track of visied nodes to avoid cycles.
*/


/* 
	Time Complexity: O (P + D)
	Space Complexity: 
*/

Stack<Project> findBuildOrder(String[] projects, String[][] dependencies){
	Graph graph = buildGraph(project, dependencies);
	return orderProjects(graph.getNodes());
}

Stack<Project> orderProjects(ArrayList<Project> projects){
	Stack<Project> stack = new Stack<Project>();
	for(Project project : projects){
		if(project.getState() == Project.State.BLANK){
			if(!doDFS(project, stack)){
				return null;
			}
		}
	}
	return stack;
}

boolean doDFS(Project project, Stack<Project> stack){
	if(project.getState() == Project.State.PARTIAL){
		return false; // CYCLE
	}

	if(project.getState() == Project.State.BLANK){
		project.setState(Project.State.PARTIAL);
		ArrayList<Project> children = project.getChildren();
		for(Project child : children){
			if(!doDFS(child, stack)){
				return false;
			}
		}
		project.setState(Project.State.COMPLETE);
		stack.push(project);
	}
	return true;
}

/* Build the graph, adding the edge (a, b) if b is dependent on a. Assume a pair is listed in
 * "build order". The pair (a, b) in dependencies indicates that b depends on a and a must be
 * built before b. */
Graph buildGraph(String[] projects, String[][] dependencies){
	Graph graph = new Graph();
	for(String project : projects){
		graph.createNode(project);
	}

	for(String[] dependency : dependencies){
		String first = dependency[0];
		String sceond = dependency[1];
		graph.addEdge(first, second);
	}
	return graph;
}

/* essentially equivalent to first solution with state info added and dependency count removed */
public class Project {
	public enum State { COMPLETE, PARTIAL, BLANK};
	private State state = State.BLANK;
	private ArrayList<Project> children = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();
	private String name;
	public Project(String n) { name = n;}

	public void addNeighbor(Project node){
		if(!map.containsKey(node.getName())){
			children.add(node);
			map.put(node.getName(), node);
		}
	}


	public State getState() { return state;}
	public void setState(State st){ state= st;}
	public String getName() { return name;}
	public ArrayList<Project> getChildren() { return children;}
}