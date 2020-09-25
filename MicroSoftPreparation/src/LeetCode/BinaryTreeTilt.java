package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

import DataStructures.Tree.TreeNode;

// https://leetcode.com/problems/binary-tree-tilt/
public class BinaryTreeTilt 
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
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		int sum = 0;
		while(!queue.isEmpty())
		{
			TreeNode temp = queue.pollFirst();
			sum += Math.abs(FindTreeSum(temp.left) - FindTreeSum(temp.right));
			if(temp.left != null)
			{
				queue.add(temp.left);
			}
			if(temp.right != null)
			{
				queue.add(temp.right);
			}
		}
		System.out.println(sum);
	}

	private static int FindTreeSum(TreeNode node)
	{
		int sum = 0;
		if(node == null)
		{
			return 0;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(node);
		while(!queue.isEmpty())
		{
			TreeNode temp = queue.pollFirst();
			sum += temp.data;
			if(temp.left != null)
			{
				queue.add(temp.left);
			}
			if(temp.right != null)
			{
				queue.add(temp.right);
			}
		}
		return sum;
	}
}
