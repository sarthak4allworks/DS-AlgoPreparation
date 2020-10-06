package LeetCode.Octber2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3484/
public class ComplementOfBase10Integer 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int N = s.nextInt();
			System.out.println(bitwiseComplement(N));
		}
		s.close();
	}

	private static int bitwiseComplement(int n)
	{
		char[] binaryString = Integer.toBinaryString(n).toCharArray();
		StringBuilder str = new StringBuilder("");
		for(char ch: binaryString)
		{
			if(ch == '1')
			{
				str.append("0");
			}
			else
			{
				str.append("1");
			}
		}
		return Integer.valueOf(str.toString(), 2);
	}
}
