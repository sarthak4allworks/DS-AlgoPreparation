package DataStructures.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class TreeNode
{
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int data)
	{
		this.data = data;
	}
	TreeNode(int data, TreeNode left, TreeNode right)
	{
		this.data = data;
		this.left = left;
		this.right= right;
	}
}

public class BasicADTOfBinaryTree 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left =  new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.print("Preorder Recursive => ");
		printPreOrderRecursive(root);
		System.out.println();
		System.out.print("Postorder Recursive => ");
		printPostOrderRecursive(root);
		System.out.println();
		System.out.print("Inorder Recursive => ");
		printInorderRecursive(root);
		System.out.println();
		System.out.print("Levelorder Recursive => ");
		printLevelOrderRecursive(root);
		System.out.println();
		System.out.print("Preorder Iterative => ");
		printPreOrderIterative(root);
		System.out.println();
		System.out.print("Postorder Iterative => ");
		printPostOrderIterative(root);
		System.out.println();
		System.out.print("Inorder Iterative => ");
		printInOrderIterative(root);
	}

	private static void printInOrderIterative(TreeNode root) // 4 2 5 1 6 3 7
	{
		if(root!=null)
		{
			Stack<TreeNode> stack = new Stack<>();
			while(true)
			{
				while(root != null)
				{
					stack.push(root);
					root = root.left;
				}
				if(stack.isEmpty())
				{
					break;
				}
				root = stack.pop();
				System.out.print(root.data+" ");
				root = root.right;
			}
		}
	}

	private static void printPostOrderIterative(TreeNode root) // 4 5 2 6 7 3 1
	{
		if(root != null)
		{
			TreeNode prev = null;
			Stack<TreeNode> stack = new Stack<>();
			do
			{
				while(root != null)
				{
					stack.push(root);
					root = root.left;
				}
				while(root== null && !stack.isEmpty())
				{
					root = stack.peek();
					if(root.right == null || root.right == prev)
					{
						root = stack.pop();
						System.out.print(root.data+" ");
						prev = root;
						root = null;
					}
					else
					{
						root = root.right;
					}
				}
			}while(!stack.isEmpty());
		}
	}

	private static void printPreOrderIterative(TreeNode root) // 1 2 4 5 3 4 7 
	{
		if(root!=null)
		{
			Stack<TreeNode> stack = new Stack<>();
			while(true)
			{
				while(root != null)
				{
					System.out.print(root.data+" ");
					stack.push(root);
					root = root.left;
				}
				if(stack.isEmpty())
				{
					break;
				}
				root = stack.pop();
				root = root.right;
			}
		}
	}

	private static void printLevelOrderRecursive(TreeNode root) //1 2 3 4 5 6 7
	{
		if(root != null)
		{
			Deque<TreeNode> queue = new ArrayDeque<>();
			queue.add(root);
			TreeNode temp = root;
			while(!queue.isEmpty())
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
		}
	}

	private static void printInorderRecursive(TreeNode root) // 4 2 5 1 6 3 7
	{
		if(root != null)
		{
			printInorderRecursive(root.left);
			System.out.print(root.data+" ");
			printInorderRecursive(root.right);
		}
	}

	private static void printPostOrderRecursive(TreeNode root) // 4 5 2 6 7 3 1
	{
		if(root != null)
		{
			printPostOrderRecursive(root.left);
			printPostOrderRecursive(root.right);
			System.out.print(root.data+" ");
		}
	} 

	private static void printPreOrderRecursive(TreeNode root) // 1 2 4 5 3 6 7  
	{
		if(root != null)
		{
			System.out.print(root.data+" ");
			printPreOrderRecursive(root.left);
			printPreOrderRecursive(root.right);
		}
	}
}
