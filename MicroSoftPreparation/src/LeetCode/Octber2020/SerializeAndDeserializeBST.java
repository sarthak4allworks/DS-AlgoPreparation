package LeetCode.Octber2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3489/

public class SerializeAndDeserializeBST 
{
	static int preIndex;
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			TreeNode root = null;
			preIndex = 0;
			int n = s.nextInt();
			while(n-->0)
			{
				root = InsertIntoBinarySearchTree.insertIntoBST(root, s.nextInt());
			}
			InsertIntoBinarySearchTree.PrintInorderTree(root);
			System.out.println();
			String data = serialize(root);
			System.out.println("Serialize string is: "+data);
			root = deserialize(data);
			InsertIntoBinarySearchTree.PrintInorderTree(root);
			System.out.println();
		}
		s.close();
	}
	
	private static TreeNode deserialize(String data) 
	{
		if(data.isEmpty()) return null;
		char[] arr = data.toCharArray();
		Arrays.sort(arr);
		String inStr = String.valueOf(arr);
		TreeNode root = BuildTreeWrap(inStr, data);
		return root;
	}

	private static TreeNode BuildTreeWrap(String inStr, String preStr) 
	{
		TreeNode root = null;
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0 ; i<inStr.length() ; i++)
		{
			map.put(inStr.charAt(i), i);
		}
		root = buildTree(map, 0, inStr.length()-1, inStr, preStr);
		return root;
	}

	private static TreeNode buildTree(Map<Character, Integer> map, int start, int end, String inStr, String preStr) 
	{
		if(start > end)
		{
			return null;
		}
		char ch = preStr.charAt(preIndex++);
		TreeNode root = new TreeNode(ch-'0');
		if(start == end)
		{
			return root;
		}
		root.left = buildTree(map, start, map.get(ch)-1, inStr, preStr);
		root.right = buildTree(map, map.get(ch)+1, end, inStr, preStr);
		return root;
	}

	// Return Preorder String as serialization
	private static String serialize(TreeNode root)
	{
		StringBuilder preStr = new StringBuilder("");
		PreOrderString(root, preStr);
		return preStr.toString().trim();
	}
	
	private static void PreOrderString(TreeNode root, StringBuilder preStr)
	{
		if(root != null)
		{
			preStr.append(String.valueOf(root.val));
			PreOrderString(root.left, preStr);
			PreOrderString(root.right, preStr);
		}
	}
}
