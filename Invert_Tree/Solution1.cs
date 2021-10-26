/* 
	Solution 1 
	
	Recursively swap left and right child.
*/


/* 
	Time Complexity: O(n), where n is the number of nodes in the tree 
	Space Complexity: O(1)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Solution {
    public TreeNode InvertTree(TreeNode root) {
        // Reached the end of a branch
        if(root == null) return null;
        
        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // Recurse through children
        InvertTree(root.left);
        InvertTree(root.right);
        
        return root;
    }
}

/*
	LEET CODE RESULTS

	Runtime: 80 ms, faster than 97.68% of C# online submissions for Invert Binary Tree.
	Memory Usage: 37.3 MB, less than 15.68% of C# online submissions for Invert Binary Tree.
*/