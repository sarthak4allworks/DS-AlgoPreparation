package LeetCode.Octber2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/563/week-5-october-29th-october-31st/3512/
public class MaximizeDistanceToCloesetPerson 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[] seats = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				seats[i] = s.nextInt();
			}
			System.out.println(maxDistToClosest(seats));
		}
		s.close();
	}

	private static int maxDistToClosest(int[] seats)
	{
		int l = -1, n = seats.length, maxDist = 0;
        for(int i = 0; i < n; i++) 
        {
            if(seats[i] == 1) 
            {
                if(l == -1)
                {
                    maxDist = i;
                }
                else 
                {
                    maxDist = Math.max(maxDist, (i - l) / 2);
                }
                l = i;
            }
        }
        
        if(seats[n - 1] == 0)
            maxDist = Math.max(maxDist, n - 1 - l);
        
        return maxDist;
	}
}
