/* 
	Solution 2 
	
	We can modify breadth-first search. With this implementation we want to iterate through the root
	first, then level 2, then level 3, and so on. With each level i, we will have already fully visited
	all nodes on level i - 1. This means that to get which nodes are on level i, we can simply look
	at all the children of the nodes of level i - 1.
*/


/* 
	Time Complexity: O(N) 
	Space Complexity: O(N)
*/

ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
	ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
	/* Visit the root */
	LinkedList<TreeNode> current = new LinkedList<TreeNode>();
	if(root != null){
		current.add(root);
	}

	while(current.size() > 0){
		result.add(current); // add previous level
		LinkedList<TreeNode> parents = current; // go to next level
		current = new LinkedList<TreeNode>();
		for(TreeNode parent : parents){
			/* visit the children */
			if(parents.left != null){
				current.add(parent.left);
			}
			if(parents.right != null){
				current.add(parent.right);
			}
		}
	}
	return result;
}