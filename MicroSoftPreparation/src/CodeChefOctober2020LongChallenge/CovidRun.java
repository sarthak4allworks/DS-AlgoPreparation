package CodeChefOctober2020LongChallenge;

import java.util.Scanner;

// https://www.codechef.com/OCT20B/problems/CVDRUN
public class CovidRun 
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int k = s.nextInt();
			int x = s.nextInt();
			int y = s.nextInt();
			boolean[] flag = new boolean[n];
			for(int i=0;  i<n ; i++)
			{
				flag[i] = false;
			}
			while(true)
			{
				boolean flag1 = true;
				for(int i=x ; i<n ; i=(i+k)%n)
				{
					if(flag[i] == true || flag[y] == true)
					{
						flag1 = false;
						break;
					}
					flag[i] = true;
				}
				if(flag1 == false)
				{
					break;
				}
			}
			if(flag[y]) System.out.println("YES");
			else System.out.println("NO");
		}
		s.close();
	}
}
