package DataStructures.Tree;

import java.util.Scanner;

// DS book prob 17
public class CompareStructuresOfTwoBinaryTrees
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		TreeNode root1 = null;
		System.out.print("Insert number of nodes in a tree1: ");
		int noOfNodes = s.nextInt();
		for(int i=0 ; i<noOfNodes ; i++)
		{
			root1 = InsertingAnElementInBinaryTree.InsertInBinaryTree(root1, s.nextInt());
		}
		BasicADTOfBinaryTree.printLevelOrderRecursive(root1);
		System.out.println();
		TreeNode root2 = null;
		System.out.print("Insert number of nodes in a tree2: ");
		noOfNodes = s.nextInt();
		for(int i=0 ; i<noOfNodes ; i++)
		{
			root2 = InsertingAnElementInBinaryTree.InsertInBinaryTree(root2, s.nextInt());
		}
		BasicADTOfBinaryTree.printLevelOrderRecursive(root2);
		System.out.println();
		System.out.println(CompareTwoBinaryTrees(root1, root2));
		s.close();
	}

	public static boolean CompareTwoBinaryTrees(TreeNode root1, TreeNode root2) 
	{
		if(root1 == null && root2 == null)
		{
			return true;
		}
		if(root1 == null || root2 == null)
		{
			return false;
		}
		return (root1.data == root2.data) && CompareTwoBinaryTrees(root1.left, root2.left) && CompareTwoBinaryTrees(root1.right, root2.right);
	}
}
