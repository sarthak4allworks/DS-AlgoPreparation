package DataStructures.Tree;

import java.util.Scanner;

// DS book prob 25
public class IsMirrorOfEachOtherBinaryTree
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		TreeNode root1 = null;
		System.out.print("Insert number of nodes in a tree 1: ");
		int noOfNodes = s.nextInt();
		for(int i=0 ; i<noOfNodes ; i++)
		{
			root1 = InsertingAnElementInBinaryTree.InsertInBinaryTree(root1, s.nextInt());
		}
		BasicADTOfBinaryTree.printLevelOrderRecursive(root1);
		System.out.println();
		TreeNode root2 = null;
		System.out.print("Insert number of nodes in a tree 2: ");
		noOfNodes = s.nextInt();
		for(int i=0 ; i<noOfNodes ; i++)
		{
			root2 = InsertingAnElementInBinaryTree.InsertInBinaryTree(root2, s.nextInt());
		}
		BasicADTOfBinaryTree.printLevelOrderRecursive(root2);
		System.out.println();
		System.out.println(IsMirrorOfEachOther(root1, root2));
		s.close();
	}

	public static boolean IsMirrorOfEachOther(TreeNode root1, TreeNode root2) 
	{
		if(root1 == null && root2 == null)
		{
			return true;
		}
		if(root1 == null || root2 == null)
		{
			return false;
		}
		return ((root1.data == root2.data) && IsMirrorOfEachOther(root1.left, root2.right) && IsMirrorOfEachOther(root1.right, root2.left));
	}
}
