package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3451/
public class WordPattern 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			String pattern = s.next();
			String str = "";
			str = s.nextLine();
			str += s.nextLine();
			System.out.println(wordPattern(pattern, str));
		}
		s.close();
	}

	private static boolean wordPattern(String pattern, String str) 
	{
		boolean flag = true;
		int patternLength = pattern.length();
		String[] strArr = str.split(" ");
		int strLength = strArr.length;
		if(patternLength == strLength)
		{
			Map<Character, String> map = new HashMap<>();
			for(int i=0 ; i<patternLength ; i++)
			{
				if(map.containsKey(pattern.charAt(i)))
				{
					if(!map.get(pattern.charAt(i)).equals(strArr[i]))
					{
						flag = false;
					}
				}
				else
				{
					map.put(pattern.charAt(i), strArr[i]);
				}
				if(flag)
				{
					for (Character ch: map.keySet())  
					{
						if(ch!=pattern.charAt(i) && map.get(ch).equals(strArr[i]))
						{
							flag = false;
						}
					}
				}
				if(!flag)
				{
					break;
				}
			}
		}
		else
		{
			flag = false;
		}
		return flag;
	}
}
