package CodeChefAugust2020LongChallange;

import java.util.Scanner;

public class ChefAndLinearChess 
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
			boolean isKOdd = k%2 == 0 ? false :true;
			int[] arr = new int[n];
			int[] sArr = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				sArr[i] = 0;
			}
			boolean isStepPossible = false;
			for(int i= 0 ; i<n ; i++)
			{
				arr[i] = s.nextInt();
				if(k%arr[i] == 0)
				{
					sArr[i] = (k/arr[i])-1;
				}
				else
				{
					sArr[i] = Integer.MAX_VALUE;
				}
				if(isKOdd && arr[i] == 1)
				{
					isStepPossible = true;
				}
			}
			if(isKOdd)
			{
				if(isStepPossible) System.out.println("1");
				else System.out.println("-1");
			}
			else
			{
				int index = -1;
				int min = Integer.MAX_VALUE;
				for(int i=0 ; i<n ; i++)
				{
					if(sArr[i] < min)
					{
						min = sArr[i];
						index = arr[i];
					}
				}
				System.out.println(index);
			}
		}
		s.close();
	}
}
