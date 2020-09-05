package CodeChefSeptemberLong2020;

import java.util.Scanner;

//https://www.codechef.com/SEPT20B/problems/TREE2
public class AProblemOnSticks 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n= s.nextInt();
			int[] a = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				a[i] = s.nextInt();
			}
			boolean flag = true;
			for(int i=0 ; i<n ; i++)
			{
				if(a[i] != 0)
				{
					flag =false;
					break;
				}
			}
			if(flag == true)
			{
				System.out.println("0");
			}
			else
			{
				sort(a, 0, n-1); 
				for(int i=0 ; i<n ; i++)
				{
					System.out.print(a[i]+" ");
				}
				System.out.println();
				int count = 1;
				int firstNonZeroIndex = 0;
				for(int i=0 ; i<n ; i++)
				{
					if(a[i]!=0)
					{
						firstNonZeroIndex = i;
						break;
					}
				}
				for(int i=firstNonZeroIndex ; i<n-1 ; i++)
				{
					if(a[i]!=a[i+1])
					{
						count++;
					}
				}
				System.out.println(count);
			}
		}
		s.close();
	}

	private static void sort(int arr[], int l, int r) 
	{
		if (l < r)
		{ 
            int m = (l + r) / 2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr, m + 1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
	}

	private static void merge(int[] arr, int l, int m, int r) 
	{
		int n1 = m - l + 1; 
        int n2 = r - m; 

        int L[] = new int[n1]; 
        int R[] = new int[n2]; 

        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j]; 
   
        int i = 0, j = 0; 
 
        int k = l; 
        while (i < n1 && j < n2)
        { 
            if (L[i] <= R[j])
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else 
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 

        while (i < n1)
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 

        while (j < n2)
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
	}

}
