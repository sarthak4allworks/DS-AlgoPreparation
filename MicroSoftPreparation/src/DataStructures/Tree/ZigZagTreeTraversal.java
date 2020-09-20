package DataStructures.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

// DS book problem 30
public class ZigZagTreeTraversal 
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
		ZigZagTraversal(root);
		s.close();
	}

	private static void ZigZagTraversal(TreeNode root)
	{
		if(root == null)
		{
			return;
		}
		int direction = 0; // 0 means left to right & 1 means right to left
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		queue.add(new TreeNode(Integer.MIN_VALUE));
		TreeNode temp = root;
		while(!queue.isEmpty())
		{
			if(direction == 0)
			{
				direction = 1;
				while(queue.peekFirst().data != Integer.MIN_VALUE)
				{
					temp = queue.pollFirst();
					System.out.print(temp.data+" ");
					if(temp.left!=null)
					{
						queue.add(temp.left);
					}
					if(temp.right!=null)
					{
						queue.add(temp.right);
					}
				}
				queue.pollFirst();
				queue.add(new TreeNode(Integer.MIN_VALUE));
			}
			else
			{
				direction = 0;
				Stack<TreeNode> stack = new Stack<>();
				while(queue.peekFirst().data != Integer.MIN_VALUE)
				{
					temp = queue.pollFirst();
					stack.add(temp);
					if(temp.left!=null)
					{
						queue.add(temp.left);
					}
					if(temp.right!=null)
					{
						queue.add(temp.right);
					}
				}
				queue.pollFirst();
				queue.add(new TreeNode(Integer.MIN_VALUE));
				while(!stack.isEmpty())
				{
					System.out.print(stack.pop().data+" ");
				}
			}
		}
		System.out.println();
	}
}
