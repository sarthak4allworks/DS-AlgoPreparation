package LeetCode.Octber2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3500/
public class MinimumDominoRotationsForEqualRow 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[] A = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				A[i] = s.nextInt();
			}
			int[] B = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				B[i] = s.nextInt();
			}
			System.out.println(minDominoRotations(A, B));
		}
		s.close();
	}

	private static int minDominoRotations(int[] A, int[] B)
	{
		int len = A.length;
		int[] aCount = new int[6];
		int[] bCount = new int[6];
		for(int i=0 ; i<len ; i++)
		{
			aCount[A[i]-1]++;
			bCount[B[i]-1]++;
		}
        for(int i=0 ; i<6 ; i++)
        {
            if(aCount[i] == len || bCount[i] == len) return 0;
        }
		int finalRes = Integer.MAX_VALUE;
		int result = 0;
		for(int i=0 ; i<6 ; i++)
		{
			if(aCount[i] >0 && bCount[i] > 0)
			{
				int max = Math.max(aCount[i], bCount[i]);
				if(max == aCount[i])
				{
					for(int j=0 ; j<len ; j++)
					{
						if(A[j] == i+1) continue;
						else if(A[j] != i+1 && B[j] == i+1) result++;
						else 
						{
							result = 0;
							break;
						}
					}
				}
				else
				{
					for(int j=0 ; j<len ; j++)
					{
						if(B[j] == i+1) continue;
						else if(B[j] != i+1 && A[j] == i+1) result++;
						else 
						{
							result = 0;
							break;
						}
					}
				}
				if(result > 0)
				{
					finalRes = Math.min(finalRes, result);
				}
			}
		}
		return finalRes == Integer.MAX_VALUE ? -1 : finalRes;
	}
}
