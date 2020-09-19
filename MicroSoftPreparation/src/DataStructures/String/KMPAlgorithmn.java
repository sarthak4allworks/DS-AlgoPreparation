package DataStructures.String;

import java.util.Scanner;

// Find that string is present in text and return the index of first character if string present
public class KMPAlgorithmn 
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			String text = s.next();
			String pattern = s.next();
			FindStringInText(text, pattern);
		}
		s.close();
	}

	private static void FindStringInText(String text, String pattern) 
	{
		int patLen = pattern.length();
		int[] patArr = new int[patLen];
		patArr[0] = 0;
		int i = 0;
		for(int j=1 ; j<patLen ; )
		{
			if(pattern.charAt(j) == pattern.charAt(i))
			{
				patArr[j] = i+1;
				i++;
				j++;
			}
			else
			{
				if(i-1>=0)
				{
					i = patArr[i-1];
				}
				else
				{
					patArr[j] = 0;
					j++;
				}
			}
		}
		for(i=0 ; i<patLen ; i++)
		{
			System.out.print(patArr[i]+" ");
		}
		System.out.println();
		int patIndex = 0;
		//int finalIndex = -1;
		for(i = 0 ; i<text.length() ; )
		{
			//System.out.println("text["+i+"]"+text.charAt(i) +" pattern["+patIndex+"]"+ pattern.charAt(patIndex));
			if(text.charAt(i) == pattern.charAt(patIndex) || (patIndex == 0 && pattern.charAt(patIndex) != text.charAt(i)))
			{
				patIndex++;
				i++;
			}
			else
			{
				if(patIndex != 0)
				{
					patIndex = patArr[patIndex-1];
				}
				else
				{
					patIndex = 0;
				}
			}
		}
		System.out.println(patIndex);
		if(patIndex-1 == pattern.length())
		{
			System.out.println("Match");
		}
		System.out.println();
	}
}
