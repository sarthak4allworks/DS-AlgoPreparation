package LeetCode.Octber2020;

import java.util.Arrays;
import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3492/
public class BuddyStrings
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			String A = s.next();
			String B = s.next();
			System.out.println(buddyStrings(A, B));
		}
		s.close();
	}

	private static boolean buddyStrings(String A, String B)
	{
		if(A.length() != B.length() || A.length() == 1) return false;
		boolean flag = true;
		for(int i=0 ; i<A.length() ; i++)
		{
			if(A.charAt(i) != B.charAt(i))
			{
				flag = false;
				break;
			}
		}
		if(flag)
		{
			flag = false;
			int[] arr = new int[26];
			for(int i=0 ; i<26 ; i++) arr[i] = 0;
			for(int i=0 ; i<A.length() ; i++)
			{
				arr[A.charAt(i)-'a']++;
			}
			Arrays.sort(arr);
			flag = arr[25] >= 2;
			return flag;
		}
		else
		{
			int index1 = -1;
			int index2 = -1;
			int count = 0;
			for(int i=0 ; i<A.length() ; i++)
			{
				if(A.charAt(i) != B.charAt(i))
				{
					if(count == 0)
					{
						index1 = i;
						count++;
					}
					else if(count == 1)
					{
						index2 = i;
						count++;
					}
					else
					{
						count++;
						break;
					}
				}
			}
			if(count!=2) return false;
			if(A.charAt(index1) == B.charAt(index2) && A.charAt(index2) == B.charAt(index1)) return true;
			else return false;
		}
	}
}
