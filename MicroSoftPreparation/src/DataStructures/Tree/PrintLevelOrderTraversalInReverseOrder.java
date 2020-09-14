package DataStructures.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

//DS book problem 8
public class PrintLevelOrderTraversalInReverseOrder 
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
		PrintReverseLevelOrderTraversal(root);
		s.close();
	}

	public static void PrintReverseLevelOrderTraversal(TreeNode root)
	{
		if(root == null)
		{
			System.out.println("Tree is empty");
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		TreeNode temp = null;
		while(!queue.isEmpty())
		{
			temp = queue.pollFirst();
			stack.push(temp);
			if(temp.right!=null)
			{
				queue.add(temp.right);
			}
			if(temp.left!=null)
			{
				queue.add(temp.left);
			}
		}
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop().data+" ");
		}
		System.out.println();
	}
}
