package LeetCode.Octber2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3497/
public class SearchA2DMatrix 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int m = s.nextInt();
			int n = s.nextInt();
			int[][] matrix = new int[m][n];
			for(int i=0 ; i<m ; i++)
			{
				for(int j=0 ; j<n ; j++)
				{
					matrix[i][j] = s.nextInt();
				}
			}
			int target =s.nextInt();
			System.out.println(searchMatrix(matrix, target));
		}
		s.close();
	}

	private static boolean searchMatrix(int[][] matrix, int target) 
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int cols = matrix[0].length;
		int rowNo = -1;
		for(int i=0 ; i<matrix.length ; i++)
		{
			if(target >= matrix[i][0] && target <= matrix[i][cols-1])
			{
				rowNo = i;
				break;
			}
		}
		if(rowNo == -1) return false;
		return binarySearch(matrix, rowNo, target, 0, matrix[rowNo].length-1);
	}

	private static boolean binarySearch(int[][] matrix, int rowNo, int target, int start, int end)
	{
		if(start <= end)
		{
			int mid = start+ (end - start)/2;
			if(matrix[rowNo][mid] == target) return true;
			else if(matrix[rowNo][mid] > target) 
			{
				return binarySearch(matrix, rowNo, target, start, mid-1);
			}
			else
			{
				return binarySearch(matrix, rowNo, target, mid+1, end);
			}
		}
		return false;
	}
}
