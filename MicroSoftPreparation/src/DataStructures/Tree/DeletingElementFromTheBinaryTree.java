package DataStructures.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//DS book prob 13
public class DeletingElementFromTheBinaryTree 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		TreeNode root = null;
		System.out.print("Insert number of nodes in a tree: ");
		int noOfNodes = s.nextInt();
		for(int i=0 ; i<noOfNodes ; i++)
		{
			root = InsertingAnElementInBinaryTree.InsertInBinaryTree(root, s.nextInt());
		}
		BasicADTOfBinaryTree.printLevelOrderRecursive(root);
		System.out.println();
		System.out.println("Insert no of nodes you want to delete");
		int n = s.nextInt();
		while(n-->0)
		{
			System.out.print("Insert element that you want to delete: ");
			int val = s.nextInt();
			DeleteNodeFromBinaryTree(root, val);
			BasicADTOfBinaryTree.printLevelOrderRecursive(root);
			System.out.println();
		}
		s.close();
	}

	/**
	 * 1- Find the element in the tree
	 * 2- Find the deepest node of the tree
	 * 3- Interchange the val of these nodes
	 * 4- delete the deepest node
	 */
	public static void DeleteNodeFromBinaryTree(TreeNode root, int val) 
	{
		if(root == null)
		{
			System.out.println("Tree is empty.");
			return;
		}
		if(root.left == null && root.right == null)
		{
			if(root.data == val)
			{
				root = null;
				return;
			}
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		TreeNode temp1 = null;
		while(!queue.isEmpty())
		{
			temp1 = queue.pollFirst();
			if(temp1.data == val)
			{
				break;
			}
			if(temp1.left != null)
			{
				queue.add(temp1.left);
			}
			if(temp1.right != null)
			{
				queue.add(temp1.right);
			}
		}
		if(temp1 == null)
		{
			System.out.println("Element is not present in the tree.");
			return;
		}
		
		// find the last node of the tree
		queue.clear();
		TreeNode temp2 = null;
		queue.add(root);
		while(!queue.isEmpty())
		{
			temp2 = queue.pollFirst();
			if(temp2.left != null)
			{
				queue.add(temp2.left);
			}
			if(temp2.right != null)
			{
				queue.add(temp2.right);
			}
		}
		int temp = temp1.data;
		temp1.data = temp2.data;
		temp2.data = temp;
		queue.clear();
		temp2 = null;
		queue.add(root);
		while(!queue.isEmpty())
		{
			temp2 = queue.pollFirst();
			if(temp2.left != null)
			{
				if(temp2.left.data == val)
				{
					temp2.left = null;
				}
				else
				{
					queue.add(temp2.left);
				}
			}
			if(temp2.right != null)
			{
				if(temp2.right.data == val)
				{
					temp2.right = null;
				}
				else
				{
					queue.add(temp2.right);
				}
			}
		}
	}
}
