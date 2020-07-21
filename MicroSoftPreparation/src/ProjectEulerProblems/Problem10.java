package ProjectEulerProblems;

import java.util.Scanner;

//https://projecteuler.net/problem=10
public class Problem10 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		boolean[] arr = new boolean[n+1];
		for(int i=0 ;i<=n ; i++)
		{
			arr[i] = true;
		}
		arr[0] = arr[1] = false;
		for(int i=2 ; i<=n ; i++)
		{
			if(arr[i])
			{
				arr[i] = true;
				for(int j=i*2 ; j<=n ; j+=i)
				{
					arr[j] = false;
				}
			}
		}
		long sum = 0;
		for(int i=0 ; i<=n ; i++)
		{
			if(arr[i])
			{
				sum = sum+i;
			}
		}
		System.out.println(sum);
		s.close();
	}

}
