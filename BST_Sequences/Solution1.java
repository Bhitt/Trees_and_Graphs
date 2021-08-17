/* 
	Solution 1 
	
	Explanation in book on page 262
*/


/* 
	Time Complexity: 
	Space Complexity: 
*/

ArrayList<LinkedList<Integer>> allSequences(TreeNode node){
	ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

	if(node == null){
		result.add(new LinkedList<Integer>());
		return result;
	}

	LinkedList<Integer> prefex = new LinkedList<Integer>();
	prefix.add(node.data);

	/* recurse on the left and right subtrees */
	ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
	ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

	/* weave together each list from the left and right sides */
	for(LinkedList<Integer> left : leftSeq){
		for(LinkedList<Integer> right : rightSeq){
			ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
			weaveLists(left, right, weaved, prefix);
			result.addAll(weaved);
		}
	}
	return result;
}

/* weave lists together in all possible ways. This algorithm works by removing the head from one
 list, recursing, and then doing the same thing with the other list */
void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
	ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix){
	/* one list is empty. add remained to [a cloned] prefix and store the result */
	if(first.size() == 0 || second.size() == 0){
		LinkedList<Integer> result = (LinkedList<Integer>)prefix.clone();
		result.addAll(first);
		result.addAll(second);
		resuls.add(result);
		return;
	}

	/* Recurse with head of first added to the prefix. Removing the head will damage first, so we'll
	need to put it back where we found it afterwards. */
	int headFirst = first.removeFirst();
	prefix.addLast(headFirst);
	weaveLists(first, second, results, prefix);
	prefix.removeLast();
	first.addFirst(headFirst);

	/* do the same thing with second, damaging and then restoring the list */
	int headSecond = second.removeFirst();
	prefix.addLast(headSecond);
	weaveLists(first, second, results, prefix);
	prefix.removeLast();
	second.addFirst(headSecond);
}