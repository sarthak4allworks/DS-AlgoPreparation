package LeetCode.September2020;

import java.util.Scanner;

//https://leetcode.com/problems/car-pooling/
public class CarPooling
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[][] trips = new int[n][3];
			for(int i=0 ; i<n ; i++)
			{
				for(int j=0 ; j<3 ; j++)
				{
					trips[i][j] = s.nextInt();
				}
			}
			int capacity = s.nextInt();
			System.out.println(carPooling(trips, capacity));
		}
		s.close();
	}

	private static boolean carPooling(int[][] trips, int capacity)
	{
		if(capacity == 0 || trips.length == 0)
		{
			return false;
		}
		MergeSort(trips, 0, trips.length-1); // sort the array from the starting position
//		for(int i=0 ; i<trips.length; i++)
//		{
//			System.out.println(trips[i][0]+" "+trips[i][1]+" "+trips[i][2]);
//		}
		boolean flag = true;
		int currCapacity=trips[0][0];
		int currentEndKiloMeter = trips[0][2];
		boolean[] fl = new boolean[trips.length];
		for(int i=0 ; i<trips.length ; i++)
		{
			fl[i] = true;
		}
		if(currCapacity > capacity)
		{
			return false;
		}
		for(int i=1 ; i<trips.length ; i++)
		{
			if(trips[i][1] <= currentEndKiloMeter)
			{
				for(int j=0 ; j<i ; j++)
				{
					if(trips[j][2] <= trips[i][1] && fl[j] == true)
					{
						currCapacity -= trips[j][0];
						fl[j] = false;
					}
				}
				currCapacity += trips[i][0];
				currentEndKiloMeter = trips[i][2] > currentEndKiloMeter ? trips[i][2] : currentEndKiloMeter;
			}
			else
			{
				currCapacity = trips[i][0];
				currentEndKiloMeter = trips[i][2];
			}
			if(currCapacity > capacity)
			{
				flag = false;
				break;
			}
		}
		return flag;
	}

	private static void MergeSort(int[][] trips, int l, int r) 
	{
		if (l < r) 
		{ 
            int m = (l + r) / 2; 
            MergeSort(trips, l, m); 
            MergeSort(trips, m + 1, r);  
            merge(trips, l, m, r); 
        } 	
	}

	private static void merge(int[][] trips, int l, int m, int r) 
	{
		int n1 = m - l + 1; 
        int n2 = r - m;
        int L[][] = new int[n1][3]; 
        int R[][] = new int[n2][3]; 
        for (int i = 0; i < n1; ++i) 
        {
        	L[i][0] = trips[l + i][0];
            L[i][1] = trips[l + i][1];
        	L[i][2] = trips[l + i][2];
        }
        for (int j = 0; j < n2; ++j) 
        {
            R[j][0] = trips[m + 1 + j][0]; 
            R[j][1] = trips[m + 1 + j][1]; 
            R[j][2] = trips[m + 1 + j][2]; 
        }
        int i = 0, j = 0;
        int k = l; 
        while (i < n1 && j < n2)
        { 
            if (L[i][1] <= R[j][1]) 
            { 
            	trips[k][0] = L[i][0]; 
                trips[k][1] = L[i][1]; 
                trips[k][2] = L[i][2]; 
                i++; 
            } 
            else 
            { 
            	trips[k][0] = R[j][0]; 
                trips[k][1] = R[j][1];
                trips[k][2] = R[j][2]; 
                j++; 
            } 
            k++; 
        } 
        while (i < n1) 
        { 
        	trips[k][0] = L[i][0]; 
            trips[k][1] = L[i][1]; 
            trips[k][2] = L[i][2]; 
            i++; 
            k++; 
        } 
        while (j < n2)
        { 
        	trips[k][0] = R[j][0]; 
            trips[k][1] = R[j][1];
            trips[k][2] = R[j][2];  
            j++; 
            k++; 
        } 
	}
}
