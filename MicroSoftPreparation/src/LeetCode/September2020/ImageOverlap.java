package LeetCode.September2020;

import java.util.Scanner;

//https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3450/
public class ImageOverlap 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int size = s.nextInt();
			int[][] a = new int[size][size];
			int[][] b = new int[size][size];
			for(int i=0 ; i<size ; i++)
			{
				for(int j=0 ; j<size ; j++)
				{
					a[i][j] = s.nextInt();
				}
			}
			for(int i=0 ; i<size ; i++)
			{
				for(int j=0 ; j<size ; j++)
				{
					b[i][j] = s.nextInt();
				}
			}			
			System.out.println(largestOverlap(a, b));
		}
		s.close();
	}

	private static int largestOverlap(int[][] a, int[][] b) 
	{
		int result = Integer.MIN_VALUE;
		int size = a.length;
//		boolean flag = false;
		if(size == 1)
		{
//			flag = true;
			if(a[0][0] == b[0][0] && a[0][0] == 1)
			{
				result = 1;
			}
			else
			{
				result = 0;
			}
		}
//		else if(size == 2)
//		{
//			int counta1 = 0;
//			int countb1 = 0;
//			for(int i=0 ; i<2 ; i++)
//			{
//				for(int j=0 ; j<2 ; j++)
//				{
//					if(a[i][j] == 1)
//					{
//						counta1++;
//					}
//					if(b[i][j] == 1)
//					{
//						countb1++;
//					}
//				}
//			}
//			if(counta1 == countb1)
//			{
//				flag = true;
//				int c=0;
//				for(int i=0 ; i<2 ; i++)
//				{
//					for(int j=0 ; j<2 ; j++)
//					{
//						if(a[i][j] == b[i][j] && a[i][j] == 1)
//						{
//							c++;
//						}
//					}
//				}
//		result = c;
//	}
//}
//if(!flag)
//{
		else
		{
			for(int i=0 ; i<size ; i++)
			{
				moveRight(a, size);
				for(int j=0 ; j<size ; j++)
				{
					moveDown(a, size);
					int count =  checkOverLapping(a, b, size);
					if(count > result)
					{
						result = count;
					}
				}
			}
		}
		return result;
	}

	private static int checkOverLapping(int[][] a, int[][] b, int size) 
	{
		int count = 0;
		for(int i=0 ; i<size ; i++)
		{
			for(int j=0 ; j<size ; j++)
			{
				if(a[i][j] == b[i][j] && a[i][j] == 1)
				{
					count++;
				}
			}
		}
		return count;
	}

	private static void moveDown(int[][] a, int size) 
	{
		int[][] temp = new int[size][size];
		for(int i=0 ; i<size ; i++)
		{
			for(int j=0 ; j<size ; j++)
			{
				temp[i][j] = a[i][j];
			}
		}
		for(int i=0 ; i<size ; i++)
		{
			for(int j=0 ; j<size ; j++)
			{
				a[i][j] = temp[(i+1)%size][j];
			}
		}
	}

	private static void moveRight(int[][] a, int size) 
	{
		int[][] temp = new int[size][size];
		for(int i=0 ; i<size ; i++)
		{
			for(int j=0 ; j<size ; j++)
			{
				temp[i][j] = a[i][j];
			}
		}
		for(int i=0 ; i<size ; i++)
		{
			for(int j=0 ; j<size ; j++)
			{
				a[i][j] = temp[i][(j+1)%size];
			}
		}
	}
}
