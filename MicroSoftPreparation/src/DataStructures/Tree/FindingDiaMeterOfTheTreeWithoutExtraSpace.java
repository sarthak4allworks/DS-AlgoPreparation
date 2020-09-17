package DataStructures.Tree;

import java.util.Scanner;

class Height
{
	int h;
}

//DS book Problem 18
public class FindingDiaMeterOfTheTreeWithoutExtraSpace 
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
		System.out.println(FindDiaMeterOfTheBinaryTree(root)); // O(n^2)
		Height h = new Height();
		System.out.println(FindDiaMeterOfTheBinaryTree(root, h)); // O(n)
		s.close();
	}

	public static int FindDiaMeterOfTheBinaryTree(TreeNode root, Height h) 
	{
		if(root == null)
		{
			h.h = 0;
			return 0;
		}
		Height lh = new Height(), rh = new Height();
		int lDiaMeter = FindDiaMeterOfTheBinaryTree(root.left, lh);
		int rDiaMeter = FindDiaMeterOfTheBinaryTree(root.right, rh);
		h.h = Math.max(lh.h, rh.h) + 1;
		return Math.max(lh.h+rh.h+1, Math.max(lDiaMeter, rDiaMeter));
	}

	public static int FindDiaMeterOfTheBinaryTree(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		int lHight = Height(root.left);
		int rHeight = Height(root.right);
		int lDiameter = FindDiaMeterOfTheBinaryTree(root.left);
		int rDiameter = FindDiaMeterOfTheBinaryTree(root.right);
		return Math.max(lHight+rHeight+1, Math.max(lDiameter, rDiameter));
	}
	
	public static int Height(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else
		{
			return (1+Math.max(Height(root.left), Height(root.right)));
		}
	}
}
