/* 
	Solution 1 
	
	We traverse through the tree using depth-first search. As we visit each node:

	1.Track its runningSum. We'll take this in as a parameter and immediately increment it by node.value.
	2. Look up runningSum - targetSum in the hash table. The value there indicates the total number. Set
	totalPaths to this value.
	3.If runningSum == targetSum, then there's one additional path that starts at the root. Increment
	totalPaths.
	4. Add runningSum to the hash table (incrementing the value if it's already there).
	5. Recurse left and right, counting the number of paths with sum targetSum.
	6. After we've done recursing left and right, decrement the value of runningSum in the hash table.
	This is essentially backing out of our work; it reverses the changes to the hash table so that
	other nodes don't use it.
*/


/* 
	Time Complexity: O(N)
	Space Complexity: O(log N) for a balanced tree, O(n) in an unbalanced tree.
*/

int countPathsWithSum(TreeNode root, int targetSum){
	return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
}

int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount){
	if(node == null) return 0; // base case

	/* count paths with sum ending at the current node */
	runningSum += node.data;
	int sum = runningSum - targetSum;
	int totalPaths = pathCount.getOrDefault(sum, 0);

	/* if runningSum equals targetSum, then one additional path starts at the root. Add in this path */
	if(runningSum == targetSum){
		totalPaths++;
	}

	/* increment pathCount, recurse, then decrement pathCount */
	incrementHashTable(pathCount, runningSum, 1); // increment pathCount
	totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
	totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
	incrementHashTable(pathCount, runningSum, -1); // decrement pathCount

	return totalPaths;
}

incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta){
	int newCount = hashTable.getOrDefault(key, 0) + delta;
	if(newCount == 0){ // remove when zero to reduce space usage
		hashTable.remove(key);
	} else {
		hashTable.put(key, newCount);
	}
}