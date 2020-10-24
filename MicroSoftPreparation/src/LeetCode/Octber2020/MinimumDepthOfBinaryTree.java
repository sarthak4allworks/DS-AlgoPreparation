package LeetCode.Octber2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3504/
public class MinimumDepthOfBinaryTree 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			TreeNode root = new TreeNode(2);
//			root.left = new TreeNode(9);
			root.right = new TreeNode(3);
			root.right.right = new TreeNode(4);
			root.right.right.right = new TreeNode(5);
			root.right.right.right.right = new TreeNode(6);
			System.out.println(minDepth(root));
		}
		s.close();
	}

	private static int minDepth(TreeNode root) 
	{
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		if(root.left == null) return minDepth(root.right)+1;
		if(root.right == null) return minDepth(root.left)+1;
		return Math.min(minDepth(root.left), minDepth(root.right))+1;
	}
}
