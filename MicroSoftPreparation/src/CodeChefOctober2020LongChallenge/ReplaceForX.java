package CodeChefOctober2020LongChallenge;

import java.util.Arrays;
import java.util.Scanner;

// https://www.codechef.com/OCT20B/problems/REPLESX
public class ReplaceForX 
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int x = s.nextInt();
			int p = s.nextInt();
			int k = s.nextInt();
			int[] arr= new int[n];
			for(int i=0 ; i<n ; i++)
			{
				arr[i] = s.nextInt();
			}
			Arrays.sort(arr);
			p--;k--;
			if(arr[p] == x)
			{
				System.out.println("0");
			}
			else if(p >= k && arr[p] <= x)
			{
				int pos = p+1;
				while(pos < n)
				{
					if(arr[pos] >= x)
					{
						break;
					}
					else
					{
						pos++;
					}
				}
				System.out.println(pos-p);
			}
			else if(p<=k && arr[p] >= x)
			{
				int pos = p-1;
				while(pos>0)
				{
					if(x >= arr[pos])
					{
						break;
					}
					else
					{
						pos--;
					}
				}
				System.out.println(p-pos);
			}
			else
			{
				System.out.println("-1");
			}
		}
		s.close();
	}
}
