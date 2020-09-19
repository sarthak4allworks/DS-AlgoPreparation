package LeetCode.September2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3465/
public class SequentialDigits
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int low = s.nextInt();
			int high = s.nextInt();
			List<Integer> list = sequentialDigits(low, high);
			for(int i: list)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
		s.close();
	}

	private static List<Integer> sequentialDigits(int low, int high) 
	{
		List<Integer> list = new ArrayList<>();
		for(int i=1 ; i<=9 ; i++)
		{
			int start = i, nextnum = i;
			while(start <= high)
			{
				if(start>=low && start<=high)
				{
					list.add(start);
				}
				if(nextnum == 9)
				{
					break;
				}
				nextnum++;
				start = start*10+nextnum;
			}
		}
		Collections.sort(list);
		return list;
	}
}
