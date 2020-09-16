package DataStructures.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// DS book Problem 18

class BinaryTreeForFindingDia
{
	int data;
	BinaryTreeForFindingDia left;
	BinaryTreeForFindingDia right;
	int lDia;
	int rDia;
	BinaryTreeForFindingDia(){}
	BinaryTreeForFindingDia(int data)
	{
		this.data = data;
	}
}

public class FindDiaMeterOfBinaryTreeWithExtraSpace 
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		System.out.print("Insert number of nodes in a tree: ");
		int noOfNodes = s.nextInt();
		BinaryTreeForFindingDia root = null;
		for(int i=0 ; i<noOfNodes ; i++)
		{
			root = InsertInBinaryTree(root, s.nextInt());
		}
		printLevelOrderRecursive(root);
		System.out.println();
		System.out.println(findDia(root));
		s.close();
	}
	
	public static int findDia(BinaryTreeForFindingDia root)
	{
		int dia = 0;
		if(root == null)
		{
			return 0;
		}
		if(root.left == null)
		{
			root.lDia = 0;
		}
		if(root.right == null)
		{
			root.rDia = 0;
		}
		if(root.left != null)
		{
			findDia(root.left);
		}
		if(root.right != null)
		{
			findDia(root.right);
		}
		if(root.left != null)
		{
			int lMaxLen = 0;
			lMaxLen = root.left.lDia>root.left.rDia ? root.left.lDia : root.left.rDia;
			root.lDia = lMaxLen+1;
		}
		if(root.right != null)
		{
			int rMaxLen = 0;
			rMaxLen = root.right.lDia>root.right.rDia ? root.right.lDia : root.right.rDia;
			root.rDia = rMaxLen+1;
		}
		if(root.lDia+root.rDia > dia)
		{
			dia = root.lDia+root.rDia;
		}
		return dia;
	}

	public static void printLevelOrderRecursive(BinaryTreeForFindingDia root) 
	{
		if(root != null)
		{
			Deque<BinaryTreeForFindingDia> queue = new ArrayDeque<>();
			queue.add(root);
			BinaryTreeForFindingDia temp = root;
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
	
	public static BinaryTreeForFindingDia InsertInBinaryTree(BinaryTreeForFindingDia root, int nextInt) 
	{
		if(root == null)
		{
			root = new BinaryTreeForFindingDia(nextInt);
		}
		else
		{
			Deque<BinaryTreeForFindingDia> queue = new ArrayDeque<>();
			queue.add(root);
			BinaryTreeForFindingDia temp = null, newNode = null;
			while(!queue.isEmpty())
			{
				newNode = new BinaryTreeForFindingDia(nextInt);
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
