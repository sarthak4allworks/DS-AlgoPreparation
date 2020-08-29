package CodeChefAugust2020LongChallange;

import java.util.Scanner;

public class ChefWar
{
	public static void main(String[] args) 
	{
//		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int h = s.nextInt();
			int p = s.nextInt();
			int total = p;
			while(p!=0)
			{
				p/=2;
				total += p;
			}
//			System.out.println(total);
			if(total>=h)
			{
				System.out.println("1");
			}
			else
			{
				System.out.println("0");
			}
		}
		s.close();
	}
}
