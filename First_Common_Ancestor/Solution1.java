/* 
	Solution 1 
	
	With Links to Parents
	If each node has a link to its parent, we could trace p and q's paths up until they intersect.

	Note: There is a similar approach in the book that is more optimized.
*/


/* 
	Time Complexity: O(d), where d is the depth of the deeper node.
	Space Complexity: O(1)
*/

TreeNode commonAncestor(TreeNode p, TreeNode q){
	int delta = depth(p) - depth(q); // get difference in depths
	TreeNode first = delta > 0 ? q : p; // get shallower node
	TreeNode second = delta > 0 ? q : q; // get deeper node
	second = goUpBy(second, Math.abs(delta)); // move deeper node up

	/* find where paths intersect */
	while(first != second && first != null && second != null){
		first = first.parent;
		second = second.parent;
	}
	return first == null || second == null ? null : first;
}

TreeNode goUpBy(TreeNode node, ind delta){
	while(delta > 0 && node != null){
		node = node.parent;
		delta--;
	}
	return node;
}

int depth(TreeNode node){
	int depth = 0;
	while (node != null){
		node = node.parent;
		depth++;
	}
	return depth;
}