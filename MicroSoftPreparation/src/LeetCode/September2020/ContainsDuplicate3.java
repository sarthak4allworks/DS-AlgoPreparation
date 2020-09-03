package LeetCode.September2020;

import java.util.Scanner;

//https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3446/
public class ContainsDuplicate3 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		//System.out.println(Math.abs(-1+ 2));
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[] a = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				a[i] = s.nextInt();
			}
			int k = s.nextInt();
			int indd = s.nextInt();
			System.out.println(containsNearbyAlmostDuplicate(a, k, indd));
		}
		s.close();
	}

	private static boolean containsNearbyAlmostDuplicate(int[] a, int k, int indd)
	{
		boolean flag = false;
		int len = a.length;
		for(int i=0 ; i<len-1; i++)
		{
			for(int j=i+1 ; j<len && j<=(i+k) ; j++)
			{
				long num1 = a[i];
				long num2 = a[j];
//				System.out.println(Math.abs(num1-num2));
				if(Math.abs(num1-num2) <= indd)
				{
					flag = true;
					break;
				}			
			}
			if(flag) break;
		}
		return flag;
	}

}
