package LeetCode;

import java.util.Scanner;

// https://leetcode.com/problems/zigzag-conversion/
public class ZigZagConversion
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			String str = s.next();
			int numRows = s.nextInt();
			System.out.println(convert(str, numRows));
		}
		s.close();
	}

	private static String convert(String str, int numRows)
	{
		if(str == null || numRows == 0)
		{
			return null;
		}
		if(str.length() == 1 || numRows == 1)
		{
			return str;
		}
		StringBuilder[] a = new StringBuilder[numRows];
		for(int i=0 ; i<numRows ; i++)
		{
			a[i] = new StringBuilder("");
		}
		boolean dir = true;
		int row = 0;
		for(int i=0 ; i<str.length() ; i++)
		{
			a[row].append(str.charAt(i));
			if(dir)
			{
				row++;
			}
			else
			{
				row--;
			}
			if(row>=numRows) // 3
			{
				row-=2;
				dir = false;
			}
			if(row<0)
			{
				row+=2;
				dir = true;
			}
		}
		StringBuilder res = new StringBuilder("");
		for(StringBuilder sb: a)
		{
			res.append(sb);
		}
		return res.toString();
	}
}
