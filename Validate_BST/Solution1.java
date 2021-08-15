  
/* 
	Solution 1 
	
	Using in-order traversal, track the last element visited and compare as you go. If the values
	are increasing then it should be a valid BST (assuming no duplicates).
*/


/* 
	Time Complexity: 
	Space Complexity: 
*/

Integer last_printed = null; //static variable (could also use a wrapper class instead)
boolean checkBST(TreeNode n){
	if(n == null) return true;

	// check / recurse left
	if(!checkBST(n.left)) return false;

	// check current
	if(last_printed != null && n.data <= last_printed){
		return false;
	}
	last_printed = n.data;

	// check / recurse right
	if(!checkBST(n.right)) return false;

	return true; //all good
}