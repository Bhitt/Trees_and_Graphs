  
/* 
	Solution 2 
	
	Use ranges of min and max while recursing through the tree to validate that
	left.data <= current.data < right.data
*/


/* 
	Time Complexity: O(N)
	Space Complexity: O(log N)
*/

boolean checkBST(TreeNode n){
	return checkBST(n, null, null);
}

boolean checkBST(TreeNode n, Integer min, Integer max){
	if(n == null){
		return true;
	}

	if((min != null && n.data <= min) || (max != null && n.data > max)){
		return false;
	}

	if(!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)){
		return false;
	}
	return true;
}