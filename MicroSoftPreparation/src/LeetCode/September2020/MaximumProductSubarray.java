package LeetCode.September2020;

import java.util.Scanner;

//https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3456/
public class MaximumProductSubarray 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[] a = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				a[i] = s.nextInt();
			}
			System.out.println(maxProduct(a));
		}
		s.close();
	}
	
	static int min(int x, int y) { return x < y ? x : y; } 
    static int max(int x, int y) { return x > y ? x : y; }

	private static int maxProduct(int[] arr)
	{
		int n = arr.length; 
		if(n==1 && arr[0]<0)
		{
			return arr[0];
		}
		boolean fl = true;
		for(int i=0 ; i<n ; i++) 
		{
			if(arr[i] != -1)
			{
				fl = false;
				break;
			}
		}
		if(fl)
		{
			return 1;
		}
		fl = true;
		int count0 = 0, count1 = 0;
		for(int i=0 ; i<n ; i++)
		{
			if(arr[i] == 0)
			{
				count0++;
			}
			else if(arr[i] == -1)
			{
				count1++;
			}
			else
			{
				fl = false;
				break;
			}
		}
		if(fl)
		{
			return count1>1 ? 1 : 0;
		}
        int max_ending_here = 1; 
        int min_ending_here = 1; 
        int max_so_far = 1; 
        int flag = 0; 
        for (int i = 0; i < n; i++) 
        { 
            if (arr[i] > 0) 
            { 
                max_ending_here = max_ending_here * arr[i]; 
                min_ending_here = min(min_ending_here * arr[i], 1); 
                flag = 1; 
            } 
            else if (arr[i] == 0)
            { 
                max_ending_here = 1; 
                min_ending_here = 1; 
            } 
            else 
            { 
                int temp = max_ending_here; 
                max_ending_here = max(min_ending_here * arr[i], 1); 
                min_ending_here = temp * arr[i]; 
            } 
            if (max_so_far < max_ending_here) 
            {
                max_so_far = max_ending_here; 
            }
        } 
        if (flag == 0 && max_so_far == 1) 
        {
            return 0; 
        }
        return max_so_far; 
	}
}
