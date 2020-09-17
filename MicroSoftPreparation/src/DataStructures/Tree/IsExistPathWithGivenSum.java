package DataStructures.Tree;

import java.util.Scanner;

// DS book prob 21
public class IsExistPathWithGivenSum 
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
		System.out.println("Enter the sum to be checked: ");
		int sum = s.nextInt();
		System.out.println(IsSumAvailableInThePath(root, sum));
		s.close();
	}

	public static boolean IsSumAvailableInThePath(TreeNode root, int sum) 
	{
		if(root == null)
		{
			return sum == 0;
		}
		else
		{
			int remainingSum = sum - root.data;
			if((root.left != null && root.right != null) || (root.left == null && root.right == null))
			{
				return (IsSumAvailableInThePath(root.left, remainingSum) || IsSumAvailableInThePath(root.right, remainingSum));
			}
			else if(root.left != null)
			{
				return IsSumAvailableInThePath(root.left, remainingSum);
			}
			else
			{
				return IsSumAvailableInThePath(root.right, remainingSum);
			}
		}
	}
}
