package LeetCode.September2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3473/
public class TeemoAttacking 
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[] timeSeries = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				timeSeries[i] = s.nextInt();
			}
			int duration = s.nextInt();
			System.out.println(findPoisonedDuration(timeSeries, duration));
		}
		s.close();
	}

	private static int findPoisonedDuration(int[] timeSeries, int duration)
	{
		int totalTime = 0;
		int len = timeSeries.length;
		if(len>0)
		{
			totalTime = duration;
			int nextBegin = timeSeries[0]+duration;
			for(int i=1 ; i<len ; i++)
			{
				if(timeSeries[i] >= nextBegin)
				{
					totalTime += duration;
					nextBegin = timeSeries[i]+duration;
				}
				else
				{
					totalTime+=timeSeries[i]-timeSeries[i-1];
					nextBegin = timeSeries[i]+duration;
				}
			}
		}
		return totalTime;
	}
}
