package LeetCode.Octber2020;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3498/
public class RepeatedDNASequences
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while(t-->0)
		{
			String s = scanner.next();
			List<String> strings = findRepeatedDnaSequences(s); 
			for(String string: strings)
			{
				System.out.print(string+" ");
			}
			System.out.println();
		}
		scanner.close();
	}

	private static List<String> findRepeatedDnaSequences(String s) 
	{
		Set<String> set = new LinkedHashSet<>(); 
		Set<String> duplicates  = new LinkedHashSet<>();
		for(int i=0 ; i<s.length()-9 ; i++)
		{
			String str = s.substring(i, i+10);
			if(set.contains(str))
			{
				duplicates.add(str);
			}
			else
			{
				set.add(str);
			}
		}
		return new ArrayList<>(duplicates);
	}
}
