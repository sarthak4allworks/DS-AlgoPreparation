package DataStructures.Tree;

import java.util.Scanner;

// DS book problem 33
class Index
{
	int index;
}

public class BuildTreeWithPreOrderTraversalOfIL  // internal node(I) will denote with 1 and leaf (L) will denote with 0
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			System.out.print("Enter the preorder of the tree: ");
			String preOrderTraversal = s.next();
			Index index_ptr = new Index();
			TreeNode root = BuildTreeFromPreorder(preOrderTraversal, index_ptr);
			System.out.print("Level order traversal of the build tree is: ");
			BasicADTOfBinaryTree.printLevelOrderRecursive(root);
			System.out.println();
		}
		s.close();
	}

	private static TreeNode BuildTreeFromPreorder(String preOrderTraversal, Index index_ptr)
	{
		if(index_ptr.index == preOrderTraversal.length())
		{
			return null;
		}
		TreeNode temp = new TreeNode(preOrderTraversal.charAt(index_ptr.index)-'0');
		index_ptr.index++;
		if(temp.data == 1)
		{
			temp.left = BuildTreeFromPreorder(preOrderTraversal, index_ptr);
			temp.right = BuildTreeFromPreorder(preOrderTraversal, index_ptr);
		}
		return temp;
	}
}
