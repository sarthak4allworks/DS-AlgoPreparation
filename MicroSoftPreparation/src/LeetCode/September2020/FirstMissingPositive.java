package LeetCode.September2020;

import java.util.Scanner;

//https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/558/week-5-september-29th-september-30th/3478/
public class FirstMissingPositive 
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
			System.out.println(firstMissingPositive(nums));
		}
		s.close();
	}

	private static int firstMissingPositive(int[] nums) 
	{
		// Space Complexity O(n)
		/*
		Set<Integer> set = new HashSet<>();
		for(int num: nums)
		{
			set.add(num);
		}
		for(int i=1 ; i<=nums.length ; i++)
		{
			if(!set.contains(i))
			{
				return i;
			}
		}
		return nums.length+1;
		*/
		// Space Complexity O(1)
		boolean onePresent = false;
		for(int num: nums)
		{
			if(num == 1)
			{
				onePresent = true;
				break;
			}
		}
		if(!onePresent)
		{
			return 1;
		}
		int len = nums.length;
		for(int i=0 ; i<len ; i++)
		{
			if(nums[i] <= 0 || nums[i] > len)
			{
				nums[i] = 1;
			}
		}
		for(int i=0 ; i<len ; i++)
		{
			int index = Math.abs(nums[i]);
			if(index < len)
			{
				nums[index] = -1 * Math.abs(nums[index]);
			}
			else
			{
				nums[0] = -1 * Math.abs(nums[0]);
			}
		}
		for(int i=1 ; i<len ; i++)
		{
			if(nums[i]>0)
			{
				return i;
			}
		}
		if(nums[0] > 0) return len;
		return len+1;
	}
}
