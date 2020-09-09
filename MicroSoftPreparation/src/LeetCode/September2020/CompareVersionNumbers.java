package LeetCode.September2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3454/
public class CompareVersionNumbers
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
			System.out.println(compareVersion(str1, str2));
		}
		s.close();
	}

	private static int compareVersion(String str1, String str2)
	{
		int num = 0;
		String[] a = str1.split("\\.");
		String[] b = str2.split("\\.");
		int lena = a.length;
		int lenb = b.length;
		int lenmax = lena>lenb ? lena : lenb;
		if(lenmax == lena && lenmax == lenb)
		{
			num = compareString(a, b);
		}
		else if(lenmax == lena)
		{
			String[] newb = new String[lena];
			for(int i=0 ; i<lena ; i++)
			{
				newb[i] = lenb>i ? b[i] : "0";
			}
			num = compareString(a, newb);
		}
		else
		{
			String[] newa = new String[lenb];
			for(int i=0 ; i<lenb ; i++)
			{
				newa[i] = lena>i ? a[i] : "0";
			}
			num = compareString(newa, b);
		}
		return num;
	}

	private static int compareString(String[] a, String[] b)
	{
		int num = 0;
//		for(String i: a)
//		{
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		for(String i: b)
//		{
//			System.out.print(i+" ");
//		}
//		System.out.println();
		for(int i=0 ; i<a.length ; i++)
		{
			if(Integer.parseInt(a[i]) > Integer.parseInt(b[i]))
			{
				num = 1;
				break;
			}
			else if(Integer.parseInt(a[i]) < Integer.parseInt(b[i]))
			{
				num = -1;
				break;
			}
			else
			{
				num = 0;
			}
		}
		return num;
	}
}
