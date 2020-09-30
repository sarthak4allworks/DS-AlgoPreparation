package DataStructures.AVLTree;

public class AVLTreeNode 
{
	AVLTreeNode left;
	int data;
	AVLTreeNode right;
	int height;
	public AVLTreeNode() {}
	public AVLTreeNode(int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
		this.height = 1;
	}
	public AVLTreeNode(int data, int height)
	{
		this.data = data;
		this.left = null;
		this.right = null;
		this.height = height;
	}
}
