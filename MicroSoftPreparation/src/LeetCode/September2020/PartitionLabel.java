package LeetCode.September2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3448/
public class PartitionLabel 
{
	public static void main(String[] args) 
	{
		System.out.println("start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			String str = s.next();
			List<Integer> list = partitionLabels(str);
			for(Integer i : list)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
		s.close();
	}

	private static List<Integer> partitionLabels(String str) {
		List<Integer> list = new ArrayList<Integer>();
		int len = str.length();
		for(int i=0 ; i<len ;)
		{
			char ch = str.charAt(i);
			int lastIndexOfCh = str.lastIndexOf(ch);
			int lenOfSubString = lastIndexOfCh - i + 1;
//			System.out.println(i+" "+ch+" "+lastIndexOfCh+" "+lenOfSubString);
//			i += lenOfSubString;
			for(int j=i+1 ; j<i+lenOfSubString ; j++)
			{
//				System.out.println("j is "+j);
				char ch1 = str.charAt(j);
				int lastIndexOfCh1 = str.lastIndexOf(ch1);
				//System.out.println(ch1 +" "+ lastIndexOfCh1);
				if(lastIndexOfCh1 > lastIndexOfCh)
				{
					lastIndexOfCh = lastIndexOfCh1;
					lenOfSubString = lastIndexOfCh - i + 1;
				}
			}
			list.add(lenOfSubString);
			i += lenOfSubString;
		}
		return list;
	}
}
