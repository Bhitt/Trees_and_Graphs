/* 
	Solution 1 
	
	We will check the height of each subtree as we recurse down form the root. On each node, we recursively
	get the heights of the left and right subtrees through the checkHeight method. If the subtree is
	balanced, then checkHeight will return the actual height of the subtree. If the subtree is not
	balanced, then checkHeight will return an error code. We will immediately break and return an
	error code from the current call. For the error code, we will use Integer.MIN_VALUE.
*/


/* 
	Time Complexity: O(N)
	Space Complexity: O(H), where H is the height of the tree
*/

int checkHeight(TreeNode root){
	if(root == null) return -1;

	int leftHeight = checkHeight(root.left);
	if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // pass error up

	int rightHeight = checkHeight(root.right);
	if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // pass error up

	int heightDiff = leftHeight - rightHeight;
	if(Math.abs(heightDiff) > 1){
		return Integer.MIN_VALUE; // FOUND ERROR -> pass it back
	} else {
		return Math.max(leftHeight, rightHeight) + 1;
	}
}

boolean isBalanced(TreeNode root){
	return checkHeight(root) != Integer.MIN_VALUE;
}