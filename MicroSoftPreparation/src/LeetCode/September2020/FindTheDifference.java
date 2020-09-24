package LeetCode.September2020;

import java.util.Arrays;
import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3471/
public class FindTheDifference
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			String str1 = s.next();
			String str2 = s.next();
			System.out.println(findTheDifference(str1, str2));
		}
		s.close();
	}

	private static char findTheDifference(String str1, String str2)
	{
		char[] a = str1.toCharArray();
		Arrays.sort(a);
		char[] b = str2.toCharArray();
		Arrays.sort(b);
		for(int i=0 ; i<a.length ; i++)
		{
			if(a[i] != b[i])
			{
				return b[i];
			}
		}
		return b[a.length];
	}
}
