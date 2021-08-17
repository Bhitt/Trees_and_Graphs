/* 
	Solution 1 
	
	Construct and compare pre-order traversal strings (placing a special symbol when encountering 
	null nodes).
*/


/* 
	Time Complexity: O(n + m), where n and m are the number of nodes in T1 and T2 respectively
	Space Complexity: O(n + m)
*/

boolean containsTree(TreeNode t1, TreeNode t2){
	StringBuilder string1 = new StringBuilder();
	StringBuilder string2 = new StringBuilder();

	getOrderString(t1, string1);
	getOrderString(t2, string2);

	return string1.indexOf(string2.toString()) != -1;
}

void getOrderString(TreeNode node, StringBuilder sb){
	if(node == null){
		sb.apend("X");	// add null indicator
		return;
	}
	sb.apend(node.data + " "); // add root
	getOrderString(node.left, sb); // add left
	getOrderString(node.right, sb); // add right
}