/* 
	Solution 1 
	
	Using logic from in-order traversal, we carefully account for the different cases of which
	node should be next. If there is a right child, then find the leftmost node of the right
	subtree. If there is no right child, traverse up through parents until you come from a left
	subtree to the parent and return that parent. If there is no parent that you arrive to from the
	left, than you have traversed the entire tree and are finished.
*/


/* 
	Time Complexity: 
	Space Complexity: 
*/

TreeNode inorderSucc(TreeNode n){
	if(n == null) return null;

	/* found right children -> return leftmost node of right subtree */
	if(n.right != null){
		return leftMostChild(n.right);
	} else {
		TreeNode q = n;
		TreeNode x = q.parent;
		// Go up until we are on the left instead of right
		while(x != null && x.left != q){
			q = x;
			x = x.parent;
		}
		return x;
	}
}

TreeNode leftMostChild(TreeNode n){
	if(n == null){
		return null;
	}
	while(n.left != null){
		n = n.left;
	}
	return n;
}