package LeetCode.Octber2020;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
		// Solution 1
//		if(k == 0)
//		{
//			Arrays.sort(nums);
//			for(int i=0 ; i<nums.length-1 ;)
//			{
//				if(nums[i] == nums[i+1])
//				{
//					count++;
//				}
//				while((i+1) < nums.length && nums[i] == nums[i+1])
//				{
//					i++;
//				}
//				i++;
//			}
//		}
//		else
//		{
//			TreeSet<Integer> set = new TreeSet<>();
//			for(int num: nums)
//			{
//				set.add(num);
//			}
//			for(int num: set)
//			{
//				if(set.contains(num+k))
//				{
//					count++;
//				}
//			}
//		}
		
		// Solution-2
		Map<Integer, Integer> map = new HashMap<>();
		for(int num: nums)
		{
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		for(int key: map.keySet())
		{
			if(k == 0)
			{
				if(map.get(key) > 1)
				{
					count++;
				}
			}
			else
			{
				if(map.containsKey(key+k))
				{
					count++;
				}
			}
		}
		return count;
	}
}
