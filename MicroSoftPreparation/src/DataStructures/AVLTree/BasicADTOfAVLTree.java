package DataStructures.AVLTree;

public class BasicADTOfAVLTree 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		AVLTreeNode root = null;
		root = InsertNode(root, 5);
		root = InsertNode(root, 4);
		root = InsertNode(root, 6);
		root = InsertNode(root, 1);
		root = InsertNode(root, 2);
		root = InsertNode(root, 3);
		root = InsertNode(root, -1);
		System.out.print("Inorder: ");
		PrintInOrderTraversalOfAVLTree(root);
		System.out.println();
		System.out.print("Preorder: ");
		PrintPreOrderTraversalOfAVLTree(root);
		System.out.println();
		root = DeleteNode(root, 6);
		System.out.print("Inorder: ");
		PrintInOrderTraversalOfAVLTree(root);
		System.out.println();
		System.out.print("Preorder: ");
		PrintPreOrderTraversalOfAVLTree(root);
		System.out.println();
		root = DeleteNode(root, 2);
		System.out.print("Inorder: ");
		PrintInOrderTraversalOfAVLTree(root);
		System.out.println();
		System.out.print("Preorder: ");
		PrintPreOrderTraversalOfAVLTree(root);
		System.out.println();
	}
	
	public static void PrintPreOrderTraversalOfAVLTree(AVLTreeNode root)
	{
		if(root != null)
		{
			System.out.print(root.data+" ");
			PrintPreOrderTraversalOfAVLTree(root.left);
			PrintPreOrderTraversalOfAVLTree(root.right);
		}
	}
	
	public static void PrintInOrderTraversalOfAVLTree(AVLTreeNode root)
	{
		if(root != null)
		{
			PrintInOrderTraversalOfAVLTree(root.left);
			System.out.print(root.data+" ");
			PrintInOrderTraversalOfAVLTree(root.right);
		}
	}
	
	public static AVLTreeNode DeleteNode(AVLTreeNode node, int data)
	{
		if(node == null)
		{
			return node;
		}
		if(data < node.data)
		{
			node.left = DeleteNode(node.left, data);
		}
		else if(data > node.data)
		{
			node.right = DeleteNode(node.right, data);
		}
		else
		{
			if(node.left != null && node.right != null)
			{
				AVLTreeNode temp = getInorderSuccessor(node.right);
				node.data = temp.data;
				node.right = DeleteNode(node.right, temp.data);
			}
			else
			{
				if(node.left != null)
				{
					node = node.left;
				}
				else if(node.right != null)
				{
					node = node.right;
				}
				else
				{
					node = null;
				}
			}
		}
		if(node == null)
		{
			return node;
		}
		node.height = Math.max(getHeightOfNode(node.left), getHeightOfNode(node.right))+1;
		int balance = getBalance(node);
		if(balance > 1 && getBalance(node.left) >= 0)
		{
			return rightRotate(node);
		}
		if(balance > 1 && getBalance(node.left) < 0)
		{
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		if(balance < -1 && getBalance(node.right) <= 0)
		{
			return leftRotate(node);
		}
		if(balance < -1 && getBalance(node.right) > 0)
		{
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}
	
	public static AVLTreeNode InsertNode(AVLTreeNode node, int data)
	{
		if(node== null)
		{
			return new AVLTreeNode(data);
		}
		else if(data < node.data)
		{
			node.left = InsertNode(node.left, data);
		}
		else if(data > node.data)
		{
			node.right = InsertNode(node.right, data);
		}
		else
		{
			return node;
		}
		node.height = Math.max(getHeightOfNode(node.left), getHeightOfNode(node.right))+1;
		int balance = getBalance(node);
		if(balance > 1) // either left-left case or left-right case
		{
			if(data < node.left.data) // left left case
			{
				return rightRotate(node);
			}
			if(data > node.left.data) // left right case
			{
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}
		}
		if(balance < -1) // either right-right case or right-left case
		{
			if(data > node.right.data) // right right case
			{
				return leftRotate(node);
			}
			if(data < node.right.data) // right-left case
			{
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}
		}
		return node;
	}
	
	public static AVLTreeNode leftRotate(AVLTreeNode node)
	{
		AVLTreeNode y = node.right;
		AVLTreeNode x = y.left;
		y.left = node;
		node.right = x;
		node.height = Math.max(getHeightOfNode(node.left), getHeightOfNode(node.right))+1;
		y.height = Math.max(getHeightOfNode(y.left), getHeightOfNode(y.right))+1;
		return y;
	}
	
	public static AVLTreeNode rightRotate(AVLTreeNode node)
	{
		AVLTreeNode y = node.left;
		AVLTreeNode x = y.right;
		y.right = node;
		node.left = x;
		node.height = Math.max(getHeightOfNode(node.left), getHeightOfNode(node.right))+1;
		y.height = Math.max(getHeightOfNode(y.left), getHeightOfNode(y.right))+1;
		return y;
	}
	
	public static int getBalance(AVLTreeNode node)
	{
		if(node == null)
		{
			return 0;
		}
		return getHeightOfNode(node.left) - getHeightOfNode(node.right);
	}
	
	public static int getHeightOfNode(AVLTreeNode node)
	{
		if(node == null)
		{
			return 0;
		}
		return node.height;
	}
	
	public static AVLTreeNode getInorderSuccessor(AVLTreeNode node)
	{
		AVLTreeNode current = node; 
		while (current.left != null) 
		current = current.left; 
		return current;
	}
}
