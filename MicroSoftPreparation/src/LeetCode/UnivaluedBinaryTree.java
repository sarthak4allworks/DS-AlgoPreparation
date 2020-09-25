package LeetCode;

import DataStructures.Tree.TreeNode;

// https://leetcode.com/problems/univalued-binary-tree/
public class UnivaluedBinaryTree 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(1);
		System.out.println(isUnivalTree(root));
	}
	private static boolean isUnivalTree(TreeNode root)
	{
		if(root == null) return true;
		else return dfs(root, root.data);
	}
	private static boolean dfs(TreeNode root, int data) 
	{
		if(root == null) return true;
		if(root.data != data) return false;
		return dfs(root.left, data) && dfs(root.right, data);
	}
}
