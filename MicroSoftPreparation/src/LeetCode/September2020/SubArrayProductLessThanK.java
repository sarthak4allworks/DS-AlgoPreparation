package LeetCode.September2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3475/
public class SubArrayProductLessThanK 
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
			System.out.println(numSubarrayProductLessThanK(nums, k));
		}
		s.close();
	}

	private static int numSubarrayProductLessThanK(int[] nums, int k) 
	{
		int count = 0;
		// Exceed time limit
//		int len = nums.length;
//		long mul = 1;
//		for(int i=1 ; i<=len ; i++)
//		{
//			for(int j=0 ; j<=len-i ; j++)
//			{
////				System.out.println("j is "+ i);
//				mul = 1;
//				for(int l=j ; l<j+i ; l++)
//				{
//					mul*=nums[l];
//					if(mul>=k)
//					{
//						break;
//					}
//				}
//				if(mul<k)
//				{
//					count++;
//				}
//			}
//		}
		
		int len = nums.length;
		int p=1;
		for(int start=0, end=0 ; end<len ; end++)
		{
			p*=nums[end];
			while(start<end && p>= k)
			{
				p/=nums[start];
				start++;
			}
			if(p<k)
			{
				int counter = end-start+1;
				count+=counter;
			}
		}
		return count;
	}
}
