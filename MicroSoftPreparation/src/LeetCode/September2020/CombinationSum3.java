package LeetCode.September2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3457/
public class CombinationSum3 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int k = s.nextInt();
			int sum = s.nextInt();
			List<List<Integer>> list = combinationSum3(k, sum);
			for(List<Integer> l: list)
			{
				System.out.print(l+" ");
			}
			System.out.println();
		}
		s.close();
	}

	private static List<List<Integer>> combinationSum3(int k, int sum) 
	{
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> curr = new ArrayList<>();
		CreateCombination(result, curr, k, 1, sum);
		return result;
	}

	private static void CreateCombination(List<List<Integer>> result, List<Integer> curr, int k, int start, int sum) 
	{
		//System.out.println("Start: "+start+" sum: "+ sum);
		if(sum<0)
		{
			return;
		}
		if(sum == 0 && curr.size()== k)
		{
			//System.out.println(curr);
			result.add(new ArrayList<>(curr));
		}
		for(int i=start ; i<=9 ; i++)
		{
			curr.add(i);
			CreateCombination(result, curr, k, i+1, sum-i);
			//System.out.println(curr);
			curr.remove(curr.size()-1);
		}
	}
}
