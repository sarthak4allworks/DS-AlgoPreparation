package LeetCode.Octber2020;

import java.util.Arrays;
import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3499/
public class BestTimeToBuySellStock4 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int k = s.nextInt();
			int n = s.nextInt();
			int[] prices = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				prices[i] = s.nextInt();
			}
			System.out.println(maxProfit(k, prices));
		}
		s.close();
	}

	private static int maxProfit(int k, int[] prices) 
	{
		if(k<=0 || prices.length == 1)
		{
			return 0;
		}
		else if(k >= prices.length/2)
		{
			int maxProfit = 0;
			for(int i=1 ; i<prices.length ; i++)
			{
				maxProfit += Math.max(0, prices[i] - prices[i-1]);
			}
			return maxProfit;
		}
		else
		{
			int[] buy = new int[k];
			Arrays.fill(buy, Integer.MIN_VALUE);
			int[] sell = new int[k];
			for(int i=0 ; i<prices.length ; i++)
			{
				for(int j=0 ; j<k ; j++)
				{
					buy[j] = Math.max(buy[j], j==0 ? 0-prices[i]: sell[j-1]-prices[i]);
					sell[j] = Math.max(sell[j], buy[j]+prices[i]);
				}
			}
			return sell[k-1];
		}
	}
}
