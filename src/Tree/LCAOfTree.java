class TreeNode{
	public int data;
	public TreeNode left;
	public TreeNode right;
	
	TreeNode(data){
		this.data = data;
	}
}

FindLCA(TreeNode node, int m1, int m2){
	if(node == null)
		return null;
		
	if(node.data == m1 || node.data == m2)
		return node;
	
	TreeNode leftSearch = FindLCA(node.left, m1, m2);
	TreeNode rightSearch = FindLCA(node.right, m1, m2);
	
	if(leftSearch != null && rightSearch != null)
		return node;
		
	return (leftSearch != null) ? leftSearch : rightSearch;
	
}
