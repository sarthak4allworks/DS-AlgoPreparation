package LeetCode.September2020;

import java.util.Scanner;

//https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3459/
public class HouseRobber 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
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
			System.out.println(rob(a));
		}
		s.close();
	}

	private static int rob(int[] a) 
	{
		int len = a.length;
		if(len == 0)
		{
			return 0;
		}
		else if(len == 1)
		{
			return a[0];
		}
		else if(len == 2)
		{
			return a[0]>a[1] ? a[0] : a[1];
		}
		int[] house = new int[len];
		for(int i=0 ; i<len ; i++)
		{
			house[i] = 0;
		}
		house[0] = a[0];
		house[1] = Math.max(a[0], a[1]);
		for(int i=2 ; i<len ; i++)
		{
			house[i] = Math.max(a[i] + house[i - 2], house[i - 1]);;
		}
		return house[len-1];
	}
}
