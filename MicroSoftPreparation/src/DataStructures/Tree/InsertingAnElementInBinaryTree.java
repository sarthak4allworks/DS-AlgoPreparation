package DataStructures.Tree;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// DS book problem 5

public class InsertingAnElementInBinaryTree 
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		TreeNode root= null;
		// n contains the number of nodes in a tree
		System.out.print("Please enter the number of node: ");
		int n = s.nextInt();
		for(int i=0 ; i<n ; i++)
		{
			root = InsertInBinaryTree(root, s.nextInt());
		}
		System.out.println("After inserting all the elements in tree the level order traversal is: ");
		BasicADTOfBinaryTree.printLevelOrderRecursive(root);
		s.close();
	}

	public static TreeNode InsertInBinaryTree(TreeNode root, int nextInt) 
	{
		if(root == null)
		{
			root = new TreeNode(nextInt);
		}
		else
		{
			Deque<TreeNode> queue = new ArrayDeque<>();
			queue.add(root);
			TreeNode temp = null, newNode = null;
			while(!queue.isEmpty())
			{
				newNode = new TreeNode(nextInt);
				temp = queue.pollFirst();
				if(temp.left == null)
				{
					temp.left = newNode;
					break;
				}
				if(temp.right == null)
				{
					temp.right = newNode;
					break;
				}
				if(temp.left != null)
				{
					queue.add(temp.left);
				}
				if(temp.right!=null)
				{
					queue.add(temp.right);
				}
			}
		}
		return root;
	}
}
