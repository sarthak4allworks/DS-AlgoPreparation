package DataStructures.Tree;

import java.util.Arrays;
import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3506/
public class BagOfTokens 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[] tokens = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				tokens[i] = s.nextInt();
			}
			int P = s.nextInt();
			System.out.println(bagOfTokensScore(tokens, P));
		}
		s.close();
	}

	private static int bagOfTokensScore(int[] tokens, int P) {
		if(tokens.length == 0) return 0;
		int score = 0;
		int startIndex = 0;
		int endIndex = tokens.length-1;
		Arrays.sort(tokens);
		if(P < tokens[0]) return 0;
		score++;
		startIndex++;
		P-=tokens[0];
		while(startIndex <= endIndex)
		{
			if(tokens[startIndex] <= P)
			{
				score++;
				P-=tokens[startIndex++];
			}
			else
			{
				if(score <= 0 || endIndex-1 <= startIndex) break;
				P+=tokens[endIndex--];
				score--;
			}
		}
		return score;
	}
}
