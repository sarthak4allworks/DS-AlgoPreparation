package DataStructures.BinarySearchTree;

import java.util.Scanner;

// DS book problem 57
public class BuildBinarySearchTreeFromSortedArray 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the number of test cases: ");
		int t = s.nextInt();
		while(t-->0)
		{
			System.out.print("Enter the length of the array: ");
			int n = s.nextInt();
			int[] a = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				a[i] = s.nextInt();
			}
			BinarySearchTreeNode root = BuildTreeFromSortedArray(a, 0, n-1);
			BasicADTOfBinarySearchTree.PrintLevelOrderTraversal(root);
		}
		s.close();
	}

	private static BinarySearchTreeNode BuildTreeFromSortedArray(int[] a, int i, int j) 
	{
		if(i > j)
		{
			return null;
		}
		BinarySearchTreeNode newNode = new BinarySearchTreeNode();
		if(i == j)
		{
			newNode.data = a[i];
			newNode.left = newNode.right = null;
		}
		else
		{
			int mid = i+(j-i)/2;
			newNode.data = a[mid];
			newNode.left = BuildTreeFromSortedArray(a, i, mid-1);
			newNode.right = BuildTreeFromSortedArray(a, mid+1, j);
		}
		return newNode;
	}
}
