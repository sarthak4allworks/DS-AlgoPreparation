package LeetCode.Octber2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3488/
public class BinarySearch
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
			int target = s.nextInt();
			System.out.println(search(nums, target));
		}
		s.close();
	}

	private static int search(int[] nums, int target)
	{
		int index = -1;
		int high = nums.length-1;
		int low = 0;
		while(low <= high)
		{
			int mid = (high+low)/2;
			if(target == nums[mid])
			{
				index = mid;
				break;
			}
			else if(target < nums[mid])
			{
				high = mid-1;
			}
			else
			{
				low = mid+1;
			}
		}
		return index;
	}
}
