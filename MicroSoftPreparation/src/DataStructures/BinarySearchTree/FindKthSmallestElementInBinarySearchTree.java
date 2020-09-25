package DataStructures.BinarySearchTree;

import java.util.Scanner;

// DS book problem 60
public class FindKthSmallestElementInBinarySearchTree 
{
	static int count = 0;
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the number of nodes in the tree: ");
		int n = s.nextInt();
		BinarySearchTreeNode root = null;
		for(int i=0 ; i<n ; i++)
		{
			int num = s.nextInt();
			root = BasicADTOfBinarySearchTree.InsertNodeRecursive(root, num);
		}
		BasicADTOfBinarySearchTree.PrintInorderTraversal(root);
		System.out.println();
		System.out.print("Enter the value of k: ");
		int k = s.nextInt();
		BinarySearchTreeNode temp = KthSmallestElement(root, k);
		if(temp!=null)
		{
			System.out.println(temp.data);
		}
		else
		{
			System.out.println("null");
		}
		s.close();
	}

	public static BinarySearchTreeNode KthSmallestElement(BinarySearchTreeNode root, int k)
	{
		if(root == null)
		{
			return null;
		}
		BinarySearchTreeNode left = KthSmallestElement(root.left, k);
		if(left != null)
		{
			return left;
		}
		if(++count == k)
		{
			return root;
		}
		return KthSmallestElement(root.right, k);
	}
}
