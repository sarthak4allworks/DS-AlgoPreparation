package LeetCode.Octber2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3496/
public class RotateArray
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[] nums = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				nums[i] = s.nextInt();
			}
			int k = s.nextInt();
			rotate(nums, k);
			for(int num: nums)
			{
				System.out.print(num+" ");
			}
			System.out.println();
		}
		s.close();
	}

	private static void rotate(int[] nums, int k) 
	{
		k = k%nums.length;
		if(k != 0)
		{
			ReverseArray(nums, 0, nums.length-1);
			ReverseArray(nums, 0, k-1);
			ReverseArray(nums, k, nums.length-1);
		}
	}

	private static void ReverseArray(int[] nums, int start, int end)
	{
		while(start < end)
		{
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}
	}
}
