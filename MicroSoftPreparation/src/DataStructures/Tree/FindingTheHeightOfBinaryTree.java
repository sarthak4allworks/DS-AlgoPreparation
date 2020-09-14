package DataStructures.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//DS book prob 10 & 11
public class FindingTheHeightOfBinaryTree 
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
		System.out.println(HeightOfBinaryTreeRecursively(root));
		System.out.println(HeightOfBinaryTreeIteratively(root));
		s.close();
	}

	private static int HeightOfBinaryTreeIteratively(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		if(root.left == null && root.right == null)
		{
			return 1;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		TreeNode temp = new TreeNode(Integer.MIN_VALUE);
		queue.add(temp);
		int level = 1;
		while(!queue.isEmpty())
		{
			root = queue.pollFirst();
			if(root.data == Integer.MIN_VALUE)
			{
				if(!queue.isEmpty())
				{
					queue.add(temp);
					level++;
				}
			}
			else
			{
				if(root.left != null)
				{
					queue.add(root.left);
				}
				if(root.right != null)
				{
					queue.add(root.right);
				}
			}
		}
		return level;
	}

	public static int HeightOfBinaryTreeRecursively(TreeNode root)
	{
		int leftHeight = 0, rightHeight = 0;
		if(root == null)
		{
			return 0;
		}
		else
		{
			leftHeight = HeightOfBinaryTreeRecursively(root.left);
			rightHeight = HeightOfBinaryTreeRecursively(root.right);
			if(leftHeight > rightHeight)
			{
				return leftHeight+1;
			}
			else
			{
				return rightHeight+1;
			}
		}
	}
}
