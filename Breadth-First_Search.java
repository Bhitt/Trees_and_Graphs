void search(Node root){
	Queue queue = new Queue();
	root.marked = true;
	queue.enqueue(root); // Add to the end of the queue

	while(!queue.isEmpty()){
		Node r = queue.dequeue(); // Remove from the front of the queue
		visit(r);
		foreach(Node n in r.adjacent){
			if(n.marked == false){
				n.marked = true;
				queue.enqueue(n);
			}
		}
	}
}