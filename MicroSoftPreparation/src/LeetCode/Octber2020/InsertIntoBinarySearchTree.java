package LeetCode.Octber2020;

import java.util.Scanner;

//https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3485/

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int val)
	{
		this.val = val;
	}
	TreeNode(int val, TreeNode left, TreeNode right)
	{
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class InsertIntoBinarySearchTree 
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			TreeNode root = null;
			int n = s.nextInt();
			for(int i=0 ; i<n ; i++)
			{
				root = insertIntoBST(root, s.nextInt());
			}
			int val = s.nextInt();
			root = insertIntoBST(root, val);
			PrintInorderTree(root);
			System.out.println();
		}
		s.close();
	}

	private static void PrintInorderTree(TreeNode root) 
	{
		if(root != null)
		{
			PrintInorderTree(root.left);
			System.out.print(root.val+" ");
			PrintInorderTree(root.right);
		}
	}

	private static TreeNode insertIntoBST(TreeNode root, int val)
	{
		if(root == null)
		{
			root = new TreeNode(val);
		}
		else if(root.val < val)
		{
			root.right = insertIntoBST(root.right, val);
		}
		else
		{
			root.left = insertIntoBST(root.left, val);
		}
		return root;
	}
}
