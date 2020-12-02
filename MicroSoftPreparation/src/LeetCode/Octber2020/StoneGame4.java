package LeetCode.Octber2020;

import java.util.Arrays;
import java.util.Scanner;

//https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3507/
public class StoneGame4 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			System.out.println(winnerSquareGame(n));
		}
		s.close();
	}

	static int[] dp = new int[10001];
	private static boolean winnerSquareGame(int n)
	{
		Arrays.fill(dp, -1);
		return helper(n) == 1 ? true : false;
	}
	
	private static int helper(int n)
	{
		if(n<=0) return 0;
		if(dp[n] != -1) return dp[n];
		for(int i=1 ; i*i<=n ; i++)
		{
			if(helper(n-i*i) == 0) return dp[n] = 1;
		}
		return dp[n] = 0;
	}
}
