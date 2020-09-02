package LeetCode.September2020;

import java.util.HashMap;
import java.util.Scanner;

//https://leetcode.com/explore/featured/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3445/
public class LargestTimeForGivenDigits 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int[] a = new int[4];
			for(int i = 0 ; i<4 ; i++)
			{
				a[i] = s.nextInt();
			}
			System.out.println(largestTimeFromDigits(a));
		}
		s.close();
	}
	
	static HashMap<Integer, Integer> getFrequencyMap(int arr[]) 
	{ 
		HashMap<Integer, Integer> hashMap = new HashMap<>(); 
		for (int i = 0; i < arr.length; i++)
		{ 
			if (hashMap.containsKey(arr[i])) 
			{ 
				hashMap.put(arr[i], hashMap.get(arr[i]) + 1); 
			} 
			else 
			{ 
				hashMap.put(arr[i], 1); 
			} 
		} 
		return hashMap; 
	} 

	private static String largestTimeFromDigits(int[] a) 
	{		
		HashMap<Integer, Integer> hashMap = getFrequencyMap(a);
		String res = "";
		for(int i=6 ; i<10 ; i++)
		{
			if(hashMap.containsKey(i) && hashMap.get(i) > 2)
			{
				return res;
			}
		}
		for(int i=3 ; i<10 ; i++)
		{
			if(hashMap.containsKey(i) && hashMap.get(i) > 3)
			{
				return res;
			}
		}
		int count = 0;
		for(int i=3 ; i<10 ; i++)
		{
			if(hashMap.containsKey(i) && hashMap.get(i) > 1)
			{
				count++;
			}
		}
		if(count>1)
		{
			return res;
		}
		boolean flag = false;
		count = 0;
		for(int i=6 ; i<10 ; i++)
		{
			if(hashMap.containsKey(i) && hashMap.get(i) > 0)
			{
				count++;
			}
			if(hashMap.containsKey(i) && hashMap.get(i) > 1)
			{
				flag = true;
			}
		}
		if(count>1)
		{
			flag = true;
		}
		// if flag true then needs to adjust one digit greater than 5 should be second digit of hour and hour should start with either 0 or 1
		if(flag)
		{
			boolean flag1 = false;
			for(int i=1 ; i>=0 ; i--)
			{
				if(hashMap.containsKey(i) && hashMap.get(i) > 0)
				{
					res+=i;
					hashMap.put(i, hashMap.get(i)-1);
					flag1 = true;
					break;
				}
			}
			if(!flag1)
			{
				return "";
			}
			for(int i=9 ; i>=6 ; i--)
			{
				if(hashMap.containsKey(i) && hashMap.get(i) > 0)
				{
					res+=i;
					hashMap.put(i, hashMap.get(i)-1);
					break;
				}
			}
			res+=":";
			flag1 = false;
			for(int i=0 ; i<6 ; i++)
			{
				if(hashMap.containsKey(i) && hashMap.get(i) > 0)
				{
					res+=i;
					hashMap.put(i, hashMap.get(i)-1);
					flag1 = true;
					break;
				}
			}
			if(!flag1)
			{
				return "";
			}
			for(int i=9 ; i>=6 ; i--)
			{
				if(hashMap.containsKey(i) && hashMap.get(i) > 0)
				{
					res+=i;
					hashMap.put(i, hashMap.get(i)-1);
					break;
				}
			}
			return res;
		}
		else
		{		
			String ans = "";
			int len = a.length;
			for(int i=0; i<len-1 ; i++)
			{
				for(int j=i+1 ; j<len ; j++)
				{
					if(a[i]>a[j])
					{
						int temp = a[i];
						a[i] = a[j];
						a[j] = temp;
					}
				}
			}
			if(a[0]<0 || a[0] > 2)
			{
				return ans;
			}
			int index = -1;
			flag = false;
			for(int i=0 ; i<len ; i++)
			{
				if(a[i] <= 2)
				{
					flag = true;
					index = i;
				}
			}
			if(flag)
			{
				ans+=a[index];
				int num = a[index];
				a[index] = -1;
				flag = false;
				if(num == 0 || num == 1)
				{
					for(int i=0 ; i<len ; i++)
					{
						if(a[i] >= 0 && a[i] < 10)
						{
							flag = true;
							index = i;
						}
					}
				}
				else
				{
					for(int i=0 ; i<len ; i++)
					{
						if(a[i] >= 0 && a[i] < 4)
						{
							flag = true;
							index = i;
						}
					}
				}
				if(flag)
				{
					ans+=a[index]+":";
					a[index] = -1;
					flag = false;
					for(int i=0 ; i<len ; i++)
					{
						if(a[i] >= 0 && a[i] < 6)
						{
							flag = true;
							index = i;
						}
					}
					if(flag)
					{
						ans+=a[index];
						a[index] = -1;
						for(int i=0;  i<len ; i++)
						{
							if(a[i] != -1)
							{
								ans+=a[i];
								break;
							}
						}
					}
					else
					{
						ans = "";
					}
				}
				else
				{
					ans = "";
				}
			}
			return ans;
		}
	}
}
