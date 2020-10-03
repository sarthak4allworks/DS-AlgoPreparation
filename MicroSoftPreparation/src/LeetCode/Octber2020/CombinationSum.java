package LeetCode.Octber2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3481/
// Citrix Problem 2
public class CombinationSum
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[] candidates = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				candidates[i] = s.nextInt();
			}
			int target = s.nextInt();
			List<List<Integer>> combinations = combinationSum(candidates, target);
			for(List<Integer> combination: combinations)
			{
				for(int num: combination)
				{
					System.out.print(num+" ");
				}
				System.out.println();
			}
		}
		s.close();
	}

	private static List<List<Integer>> combinationSum(int[] candidates, int target) 
	{
		List<List<Integer>> combinations = new ArrayList<>();
		backTracking(candidates, 0, target, new ArrayList<Integer>(), combinations);
		return combinations;
	}

	private static void backTracking(int[] candidates, int start, int target, ArrayList<Integer> arrayList, List<List<Integer>> combinations) 
	{
		if(target < 0)
		{
			return;
		}
		if(target == 0)
		{
			combinations.add(new ArrayList<Integer>(arrayList));
		}
		for(int i=start ; i<candidates.length ; i++)
		{
			arrayList.add(candidates[i]);
			backTracking(candidates, i, target-candidates[i], arrayList, combinations);
			arrayList.remove(arrayList.size()-1);
		}
	}
}
