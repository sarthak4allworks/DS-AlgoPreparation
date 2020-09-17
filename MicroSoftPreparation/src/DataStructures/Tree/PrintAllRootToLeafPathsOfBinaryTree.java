package DataStructures.Tree;

import java.util.Scanner;

// DS book prob 20
public class PrintAllRootToLeafPathsOfBinaryTree
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
		int[] path = new int[noOfNodes];
		for(int i=0 ; i<noOfNodes ; i++)
		{
			path[i] = 0;
		}
		PrintAllNodesToLeafPaths(root, 0, path);
		s.close();
	}

	public static void PrintAllNodesToLeafPaths(TreeNode root, int pathLen, int[] path) 
	{
		if(root == null)
		{
			return;
		}
		path[pathLen] = root.data;
		pathLen++;
		if(root.left == null && root.right == null)
		{
			for(int i=0 ; i<pathLen ; i++)
			{
				System.out.print(path[i]+" ");
			}
			System.out.println();
		}
		else
		{
			PrintAllNodesToLeafPaths(root.left, pathLen, path);
			PrintAllNodesToLeafPaths(root.right, pathLen, path);
		}
	}
}
