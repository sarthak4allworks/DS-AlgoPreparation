package CodeChefJulyLong2020;

import java.util.Scanner;

public class ChefAndString 
{
	public static void main(String[] args) 
	{
		System.out.println("Start");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[] arr = new int[n];
			long total = 0;
			for(int i = 0 ; i <n ; i++)
			{
				arr[i] = s.nextInt();
			}
			for(int i=0 ; i<n-1 ; i++)
			{
				total += Math.abs(arr[i]-arr[i+1])-1;
			}
			System.out.println(total);
		}
		s.close();
	}

}
