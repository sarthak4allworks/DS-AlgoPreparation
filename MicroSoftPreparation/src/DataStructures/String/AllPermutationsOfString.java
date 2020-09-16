package DataStructures.String;

import java.util.Scanner;

public class AllPermutationsOfString 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			String str = s.next();
			PrintAllPermutations(str, 0, str.length()-1);
			System.out.println();
		}
		s.close();
	}

	private static void PrintAllPermutations(String str, int i, int j)
	{
		if(i == j)
		{
			System.out.print(str+" ");
		}
		else
		{
			for(int l=i ; l<=j ; l++)
			{
				str = swap(str, i, l);
				PrintAllPermutations(str, i+1, j);
				str = swap(str, i, l);
			}
		}
	}

	private static String swap(String str, int i, int l) 
	{
		char[] a = str.toCharArray();
		char temp = a[i];
		a[i] = a[l];
		a[l] = temp;
		return String.valueOf(a);
	}
}
