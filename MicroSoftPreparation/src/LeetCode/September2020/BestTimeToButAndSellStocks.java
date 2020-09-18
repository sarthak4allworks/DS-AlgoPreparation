package LeetCode.September2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3464/
public class BestTimeToButAndSellStocks
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[] prices = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				prices[i] = s.nextInt();
			}
			System.out.println(maxProfit(prices));
		}
		s.close();
	}

	private static int maxProfit(int[] prices) 
	{
		int len = prices.length;
		if(len == 0 || len == 1)
		{
			return 0;
		}
		int maxProfit = 0;
		int buyPrice = prices[0];
		int p;
		for(int i=1 ; i<len ; i++)
		{
			p = prices[i] - buyPrice;
			if(p < 0 && prices[i] < buyPrice)
			{
				buyPrice = prices[i];
			}
			else
			{
				maxProfit = maxProfit > p ? maxProfit : p;
			}
		}
		return maxProfit;
	}
}
