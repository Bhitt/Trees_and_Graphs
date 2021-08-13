void postOrderTraversal(TreeNode node){
	if(node != null){
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		visit(node);
	}
}

//visit could mean print or whatever is needed