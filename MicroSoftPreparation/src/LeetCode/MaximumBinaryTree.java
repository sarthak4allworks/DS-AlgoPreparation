package LeetCode;

import java.util.Scanner;
import DataStructures.Tree.BasicADTOfBinaryTree;
import DataStructures.Tree.TreeNode;

//https://leetcode.com/problems/maximum-binary-tree/

public class MaximumBinaryTree 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] nums = new int[n];
		for(int i=0 ; i<n ; i++)
		{
			nums[i] = s.nextInt();
		}
		TreeNode root = constructMaximumBinaryTree(nums);
		BasicADTOfBinaryTree.printLevelOrderRecursive(root);
		s.close();
	}

	private static TreeNode constructMaximumBinaryTree(int[] nums) 
	{
		return constructMaximumBinaryTree(nums, 0, nums.length-1);
	}

	private static TreeNode constructMaximumBinaryTree(int[] nums, int i, int j) 
	{
		TreeNode root = null;
		if(i > j)
		{
			return null;
		}
		int maxIndex = FindMaxValueIndex(nums, i, j);
		root = new TreeNode(nums[maxIndex]);
		root.left = constructMaximumBinaryTree(nums, i, maxIndex-1);
		root.right = constructMaximumBinaryTree(nums, maxIndex+1, j);
		return root;
	}

	private static int FindMaxValueIndex(int[] nums, int l, int r) 
	{
		int index = l;
		for(int i=l+1 ; i<=r ; i++)
		{
			if(nums[index] < nums[i])
			{
				index = i;
			}
		}
		return index;
	}
}
