package LeetCode.September2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3472/
public class LargestNumber
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[] nums = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				nums[i]  = s.nextInt();
			}
			System.out.println(largestNumber(nums));
		}
		s.close();
	}

	private static String largestNumber(int[] nums) 
	{
		List<Integer> list = new ArrayList<>();
		for(int num: nums)
		{
			list.add(num);
		}
		Collections.sort(list, (a,b) -> {
			String n1 = String.valueOf(a);
			String n2 = String.valueOf(b);
			return (n2+n1).compareTo(n1+n2);
		});
		StringBuilder sb = new StringBuilder();
		for(int num: list)
		{
			sb.append(num);
		}
		while(sb.length()>1 && sb.charAt(0) == '0')
		{
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}
}
