void preOrderTraversal(TreeNode node){
	if(node != null){
		visit(node);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
}

//visit could mean print or whatever is needed