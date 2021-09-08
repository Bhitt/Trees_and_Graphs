/* 
	Solution 1 (LEET CODE SOLUTION)
	
	1)Build a hashmap to record the relation of value -> index for inorder, so that we can find the 
		position of root in constant time.
	2)Initialize an integer variable preorderIndex to keep track of the element that will be used 
	to construct the root.
	3)Implement the recursion function arrayToTree which takes a range of inorder and returns the 
	constructed binary tree:
		-if the range is empty, return null;
		-initialize the root with preorder[preorderIndex] and then increment preorderIndex;
		-recursively use the left and right portions of inorder to construct the left and right 
			subtrees.
	4)Simply call the recursion function with the entire range of inorder.
*/


/* 
	Time Complexity: O(N) time, where N is the number of nodes
	Space Complexity: O(N)
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
    int preorderIndex;
    
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        // Keep track of preorder index
        preorderIndex = 0;
        
        // Insert inorder values into hashMap
        Dictionary<int, int> map = new Dictionary<int, int>();
        for(int i = 0; i < inorder.Length; i++){
            map.Add(inorder[i], i);
        }
        
        // Recursively build tree
        return arrayToTree(preorder, 0, preorder.Length - 1, map);
    }
    
    TreeNode arrayToTree(int[] preorder, int left, int right, Dictionary<int, int> map){
        // If no elements left
        if(left > right) return null;
        
        // Select the preorder index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        // Recurse
        root.left = arrayToTree(preorder, left, map[rootValue] - 1, map);
        root.right = arrayToTree(preorder, map[rootValue] + 1, right, map);
        return root;
    }
}

/*
    LEET CODE RESULTS

    Runtime: 96 ms, faster than 86.56% of C# online submissions for Construct Binary Tree from 
        Preorder and Inorder Traversal.
    Memory Usage: 27.4 MB, less than 47.13% of C# online submissions for Construct Binary Tree from 
        Preorder and Inorder Traversal.
*/