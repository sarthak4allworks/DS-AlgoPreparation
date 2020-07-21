package ProjectEulerProblems;

import java.util.Scanner;

// https://projecteuler.net/problem=1

public class Problem1 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int total = 0;
		int num = s.nextInt();
		for(int i=3 ; i<num ; i++)
		{
			if(i%3 == 0 || i%5 == 0)
			{
				total += i;
			}
		}
		System.out.println(total);
		s.close();
	}

}
