package LeetCode.September2020;

import java.util.Scanner;

//https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3461/
public class LengthOfLastWord 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			s.nextLine();
			String str = s.nextLine();
			System.out.println(lengthOfLastWord(str));
		}
		s.close();
	}

	private static int lengthOfLastWord(String str) 
	{
		str = str.trim();
		int count = 0;
		for(int i=str.length()-1 ; i>=0 ; i--)
		{
			if(str.charAt(i) == ' ')
			{
				break;
			}
			else
			{
				count++;
			}
		}
		return count;
	}
}
