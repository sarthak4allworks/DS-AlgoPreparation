package LeetCode;

import java.util.Scanner;

// https://leetcode.com/problems/maximum-subarray/
public class MaximumSubArray 
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
			System.out.println(maxSubArray(nums));
		}
		s.close();
	}

	private static int maxSubArray(int[] nums) 
	{
		int max_so_far=Integer.MIN_VALUE, max_end_here = 0;
		for(int i=0 ; i< nums.length ; i++)
		{
			max_end_here += nums[i];
			if(max_end_here > max_so_far)
			{
				max_so_far = max_end_here;
			}
			if(max_end_here < 0)
			{
				max_end_here = 0;
			}
		}
		return max_so_far;
	}
}
