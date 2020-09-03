package LeetCode.September2020;

import java.util.Scanner;

//https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3447/
public class RepeatedSubstringPattern
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			String str = s.next();
			System.out.println(repeatedSubstringPattern(str));
		}
		s.close();
	}

	private static boolean repeatedSubstringPattern(String s) 
	{
		boolean flag = true;
		int len = s.length();
		if(len%2 !=0 && len == 1)
		{
			flag = false;
		}
		else if(len%2 == 0 && len == 2)
		{
			if(s.charAt(0)!=s.charAt(1))
			{
				flag = false;
			}
		}
//		else if(len%2 != 0)
//		{
//			for(int i=0 ; i<len-1 ; i++)
//			{
//				if(s.charAt(i) != s.charAt(i+1))
//				{
//					flag = false;
//					break;
//				}
//			}
//		}
		else
		{
			int countOfFirstIndexValue = 0;
			char firstChar = s.charAt(0);
			for(int i=len/2 ; i<len ; i++)
			{
				if(s.charAt(i) == firstChar)
				{
					countOfFirstIndexValue++;
				}
			}
			if(countOfFirstIndexValue == 0) return false;
			int[] indexOfFirstChar = new int[countOfFirstIndexValue];
			int index = 0;
			for(int i=len-1 ; i>=len/2 ; i--)
			{
				if(s.charAt(i) == firstChar)
				{
					indexOfFirstChar[index] = i;
					index++;
				}
			}
//			for(int i=0 ; i<countOfFirstIndexValue ; i++)
//			{
//				System.out.println("indexOfFirstChar["+i+"] = "+indexOfFirstChar[i]);
//			}
			for(int i=0 ; i<countOfFirstIndexValue ; i++)
			{
				flag = true;
				String subString = s.substring(indexOfFirstChar[i]);
//				System.out.println("Substring is "+subString);
				int lenghtOfSubstring = subString.length();
				if(len%lenghtOfSubstring == 0)
				{
//					System.out.println("Possibe");
					for(int j=0 ; j<indexOfFirstChar[i] ; j+=lenghtOfSubstring)
					{
						if(!subString.equals(s.substring(j, j+lenghtOfSubstring)))
						{
							flag = false;
							break;
						}
					}
					if(flag)
					{
						break;
					}
				}
				else
				{
//					System.out.println("Not possible");
					flag = false;
				}
			}
		}
		return flag;
	}
}
