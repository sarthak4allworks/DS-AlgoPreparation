package LeetCode.September2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

// https://leetcode.com/explore/featured/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3458/
public class InsertInterval 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[][] intervals = new int[n][2];
			for(int i=0 ; i<n ; i++)
			{
				for(int j=0 ; j<2 ; j++)
				{
					intervals[i][j] = s.nextInt();
				}
			}
			int[] newInterval = new int[2];
			for(int i=0 ; i<2 ; i++)
			{
				newInterval[i] = s.nextInt();
			}
			InsertInterval is = new InsertInterval();
			int[][] result = is.insert(intervals, newInterval);
			int r = result.length;
			int c = result[0].length;
			System.out.print("[");
			for(int i=0 ; i<r ; i++)
			{
				System.out.print("[");
				for(int j=0 ; j<c ; j++)
				{
					if(j!=c-1)
					{
						System.out.print(result[i][j]+",");
					}
					else
					{
						System.out.print(result[i][j]);
					}
				}
				System.out.print("]");
			}
			System.out.println("]");
		}
		s.close();
	}
	
	class Interval
	{
		int start;
		int end;
		Interval(){}
		Interval(int start, int end)
		{
			this.start = start;
			this.end = end;
		}
	}
	
	private int[][] ConvertIntervalIntoArray(List<Interval> ans) 
	{
		int size = ans.size();
		int[][] result = new int[size][2];
		for(int i=0 ; i<size ; i++)
		{
			result[i][0] = ans.get(i).start;
			result[i][1] = ans.get(i).end;
		}
		return result;
	}
	
	private boolean doesOverLap(Interval interval, Interval newIn)
	{
		return (Math.min(interval.end, newIn.end) >= Math.max(interval.start, newIn.start));
	}
	
	public int[][] insert(int[][] intervals, int[] newInterval) 
	{
		List<Interval> list = new ArrayList<>();
		for(int i=0 ; i<intervals.length ; i++)
		{
			list.add(new Interval(intervals[i][0], intervals[i][1]));
		}
		Interval newIn = new Interval(newInterval[0], newInterval[1]);
		List<Interval> ans = new ArrayList<>();
		int n = list.size();
		int[][] result = null;
		if(n == 0)
		{
			ans.add(newIn);
			result = ConvertIntervalIntoArray(ans);
			return result;
		}
		if(newIn.end < list.get(0).start || newIn.start > list.get(n-1).end)
		{
			if(newIn.end < list.get(0).start)
			{
				ans.add(newIn);
				ans.addAll(list);
			}
			if(newIn.start > list.get(n-1).end)
			{
				ans.addAll(list);
				ans.add(newIn);
			}
			result = ConvertIntervalIntoArray(ans);
			return result;
		}
		if(newIn.start <= list.get(0).start && newIn.end >= list.get(n-1).end)
		{
			ans.add(newIn);
			result = ConvertIntervalIntoArray(ans);
			return result;
		}	
		boolean overlap = false;
		for(int i=0 ; i<n ; i++)
		{
			overlap = doesOverLap(list.get(i), newIn);
			if(overlap)
			{
				break;
			}
		}
//		System.out.println(overlap);
		if(overlap)
		{
			int index = 0;
			for(int i=0 ; i<n ; i++)
			{
				if(newIn.start >= list.get(i).start && newIn.start<=list.get(i).end)
				{
					ans.add(list.get(i));
					ans.add(newIn);
					index = i+1;
					break;
				}
				else if(newIn.start <= list.get(i).start && newIn.end <= list.get(i).end)
				{
					ans.add(newIn);
					break;
				}
				else if(newIn.start <= list.get(i).start && newIn.end >= list.get(i).end)
				{
					ans.add(newIn);
					break;
				}
				else
				{
					ans.add(list.get(i));
					index = i+1;
				}
			}
			for(int i=index ; i<n ; i++) 
			{
				ans.add(list.get(i));
			}
//			for(Interval a: ans)
//			{
//				System.out.println(a.start+" "+a.end);
//			}
			Stack<Interval> stack = new Stack<>();
			stack.push(ans.get(0));
			for(int i=1 ; i<ans.size() ; i++)
			{
				Interval top = stack.peek();
				int currStart = ans.get(i).start;
				int currEnd = ans.get(i).end;
				if(top.end < currStart)
				{
					stack.push(ans.get(i));
				}
				else if (top.end < currEnd) 
				{
					top.end = currEnd;
					stack.pop();
					stack.push(top);
				}
			}
			ans.clear();
			for(int i=0 ; i<stack.size() ; i++)
			{
				ans.add(stack.get(i));
			}
			result = ConvertIntervalIntoArray(ans);
			return result;
		}
		else
		{
			int index = 0;
			for(int i=0 ; i<n ; i++)
			{
				if(list.get(i).end < newIn.start)
				{
					ans.add(list.get(i));
					index = i+1;
				}
				else
				{
					ans.add(newIn);
					break;
				}
			}
			for(int i=index ; i<n ; i++)
			{
				ans.add(list.get(i));
			}
			result = ConvertIntervalIntoArray(ans);
			return result;
		}
		
//		if(intervals.length != 0)
//		{
//			int newIntervalLow = newInterval[0];
//			int newIntervalHigh = newInterval[1];
//			int r = intervals.length;
//	        int c = intervals[0].length;
//	        int lowVal = intervals[0][0];
//	        int highVal = intervals[r-1][c-1];
//	        lowVal = lowVal > newIntervalLow ? newIntervalLow : lowVal;
//	        highVal = highVal < newIntervalHigh ? newIntervalHigh : highVal;
//	        int size = highVal + 1;
//	        int[][] arr = new int[size][2];
//	        for(int i=0 ; i<=size ; i++)
//	        {
//	        	arr[i][0] = i;
//	        	arr[i][1] = -1;
//	        }
////	        for(int i=0 ; i<=size ; i++)
////	        {
////	        	System.out.println(arr[i][0]+" "+arr[i][1]);
////	        }
//	        for(int i=0 ; i<r ; i++)
//	        {
//	        	for(int j=intervals[i][0] ; j <= intervals[i][1] ; j++)
//	        	{
//	        		arr[j][1] = i;
//	        	}
//	        }
//	        int groupOfNewIntervalLow = arr[newIntervalLow][1];
//	        int groupOfNewIntervalHigh = arr[newIntervalHigh][1];
//	        boolean IsNeedNewGroup = false;
//	        if(groupOfNewIntervalLow != -1 && groupOfNewIntervalHigh == -1)
//	        {
////	        	System.out.println("Here...");
//	        	for(int i=newIntervalLow ; i<=newIntervalHigh ; i++)
//	        	{
//	        		arr[i][1] = groupOfNewIntervalLow;
//	        	}
//	        }
//	        else if(groupOfNewIntervalLow == -1 && groupOfNewIntervalHigh != -1)
//	        {
////	        	System.out.println("here1...");
////	        	System.out.println(newIntervalLow);
//	        	for(int i=newIntervalLow ; i<=newIntervalHigh ; i++)
//	        	{
//	        		arr[i][1] = groupOfNewIntervalHigh;
//	        	}
////	        	for(int i=0 ; i<=size ; i++)
////	        	{
////	        		System.out.println(arr[i][0]+" "+arr[i][1]);
////	        	}
//	        }
//	        else if(groupOfNewIntervalLow == -1 && groupOfNewIntervalHigh == -1)
//	        {
////	        	System.out.println("here3...");
//	        	IsNeedNewGroup = true;
//	        }
//	        else
//	        {
////	        	System.out.println("here4...");
//	        	for(int i=newIntervalLow ; i<=newIntervalHigh ; i++)
//	        	{
//	        		arr[i][1] = groupOfNewIntervalLow;
//	        	}
//	        	for(int i=newIntervalHigh ; i<=size ; i++)
//	        	{
//	        		if(arr[i][1] == groupOfNewIntervalHigh)
//	        		{
//	        			arr[i][1] = groupOfNewIntervalLow;
//	        		}
//	        	}
//	        }
//	        
////	        System.out.println(newIntervalLow+" "+newIntervalHigh);
//	        if(IsNeedNewGroup)
//	        {
//	        	for(int i=newIntervalLow ; i<=newIntervalHigh ; i++)
//	        	{
//	        		arr[i][1] = size+1;
//	        	}
//	        }
////	        for(int i=0 ; i<=size ; i++)
////	        {
////	        	System.out.println(arr[i][0]+" "+arr[i][1]);
////	        }
//	        Set<Integer> set = new HashSet<>();
//	        for(int i=0 ; i<=size ; i++)
//	        {
//	        	if(arr[i][1] != -1)
//	        	{
//	        		set.add(arr[i][1]);
//	        	}
//	        }
////	        for(int i=0 ; i<=size ; i++)
////	        {
////	        	System.out.println(arr[i][0] + " "+ arr[i][1]);
////	        }
//	        int noOfGroupNow = set.size();
////	        System.out.println(noOfGroupNow);
//	        int[][] res = new int[noOfGroupNow][2];
//	        for(int i=0 ; i<noOfGroupNow ; i++)
//	        {
//	        	res[i][0] = -1;
//	        	res[i][1] = -1;
//	        }
//	        int index = 0;
//	        int gp = -1;
//	        for(int i=0 ; i<=size ;)
//	        {
//	        	if(arr[i][1] != -1 && res[index][0] == -1)
//	        	{
////	        		System.out.println("Here... "+i);
//	        		gp = arr[i][1];
//	        		res[index][0] = i;
//	        		int lastj = -1;
//	        		for(int j=i ; j<=size ; j++)
//	        		{
//	        			if(arr[j][1] == gp)
//	        			{
//	        				res[index][1] = j;
//	        				lastj = j;
//	        			}
////	        			System.out.println("Here... "+lastj);
//	        		}
//	        		i = lastj+1;
//	        	}
//	        	else
//	        	{
//	        		i++;
//	        	}
//	        	if(res[index][0] != -1 && res[index][1] != -1)
//	        	{
//	        		index++;
//	        	}
//	        	if(index>=noOfGroupNow)
//	        	{
//	        		break;
//	        	}
//	        }
//	        
//			return res;
//		}
//		else
//		{
//			int[][] res = new int[1][2];
//			res[0][0] = newInterval[0];
//			res[0][1] = newInterval[1];
//			return res;
//		}
	}
}
