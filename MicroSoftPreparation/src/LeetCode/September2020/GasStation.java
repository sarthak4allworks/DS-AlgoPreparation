package LeetCode.September2020;

import java.util.Scanner;

//https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3470/
public class GasStation 
{
	public static void main(String[] args) 
	{
		System.out.println("Start..");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[] gas = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				gas[i] = s.nextInt();
			}
			int[] cost = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				cost[i] = s.nextInt();
			}
			System.out.println(canCompleteCircuit(gas, cost));
		}
		s.close();
	}

	private static int canCompleteCircuit(int[] gas, int[] cost)
	{
		int len = gas.length;
		int startPosition = -1;
		for(int i=0 ; i<len ; i++)
		{
			startPosition = i;
			int count = 0;
			int rgas = 0;
			while(count<len)
			{
				rgas+=gas[startPosition];
				if(rgas < cost[startPosition])
				{
					break;
				}
				else
				{
					rgas -= cost[startPosition];
					startPosition = (startPosition+1)%len;
					count++;
				}
			}
			if(count == len)
			{
				break;
			}
			if(count != len)
			{
				startPosition = -1;
			}
		}
		return startPosition;
	}
}
