package LeetCode.September2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3455/
public class BullsAndCows
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s= new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			String secret = s.next();
			String guess = s.next();
			System.out.println(getHint(secret, guess));
		}
		s.close();
	}

	private static String getHint(String secret, String guess) 
	{
		int len = secret.length();
		int[] secretCount = new int[10];
		int[] guessCount = new int[10];
		for(int i=0 ; i<10 ; i++)
		{
			secretCount[i] = guessCount[i] = 0;
		}
		int countA = 0;
		for(int i=0 ; i<len ; i++)
		{
			if(secret.charAt(i) == guess.charAt(i))
			{
				countA++;
			}
			else
			{
				secretCount[secret.charAt(i)-'0']++;
				guessCount[guess.charAt(i)-'0']++;
			}
		}
		int countB = 0;
		for(int i=0 ; i<10 ; i++)
		{
			countB+= secretCount[i]>guessCount[i] ? guessCount[i] : secretCount[i];
		}
		return countA+"A"+countB+"B";
	}
}
