package ProjectEulerProblems;

import java.util.Scanner;

//https://projecteuler.net/problem=8
public class Problem8 
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String str = s.next();
		long mul = 1;
		for(int i=0 ; i<str.length()-n ; i++)
		{
			long multi = 1;
			for(int j=i ; j<i+n ; j++)
			{
				long num = str.charAt(j)-'0';
				multi *= num;
			}
			if(multi>mul)
			{
				mul = multi;
			}
		}
		System.out.println(mul);
		s.close();
	}
}
