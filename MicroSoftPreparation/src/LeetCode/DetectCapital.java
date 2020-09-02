package LeetCode;

import java.util.Scanner;

//https://leetcode.com/explore/featured/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3409/
public class DetectCapital 
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			String word = s.next();
			System.out.println(IsCapital(word));
		}
		s.close();
	}

	private static boolean IsCapital(String word) 
	{
		boolean result = false;
		String wordS = word.toLowerCase();
		String wordC = word.toUpperCase();
		if(word.equals(wordC) || word.equals(wordS))
		{
			result = true;
		}
		else
		{
			if(Character.isUpperCase(word.charAt(0)))
			{
				String wordO = word.substring(1);
				wordS = wordS.substring(1);
				wordC = wordC.substring(1);
				if(wordO.equals(wordC) || wordO.equals(wordS))
				{
					result = true;
				}
				else
				{
					result = false;
				}
			}
			else
			{
				result = false;
			}
		}
		return result;
	}
}
