package CodeChefJulyLong2020;

import java.util.Scanner;

// https://www.codechef.com/JULY20B/problems/CRDGAME

public class ChefAndCardGame 
{
	static int getSumOfDigits(int number)
	{
		int result = 0;
		while(number > 0)
		{
			result+=number%10;
			number /= 10;
		}
		return result;
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int ta=0, tb=0;
			while(n-->0)
			{
				int sa = getSumOfDigits(s.nextInt());
				int sb = getSumOfDigits(s.nextInt());
				if(sa>sb) ta++;
				else if(sa<sb) tb++;
				else 
				{
					ta++;
					tb++;
				}
			}
			if(ta == tb)
			{
				System.out.println("2 " +  ta);
			}
			else if(ta < tb)
			{
				System.out.println("1 " + tb);
			}
			else
			{
				System.out.println("0 " + ta);
			}
		}
		s.close();
	}

}
