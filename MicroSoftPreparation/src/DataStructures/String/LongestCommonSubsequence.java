package DataStructures.String;

import java.util.Scanner;

// LCS algorithmn

public class LongestCommonSubsequence 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			String str1 = s.next();
			String str2 = s.next();
			LongestCommomSubsequenceAndItsLength(str1, str2);
		}
		s.close();
	}

	private static void LongestCommomSubsequenceAndItsLength(String str1, String str2)
	{
		int len1 = str1.length(); // cols
		int len2 = str2.length(); // rows
		int[][] a = new int[len2+1][len1+1];
		for(int i=0 ; i<=len1 ; i++)
		{
			a[0][i] = 0;
		}
		for(int i=0 ; i<=len2 ; i++)
		{
			a[i][0] = 0;
		}
		for(int i=1 ; i<=len2 ; i++)
		{
			char ch = str2.charAt(i-1);
			for(int j=1 ; j<=len1 ; j++)
			{
				if(ch == str1.charAt(j-1))
				{
					a[i][j] = a[i-1][j-1]+1;
				}
				else
				{
					a[i][j] = Math.max(a[i-1][j], a[i][j-1]);
				}
			}
		}
		StringBuffer s = new StringBuffer("");
		int i=len2, j=len1;
		while(i!=0 && j!=0)
		{
			if(a[i-1][j] == a[i][j-1] && str1.charAt(j-1) == str2.charAt(i-1))
			{
				s.append(str1.charAt(j-1));
				i--;j--;
			}
			else if(a[i-1][j] > a[i][j-1])
			{
				i--;
			}
			else
			{
				j--;
			}
		}
		System.out.println(s.reverse()+" "+s.length());
	}
}
