package LeetCode.Octber2020;

import java.util.Arrays;
import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3494/
public class HouseRobber11
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
			System.out.println(rob(nums));
		}
		s.close();
	}

	private static int rob(int[] nums)
	{
		if(nums.length == 1) return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]);
		return Math.max(Maximum(nums, 0, nums.length-2), Maximum(nums, 1, nums.length-1));
	}

	private static int Maximum(int[] temp, int start, int end) 
	{
		int[] nums = new int[temp.length];
		for(int i=0 ; i<temp.length ; i++)
		{
			nums[i] = temp[i];
		}
		if(nums[start+1] < nums[start])
		{
			nums[start+1] = nums[start];
		}
		for(int i=start+2 ; i<=end ; i++)
		{
			nums[i] = nums[i]+nums[i-2] > nums[i-1] ? nums[i]+nums[i-2] : nums[i-1];
		}
		return nums[end];
	}
}
