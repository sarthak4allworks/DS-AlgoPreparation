package DataStructures.BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BasicADTOfBinarySearchTree 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		BinarySearchTreeNode root = null;
		while(true)
		{
			System.out.println("Press 1 for insert Press 2 for delete and Press 3 for exit");
			int val = s.nextInt();
			if(val == 3)
			{
				break;
			}
			switch(val)
			{
				case 1:
					System.out.print("Input the value to be inserted: ");
					int data = s.nextInt();
					root = InsertNodeRecursive(root, data);
					System.out.print("Level order traversal is: ");
					PrintLevelOrderTraversal(root);
					System.out.print("Inorder Traversal is: ");
					PrintInorderTraversal(root);
					System.out.println();
					break;
				case 2:
					System.out.print("Input the value to be deleted: ");
					data = s.nextInt();
					root = DeleteNode(root, data);
					PrintLevelOrderTraversal(root);
					break;
				default:
					break;
			}
		}
		s.close();
	}

	public static void PrintInorderTraversal(BinarySearchTreeNode root) 
	{
		if(root != null)
		{
			PrintInorderTraversal(root.left);
			System.out.print(root.data+" ");
			PrintInorderTraversal(root.right);
		}	
	}

	public static void PrintLevelOrderTraversal(BinarySearchTreeNode root) 
	{
		if(root == null)
		{
			return;
		}
		Deque<BinarySearchTreeNode> deque = new ArrayDeque<>();
		deque.add(root);
		BinarySearchTreeNode temp = root;
		while(!deque.isEmpty())
		{
			temp = deque.pollFirst();
			System.out.print(temp.data+" ");
			if(temp.left != null) 
			{
				deque.add(temp.left);
			}
			if(temp.right != null)
			{
				deque.add(temp.right);
			}
		}
		System.out.println();
	}

	public static BinarySearchTreeNode DeleteNode(BinarySearchTreeNode root, int data) 
	{
		if(root == null)
		{
			System.out.println("Inserted data is not present in the tree");
			return null;
		}
		if(data < root.data)
		{
			root.left = DeleteNode(root.left, data);
		}
		else if(data > root.data)
		{
			root.right = DeleteNode(root.right, data);
		}
		else
		{
			if(root.left != null && root.right != null)
			{
				BinarySearchTreeNode temp = FindMax(root.left);
				root.data = temp.data;
				root.left = DeleteNode(root.left, root.data);
			}
			else
			{
				if(root.left != null)
				{
					root = root.left;
				}
				else if(root.right != null)
				{
					root = root.right;
				}
				else
				{
					root = null;
				}
			}
		}
		return root;
	}

	private static BinarySearchTreeNode FindMax(BinarySearchTreeNode left) 
	{
		while(left.right!=null)
		{
			left = left.right;
		}
		return left;
	}

	public static BinarySearchTreeNode InsertNodeRecursive(BinarySearchTreeNode root, int data) 
	{
		if(root == null)
		{
			root = new BinarySearchTreeNode(data);
		}
		else
		{
			if(data < root.data)
			{
				root.left = InsertNodeRecursive(root.left, data);
			}
			if(data > root.data)
			{
				root.right = InsertNodeRecursive(root.right, data);
			}
		}
		return root;
	}
}
