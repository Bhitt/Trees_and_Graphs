/* 
	Solution 2 
	
	Without Links to Parents
	Follow a chain in which p and q are on the same side. That is, if p and q are both on the left
	of the node, branch left to look for the common ancestor. If they are both on the right, branch
	right to look for the common ancestor. When p and q are no longer on the same side, you must have
	found the first common ancestor.

	Note: There is a similar approach in the book that is more optimized.
*/


/* 
	Time Complexity: O(n) on a balanced tree.
	Space Complexity: O(1)
*/

TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
	/* error check - one node is not in the tree */
	if(!covers(root, p) || !covers(root, q)){
		return null;
	}
	return ancestorHelper(root, p, q);
}

TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q){
	if(root == null || root == p || root == q){
		return root;
	}

	boolean pIsOnLeft = covers(root.left, p);
	boolean qIsOnLeft = covers(root.left, q);
	if(pIsOnLeft != qIsOnLeft) { // Nodes are on different side
		return root;
	}
	TreeNode childSide = pIsOnLeft ? root.left : root.right;
	return ancestorHelper(childSide, p, q);
}

boolean covers(TreeNode root, TreeNode p){
	if(root == null) return false;
	if(root == p) return true;
	return covers(root.left, p) || covers(root.right, p);
}
