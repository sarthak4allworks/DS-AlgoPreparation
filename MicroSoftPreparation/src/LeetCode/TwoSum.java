package LeetCode;

import java.util.Scanner;

// https://leetcode.com/problems/two-sum/

public class TwoSum
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while(t-->0)
		{
			int n = scanner.nextInt();
			int[] a = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				a[i] = scanner.nextInt();
			}
			int target = scanner.nextInt();
			int[] res = new int[2];
			res = twoSum(a, target);
			System.out.println(res[0]+" "+res[1]);
		}
		scanner.close();
	}

	private static int[] twoSum(int[] a, int target) 
	{
		int[] res = new int[2];
		int l = a.length;
		boolean flag = false;
		for(int i=0 ; i<l-1 ; i++)
		{
			for(int j=i+1 ; j<l ; j++)
			{
				if(a[i]+a[j] == target)
				{
					res[0] = i;
					res[1] = j;
					flag = true;
					break;
				}
			}
			if(flag)
			{
				break;
			}
		}
		return res;
	}
}
