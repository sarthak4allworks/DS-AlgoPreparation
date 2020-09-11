package DataStructures.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// DS book problem 1&2
public class FindingMaximumElementInBinaryTree 
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
		int max = FindMaxInBinarySearchTreeRecusively(root);
		System.out.println("Recursive => Maximum element in the tree is: "+max);
		max = FindMaxInBinarySearchTreeIterative(root);
		System.out.println("Iterative => Maximum element in the tree is: "+max);
		s.close();
	}

	public static int FindMaxInBinarySearchTreeIterative(TreeNode root)
	{
		int max = Integer.MIN_VALUE;
		if(root == null)
		{
			return max;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		TreeNode temp = root;
		queue.add(temp);
		while(!queue.isEmpty())
		{
			temp = queue.pollFirst();
			max = temp.data>max ? temp.data : max;
			if(temp.left != null)
			{
				queue.add(temp.left);
			}
			if(temp.right != null)
			{
				queue.add(temp.right);
			}
		}
		return max;
	}

	public static int FindMaxInBinarySearchTreeRecusively(TreeNode root) 
	{
		int root_val = 0, left = 0, right = 0, max = Integer.MIN_VALUE;
		if(root != null)
		{
			root_val = root.data;
			left = FindMaxInBinarySearchTreeRecusively(root.left);
			right = FindMaxInBinarySearchTreeRecusively(root.right);
			max = left>right ? left : right;
			max = root_val>max ? root_val : max;
		}
		return max;
	}
}
