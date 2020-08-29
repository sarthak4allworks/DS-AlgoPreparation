package ProjectEulerProblems;

import java.util.Scanner;

//https://projecteuler.net/problem=11
public class Problem11
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int[][] a = new int[20][20];
		for(int i=0 ; i<20 ; i++)
		{
			for(int j=0 ; j<20 ; j++)
			{
				String str = s.next();
				a[i][j] = Integer.valueOf(str);
			}
		}
		int mul = Integer.MIN_VALUE;
		// check horizontally
		for(int i=0 ; i<20 ; i++)
		{
			for(int j=0 ; j<17 ; j++)
			{
				int multi1 = a[i][j]*a[i][j+1]*a[i][j+2]*a[i][j+3];
				if(multi1 > mul)
				{
					mul = multi1;
				}
			}
		}
		// check vertically
		for(int i=0 ; i<17 ; i++)
		{
			for(int j=0 ; j<20 ; j++)
			{
				int multi1 = a[i][j]*a[i+1][j]*a[i+2][j]*a[i+3][j];
				if(multi1 > mul)
				{
					mul = multi1;
				}
			}
		}
		// check diagonally
		for(int i=0 ; i<20 ; i++)
		{
			for(int j=0 ; j<20 ; j++)
			{
				// check right bottom diagonal possible
				if((i+3<20) && (j+3<20))
				{
					int multi1 = a[i][j]*a[i+1][j+1]*a[i+2][j+2]*a[i+3][j+3];
					if(multi1>mul)
					{
						mul = multi1;
					}
				}
				// check left bottom diagonal possible
				if((i+3<20) && (j-3>=0))
				{
					int multi1 = a[i][j]*a[i+1][j-1]*a[i+2][j-2]*a[i+3][j-3];
					if(multi1>mul)
					{
						mul = multi1;
					}
				}
			}
		}
		
//		for(int i=0 ; i<17 ; i++)
//		{
//			for(int j=0 ; j<17 ; j++)
//			{
//				int multi1 = a[i][j]*a[i][j+1]*a[i][j+2]*a[i][j+3];
//				int multi2 = a[i][j]*a[i+1][j]*a[i+2][j]*a[i+3][j];
//				int multi3 = a[i][j]*a[i+1][j+1]*a[i+2][j+2]*a[i+3][j+3];
//				int result = 0;
//				if(multi1 > multi2)
//				{
//					if(multi1 > multi3)
//					{
//						result = multi1;
//					}
//					else
//					{
//						result = multi2 > multi3 ? multi2 : multi3;
//					}
//				}
//				else
//				{
//					if(multi2 > multi3)
//					{
//						result = multi2;
//					}
//					else
//					{
//						result = multi3 > multi1 ? multi3 : multi1;
//					}
//				}
//				if(result > mul)
//				{
//					mul = result;
//				}
//				if(j>2)
//				{
//					int multi4 = a[i][j]*a[i+1][j-1]*a[i+2][j-2]*a[i+3][j-1];
//					if(multi4>mul)
//					{
//						mul = multi4;
//					}
//				}
//				for(int k=17 ; k<20 ; k++)
//				{
//					int multi4 = a[i][k]*a[i+1][k-1]*a[i+2][k-2]*a[i+3][k-3];
//					if(multi4>mul)
//					{
//						mul = multi4;
//					}
//				}
//			}
//		}
		System.out.println(mul);
		s.close();
	}

}
