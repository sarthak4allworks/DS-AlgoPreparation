package LeetCode.Octber2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3510/
public class SummaryRanges 
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
				nums[i] = s.nextInt();
			}
			List<String> list = summaryRanges(nums);
			for(String str: list)
			{
				System.out.print(str+" ");
			}
			System.out.println();
		}
		s.close();
	}

	private static List<String> summaryRanges(int[] nums)
	{
		int n = nums.length;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            int start = nums[i];
            while(i + 1 < n && nums[i + 1] - nums[i] == 1)
            {
                i++;
            }
            if(start != nums[i])
            {
                list.add("" + start + "->" + nums[i]);
            }
            else 
            {
                list.add("" + start);
            }
        }
        return list;
	}
}
