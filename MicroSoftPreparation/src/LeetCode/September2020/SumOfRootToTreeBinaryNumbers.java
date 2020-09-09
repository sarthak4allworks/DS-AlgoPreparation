package LeetCode.September2020;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

class TreeNode 
{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() 
	{
	}
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


public class SumOfRootToTreeBinaryNumbers 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) 
		{
			TreeNode root = new TreeNode(1);
			root.left = new TreeNode(0);
			root.right = new TreeNode(1);
			root.left.left = new TreeNode(0);
			root.left.right = new TreeNode(1);
			root.right.left = new TreeNode(0);
			root.right.right = new TreeNode(1);
			System.out.println(sumRootToLeaf(root));
		}
		s.close();
	}

	private static int sumRootToLeaf(TreeNode root) 
	{
		int sum = 0;
		Deque<TreeNode> stack = new ArrayDeque<>();
		Map<TreeNode, TreeNode> map = new HashMap<>();
		stack.add(root);
		map.put(root, null);
		while(!stack.isEmpty())
		{
			TreeNode current = stack.pollLast();
			if(isLeaf(current))
			{
				sum += getSumOfTisBranch(current, map);
			}
			if(current.right != null)
			{
				stack.add(current.right);
				map.put(current.right, current);
			}
			if(current.left != null)
			{
				stack.add(current.left);
				map.put(current.left, current);
			}
		}
		return sum;
	}

	private static int getSumOfTisBranch(TreeNode current, Map<TreeNode, TreeNode> map)
	{
		StringBuilder sb = new StringBuilder("");
		while(map.get(current) != null)
		{
			sb.append(current.val);
			current = map.get(current);
		}
		sb.append(current.val);
		String str = sb.reverse().toString();
		return Integer.parseInt(str, 2);
	}

	private static boolean isLeaf(TreeNode current) 
	{
		return current.left == null && current.right == null;
	}
}
