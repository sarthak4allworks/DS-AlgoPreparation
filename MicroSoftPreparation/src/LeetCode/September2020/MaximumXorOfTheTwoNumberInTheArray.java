package LeetCode.September2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3462/
public class MaximumXorOfTheTwoNumberInTheArray
{	
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		MaximumXorOfTheTwoNumberInTheArray classObj = new MaximumXorOfTheTwoNumberInTheArray();
		while(t-->0)
		{
			int n = s.nextInt();
			int[] nums = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				nums[i] = s.nextInt();
			}
			System.out.println(classObj.findMaximumXOR(nums));
		}
		s.close();
	}
	
	class BinaryTrie
	{
		int data;
		BinaryTrie left;
		BinaryTrie right;
		BinaryTrie(){}
		BinaryTrie(int data)
		{
			this.data= data;
		}
	}

	private int findMaximumXOR(int[] nums)
	{
		/* This is the brute force approch taking O(n^2) time
			int len = nums.length;
			if(len == 0 || len == 1)
			{
				return 0;
			}
			else
			{
				int max = 0;
				for(int i=0 ; i<len-1 ; i++)
				{
					for(int j=i+1 ; j<len ; j++)
					{
						max = (nums[i]^nums[j]) > max ? nums[i]^nums[j] : max;
					}
				}
				return max;
			}
		*/
		
		BinaryTrie root = BuildTrie(nums);
		int len = nums.length;
		int max = 0;
		for(int i=0 ; i<len ; i++)
		{
			int num = nums[i];
			BinaryTrie temp = root;
			int currResult = 0;
			for(int j=31; j>=0 ; j--)
			{
				int bit = (num & (1 << j));
				int checkside = bit>0?0:1;
				if(checkside == 0)
				{
					if(temp.left == null)
					{
						temp = temp.right;
					}
					else
					{
						temp = temp.left;
						currResult+= 1<<j;
					}
				}
				else
				{
					if(temp.right == null)
					{
						temp = temp.left;
					}
					else
					{
						temp = temp.right;
						currResult+= 1<<j;
					}
				}
			}
			max = Math.max(currResult, max);
			if(max == Integer.MAX_VALUE) break;
		}
		return max;
	}

	private BinaryTrie BuildTrie(int[] nums)
	{
		BinaryTrie root = new BinaryTrie();
		int len = nums.length;
		for(int i=0 ; i<len ; i++)
		{
			BinaryTrie temp = root;
			int num = nums[i];
			for(int j=31 ; j>=0 ; j--)
			{
				int bit = (num & (1 << j));
				if(bit == 0)
				{
					if(temp.left == null)
					{
						temp.left = new BinaryTrie(0);
					}
					temp = temp.left;
				}
				else
				{
					if(temp.right == null)
					{
						temp.right = new BinaryTrie(1);
					}
					temp = temp.right;
				}
			}
		}
		return root;
	}
}
