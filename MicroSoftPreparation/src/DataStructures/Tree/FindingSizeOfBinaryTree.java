package DataStructures.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

////DS book prob 6 & 7
public class FindingSizeOfBinaryTree 
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
		System.out.println(FindSizeOfBinaryTreeRecursive(root));
		System.out.println(FindSizeOfBinaryTreeIterative(root));
		s.close();
	}

	public static int FindSizeOfBinaryTreeIterative(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		int size = 0;
		queue.add(root);
		TreeNode temp = null;
		while(!queue.isEmpty())
		{
			temp = queue.pollFirst();
			size++;
			if(temp.left!=null)
			{
				queue.add(temp.left);
			}
			if(temp.right!=null)
			{
				queue.add(temp.right);
			}
		}
		return size;
	}

	public static int FindSizeOfBinaryTreeRecursive(TreeNode root) 
	{
		if(root == null)
		{
			return 0;
		}
		return (FindSizeOfBinaryTreeRecursive(root.left) + 1 + FindSizeOfBinaryTreeRecursive(root.right));
	}
}
