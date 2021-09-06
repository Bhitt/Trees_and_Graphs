/* 
	Solution 1 
	
	Construct the binary tree by first placing the middle number of the array as the root.
	Then recursively add the middle of the left half, and the middle of the right half to the tree.
	Continue until all values are added.
*/


/* 
	Time Complexity: O(n), where n is the length of nums.
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

public class Solution 
{
    public TreeNode SortedArrayToBST(int[] nums) 
    {
       if(nums == null || nums.Length == 0)
           return null;
        
        return constructBST(nums,0,nums.Length - 1);
    }
    
    private TreeNode constructBST(int[] nums, int left, int right)
    {
    	// No more values to add in this branch
        if(left > right) return null;
        
        // Find the middle value of the subarray
        int mid = left + (right - left) / 2;
        
        // Construct the next tree node with the middle value
        TreeNode current = new TreeNode(nums[mid]);
        
        // Use new tree node to insert half the values to the left and right
        current.left = constructBST(nums,left,mid-1);
        current.right = constructBST(nums,mid+1,right);

        // Return the root node
        return current;
    }
}

/*
	LEET CODE RESULTS

	Runtime: 92 ms, faster than 82.63% of C# online submissions for Convert Sorted Array to Binary 
		Search Tree.
	Memory Usage: 25.4 MB, less than 61.21% of C# online submissions for Convert Sorted Array to 
		Binary Search Tree.
*/