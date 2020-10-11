package LeetCode.Octber2020;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumNumberOfArraowsToBurstBaloons
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[][] points = new int[n][2];
			for(int i=0 ; i<n ; i++)
			{
				points[i][0] = s.nextInt();
				points[i][1] = s.nextInt();
			}
			System.out.println(findMinArrowShots(points));
		}
		s.close();
	}

	private static int findMinArrowShots(int[][] points) 
	{
		if(points.length == 0)
		{
			return 0;
		}
		int res = 1;
		Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
		int max = points[0][1];
		for(int i=1 ; i<points.length ; i++)
		{
			if(points[i][0] > max)
			{
				res++;
				max = points[i][1];
			}
			else
			{
				max = Math.min(max, points[i][1]);
			}
		}
		return res;
	}
}
