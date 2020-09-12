package DataStructures.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//// DS book problem 3 & 4
public class SearchingAnElementInBinaryTree 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		TreeNode root= null;
		// n contains the number of nodes in a tree
		System.out.print("Please enter the number of node: ");
		int n = s.nextInt();
		for(int i=0 ; i<n ; i++)
		{
			root = InsertingAnElementInBinaryTree.InsertInBinaryTree(root, s.nextInt());
		}
		System.out.println("After inserting all the elements in tree the level order traversal is: ");
		BasicADTOfBinaryTree.printLevelOrderRecursive(root);
		System.out.println();
		System.out.print("Please enter the number to be find: ");
		int num = s.nextInt();
		boolean res = FindNumInABinaryTreeRecursively(root, num);
		System.out.println(res);
		res = FindNumInBinaryTreeIteratively(root, num);
		System.out.println(res);
		s.close();
	}

	public static boolean FindNumInBinaryTreeIteratively(TreeNode root, int num) 
	{
		if(root == null)
		{
			return false;
		}
		boolean res = false;
		Deque<TreeNode> queue = new ArrayDeque<>();
		TreeNode temp = root;
		queue.add(temp);
		while(!queue.isEmpty())
		{
			temp = queue.pollFirst();
			if(temp.data == num)
			{
				res = true;
				break;
			}
			if(temp.left!=null)
			{
				queue.add(temp.left);
			}
			if(temp.right != null)
			{
				queue.add(temp.right);
			}
		}
		return res;
	}

	public static boolean FindNumInABinaryTreeRecursively(TreeNode root, int num)
	{
		if(root == null)
		{
			return false;
		}
		else
		{
			if(root.data == num)
			{
				return true;
			}
			if(FindNumInABinaryTreeRecursively(root.left, num))
			{
				return true;
			}
			else
			{
				return FindNumInABinaryTreeRecursively(root.right, num);
			}
		}
	}
}
