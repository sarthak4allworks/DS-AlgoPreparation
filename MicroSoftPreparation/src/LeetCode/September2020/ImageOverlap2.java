package LeetCode.September2020;

import java.util.Scanner;

//https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3450/
public class ImageOverlap2 {
	public static void main(String[] args) {
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			int size = s.nextInt();
			int[][] a = new int[size][size];
			int[][] b = new int[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					a[i][j] = s.nextInt();
				}
			}
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					b[i][j] = s.nextInt();
				}
			}
			System.out.println(largestOverlap(a, b));
		}
		s.close();
	}

	private static int largestOverlap(int[][] A, int[][] B) 
	{
		int largestOverlap = 0;
        for (int row = -A.length + 1; row < A.length; row++)
            for (int col = -A[0].length + 1; col < A[0].length; col++)
                largestOverlap = Math.max(largestOverlap, overlappingOnes(A, B, row, col));
        return largestOverlap;  
	}

	public static int overlappingOnes(int[][] A, int[][] B, int rowOffset, int colOffset) {
        int overlapOnes = 0;
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < A[0].length; col++) {
                if ((row + rowOffset < 0 || row + rowOffset >= A.length) || (col + colOffset < 0 || col + colOffset >= A.length) || (A[row][col] + B[row + rowOffset][col + colOffset] != 2))
                    continue;
                overlapOnes++;
            }
        }
        return overlapOnes;
    }
}
