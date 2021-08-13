void inOrderTraversal(TreeNode node){
	if(node != null){
		inOrderTraversal(node.left);
		visit(node);
		inOrderTraversal(node.right);
	}
}

//visit could mean print or whatever is needed