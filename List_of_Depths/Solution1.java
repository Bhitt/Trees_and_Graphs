/* 
	Solution 1 
	
	Modify a pre-order traversal algorithm, where we pass in level+1 to the next recursive call. The
	code below provides an implementation using depth-first search.
*/


/* 
	Time Complexity: O(N)
	Space Complexity: O(N)
*/

void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
	if(root == null) return; // base case

	LinkedList<TreeNode> list = null;
	if(list.size() == level) { //level not contained in the list
		list = new LinkedList<TreeNode>();
		/* levels are always traversed in order. So, if this is the first time we've visited level
		 * i, we must have seen levels 0 through i - 1. We can therefore safely add the level at
		 * the end. */
		lists.add(list);
	} else {
		list = lists.get(level);
	}
	list.add(root);
	createLevelLinkedList(root.left, lists, level + 1);
	createLevelLinkedList(root.right, lists, level + 1);
}

ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
	ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
	createLevelLinkedList(root, lists, 0);
	return lists;
}