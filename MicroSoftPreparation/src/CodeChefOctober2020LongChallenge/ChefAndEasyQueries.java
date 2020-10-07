package CodeChefOctober2020LongChallenge;

import java.util.Scanner;

// https://www.codechef.com/OCT20B/problems/CHEFEZQ
public class ChefAndEasyQueries
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			long k = s.nextInt();
			long[] a = new long[n];
			for(int i=0 ; i<n ; i++)
			{
				a[i] = s.nextLong();
			}
			boolean flag = false;
			for(int i=0 ; i<n-1 ; i++)
			{
				if(a[i] > k)
				{
					long num = a[i]-k;
					a[i] = k;
					a[i+1] += num; 
				}
				else if(a[i] < k)
				{
					System.out.println(i+1);
					flag = true;
					break;
				}
			}
			if(!flag)
			{
				if(a[n-1] == k)
				{
					System.out.println(n+1);
				}
				else if(a[n-1] < k)
				{
					System.out.println(n);
				}
				else
				{
					long num = a[n-1]/k;
					System.out.println(n+num);
				}
			}
		}
		s.close();
	}
}
