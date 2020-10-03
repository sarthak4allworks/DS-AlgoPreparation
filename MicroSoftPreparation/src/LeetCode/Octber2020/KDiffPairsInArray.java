package LeetCode.Octber2020;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3482/
public class KDiffPairsInArray 
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
			System.out.println(findPairs(nums, k));
		}
		s.close();
	}

	private static int findPairs(int[] nums, int k)
	{
		int count = 0;
		if(k == 0)
		{
			Arrays.sort(nums);
			for(int i=0 ; i<nums.length-1 ;)
			{
				if(nums[i] == nums[i+1])
				{
					count++;
				}
				while((i+1) < nums.length && nums[i] == nums[i+1])
				{
					i++;
				}
				i++;
			}
		}
		else
		{
			TreeSet<Integer> set = new TreeSet<>();
			for(int num: nums)
			{
				set.add(num);
			}
			for(int num: set)
			{
				if(set.contains(num+k))
				{
					count++;
				}
			}
		}
		return count;
	}
}
