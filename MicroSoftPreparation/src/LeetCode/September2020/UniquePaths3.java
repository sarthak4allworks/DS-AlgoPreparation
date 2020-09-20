package LeetCode.September2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3466/
public class UniquePaths3
{
	int totalPath;
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int rows = s.nextInt();
			int cols = s.nextInt();
			int[][] grid = new int[rows][cols];
			for(int i=0 ; i<rows ; i++)
			{
				for(int j=0 ; j<cols ; j++)
				{
					grid[i][j] = s.nextInt();
				}
			}
			UniquePaths3 up3 = new UniquePaths3();
			System.out.println(up3.uniquePathsIII(grid));
		}
		s.close();
	}

	private int uniquePathsIII(int[][] grid) 
	{
		int totalZeros = 0;
		for(int i=0 ; i<grid.length ; i++)
		{
			for(int j=0 ; j<grid[0].length ; j++)
			{
				if(grid[i][j] == 0)
				{
					totalZeros++;
				}
			}
		}
		for(int i=0 ; i<grid.length ; i++)
		{
			for(int j=0 ; j<grid[0].length; j++)
			{
				if(grid[i][j] == 1)
				{
					DFS(grid, i, j, totalZeros);
				}
			}
		}
		return totalPath;
	}

	private void DFS(int[][] grid, int i, int j, int totalZeros) 
	{
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || (grid[i][j] == 2 && totalZeros != 0) || grid[i][j] == 99 || grid[i][j] == -1) // base condition
		{
			return;
		}
		if(grid[i][j] == 2 && totalZeros == 0)// base condition
		{
			totalPath++;
		}
		if(grid[i][j] == 0)
		{
			totalZeros--;
		}
		int temp = grid[i][j];
		grid[i][j] = 99;
		// traverse in all 4 directions
		DFS(grid, i+1, j, totalZeros);
		DFS(grid, i-1, j, totalZeros);
		DFS(grid, i, j+1, totalZeros);
		DFS(grid, i, j-1, totalZeros);
		// backtrack
		grid[i][j] = temp;
	}
}
