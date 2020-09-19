package DataStructures.Graph;

import java.util.Scanner;

public class NumberOfIslands 
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int rows = s.nextInt();
			int cols = s.nextInt();
			int[][] a = new int[rows][cols];
			for(int i=0 ; i<rows ; i++)
			{
				for(int j=0 ; j<cols ; j++)
				{
					a[i][j] = s.nextInt();
				}
			}
			int count = NumberOfIslandsInGraph(a, rows, cols);
			System.out.println("Number of Islands in Graph is: "+ count);
		}
		s.close();
	}

	private static int NumberOfIslandsInGraph(int[][] a, int rows, int cols)
	{
		int count = 0;
		boolean[][] visited = new boolean[rows][cols];
		for(int i=0 ; i<rows ; i++)
		{
			for(int j=0 ; j<cols ; j++)
			{
				if(a[i][j] == 1 && !visited[i][j])
				{
					DFS(visited, i, j, a);
					count++;
				}
			}
		}
		return count;
	}

	private static void DFS(boolean[][] visited, int row, int col, int[][] a) 
	{
		// Check in all 8 directions if number is 1 and not visited the make it visit because its neighbour is already visited
		int[] rowDirection = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] colDirection = {0, -1, -1, -1, 0, 1, 1, 1};
		visited[row][col] = true;
		for(int i=0 ; i<8 ; i++)
		{
			boolean flag = isSafe(visited, row+rowDirection[i], col+colDirection[i], a);
			if(flag)
			{
				DFS(visited, row+rowDirection[i], col+colDirection[i], a);
			}
		}
	}

	private static boolean isSafe(boolean[][] visited, int i, int j, int[][] a) 
	{
		int rowLen = visited.length;
		int colLen = visited[0].length;
		return (i>=0 && j>=0 && i< rowLen && j<colLen && !visited[i][j] && a[i][j] == 1);
	}
}
