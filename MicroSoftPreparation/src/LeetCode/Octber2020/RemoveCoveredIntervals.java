package LeetCode.Octber2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3483/
public class RemoveCoveredIntervals 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[][] intervals = new int[n][2];
			for(int i=0 ; i<n ; i++)
			{
				intervals[i][0] = s.nextInt();
				intervals[i][1] = s.nextInt();
			}
			System.out.println(removeCoveredIntervals(intervals));
		}
		s.close();
	}

	private static int removeCoveredIntervals(int[][] intervals)
	{
		int uncoveredIntervals = 0;
		int len = intervals.length;
		boolean[] flag = new boolean[len];
		for(int i=0 ; i<len ; i++)
		{
			flag[i] = true;
		}
		for(int i=0 ; i<len ; i++)
		{
			for(int j=0 ; j<len ; j++)
			{
				if(i != j && flag[i] && flag[j])
				{
					if(intervals[j][0] >= intervals[i][0] && intervals[j][1] <= intervals[i][1])
					{
						flag[j] = false;
					}
					if(intervals[j][0] <= intervals[i][0] && intervals[j][1] >= intervals[i][1])
					{
						flag[i] = false;
					}
				}
			}
		}
		for(int i=0 ; i<len ; i++)
		{
			if(flag[i]) uncoveredIntervals++;
		}
		return uncoveredIntervals;
	}
}
