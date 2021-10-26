/* 
    Solution 1 
    
    Traverse recursively through left and right children. Once you reach a null node, return a 
    counter that starts at zero and increment it through the children. Compare children counts as 
    you go back up, keeping the min.
*/


/* 
    Time Complexity: O(N) time, where N is the number of elements in the tree.
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
    public int MinDepth(TreeNode root) {
            // Tree size 0
            if(root == null) return 0;
        
            // Recursively search and find the min depth
            int left = MinDepth(root.left) + 1;
            int right = MinDepth(root.right) + 1;
        
            if(left == 1 || right == 1){
                return left > right ? left : right;
            }
            return left < right ? left : right;
    }
}

/*
    LEET CODE RESULTS

    Runtime: 256 ms, faster than 93.28% of C# online submissions for Minimum Depth of Binary Tree.
    Memory Usage: 51 MB, less than 85.22% of C# online submissions for Minimum Depth of Binary Tree.
*/