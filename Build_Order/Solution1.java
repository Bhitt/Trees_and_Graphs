/* 
	Solution 1 
	
	Initialization and setup
	1. Build a graph where each project is a node and its outgoing edges represent the projects that
	depend on it. That is, if A has an edge to B (A -> B), it means B has a dependency on A and
	therefore A must be built before B. Each node also tracks the number of incoming edges.
	2. Initialize a buildOrder array. Once we determine a project's build order, we add it to the
	array. We also continue to iterate through the array, using a toBeProcessed pointer to point to
	the next node to be fully processed.
	3. Find all the nodes with zero incoming edges and add those to a buildOrder array. Set a
	toBeProcessed pointer to the beginning of the array.

	Repeat until toBeProcessed is at the end of the buildOrder:
	1. Read node at toBeProcessed.
		If node is null, then all remaining nodes have a dependecy and we have detected a cycle.
	2. For each child of node:
		Decrement child.dependencies (the number of incoming edges).
		If child.dependencies is zero, add child to end of buildOrder.
	3. Increment toBeProcessed.
*/


/* 
	Time Complexity: O(D + P) time, where P is the number of projects and D is the number of 
		dependency pairs
	Space Complexity: 
*/

/* Find a correct build order */
Project[] findBuildOrder(String[] projects, String[][] dependencies){
	Graph graph = buildGraph(projects, dependencies);
	return orderProjects(graph.getNodes());
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

/* return a list of the projects a correct build order */
Project[] orderProjects(ArrayList<Project> projects){
	Project[] order = new Project[projects.size()];

	/* add "roots" to the build order first */
	int endOfList = addNonDependent(order, projects, 0);

	int toBeProcessed = 0;
	while(toBeProcessed < order.length){
		Project current = order[toBeProcessed];

		/* We have a circular dependency since there are no remaining projects with zero dependencies. */
		if(current == null){
			return null;
		}

		/* remove myself as a dependency */
		ArrayList<Project> children = current.getChildren();
		for(Project child : children){
			child.decrementDependencies();
		}

		/* add children that have no one depending on them */
		endOfList = addNonDependent(order, children, endOfList);
		toBeProcessed++;
	}

	return order;
}

/* a helper function to insert projects with zero dependencies into the order array, starting at
index offset */
int addNonDependent(Project[] order, ArrayList<Project> projects, int offset){
	for(Project project : projects){
		if(project.getNumberDependencies() == 0){
			order[offset] = project;
			offset++;
		}
	}
	return offset;
}

public class Graph {
	private ArrayList<Project> nodes = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();

	public Project getOrCreateNode(String name){
		if(!map.containsKey(name)){
			Project node = new Project(name);
			nodes.add(node);
			map.put(name, node);
		}

		return map.get(name);
	}

	public void addEdge(String startName, String endName){
		Project start = getOrCreateNode(startName);
		Project end = getOrCreateNode(endName);
		start.addNeighbor(end);
	}

	public ArrayList<Project> getNodes() { return nodes;}
}

public class Project {
	private ArrayList<Project> children = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();
	private String name;
	private int dependencies = 0;

	public Project(String n) { name = n;}

	public void addNeighbor(Project node){
		if(!map.containsKey(node.getName())){
			children.add(node);
			map.put(node.getName(), node);
			node.incrementDependencies();
		}
	}

	public void incrementDependencies() { dependencies++;}
	public void decrementDependencies() { dependencies--;}

	public String getName() { return name;}
	public ArrayList<Project> getChildren() { return children;}
	public int getNumberDependencies() { rturn dependencies;}
}