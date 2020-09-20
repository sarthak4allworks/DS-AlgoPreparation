package DataStructures.Tree;

import java.util.Scanner;

// DS book problem 26
public class LeastCommonAncestor 
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
		System.out.print("Enter 2 elements for which you want to check the LCA: ");
		int num1 = s.nextInt();
		int num2 = s.nextInt();
		TreeNode node = LCA(root, num1, num2);
		System.out.println(node.data);
		s.close();
	}

	private static TreeNode LCA(TreeNode root, int num1, int num2) 
	{
		if(root == null)
		{
			return null;
		}
		if(root.data == num1 || root.data == num2)
		{
			return root;
		}
		TreeNode left = LCA(root.left, num1, num2);
		TreeNode right = LCA(root.right, num1, num2);
		if(left != null && right != null)
		{
			return root;
		}
		else
		{
			return left!=null ? left : right;
		}
	}
}
