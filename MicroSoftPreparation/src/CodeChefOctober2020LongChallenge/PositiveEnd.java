package CodeChefOctober2020LongChallenge;

import java.util.Scanner;

// https://www.codechef.com/OCT20B/problems/POSAND
public class PositiveEnd 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int[] a = new int[100000];
		a[0] = 2; a[1] = 3; a[2] = 1;
		for(int i=3 ; i<100000 ; i++)
		{
			a[i] = i+1;
		}
		for(int i=4 ; i<=100000 ; i*=2)
		{
			int temp = a[i-1];
			a[i-1] = a[i];
			a[i] = temp;
		}
		while(t-->0)
		{
			int n = s.nextInt();
			boolean flag = n%2 == 0 && IsNPowerOfTwo(n);
			if(flag)
			{
				System.out.println("-1");
			}
			else if(n==1)
			{
				System.out.println("1");
			}
			else
			{
				for(int i=0 ; i<n ; i++)
				{
					System.out.print(a[i]+" ");
				}
				System.out.println();
			}
		}
		s.close();
	}

	private static boolean IsNPowerOfTwo(int x)
	{
		return x!=0 && ((x&(x-1)) == 0);
	}
}
