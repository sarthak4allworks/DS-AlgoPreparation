package ProjectEulerProblems;

import java.util.Scanner;

//https://projecteuler.net/problem=6
public class Problem6 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			long n = s.nextLong();
			long num1 = (n*(n+1))/2;
			long num3 = num1*num1;
			long num2 = (n*(n+1)*(2*n+1))/6;
			System.out.println(num3-num2);
//			int n = s.nextInt();
//			BigInteger num = new BigInteger("1");
//			num = new BigInteger("2").add(BigInteger.valueOf(n).subtract(new BigInteger("1")));
//			num = num.multiply(BigInteger.valueOf(n)).divide(new BigInteger("2"));
//			//num = new BigInteger("500").multiply(new BigInteger("1001"));
//			//System.out.println(num);
//			num = num.multiply(num);
//			//System.out.println(num);
//			BigInteger num1 = new BigInteger("1");
//			for(int i=2 ; i<=n ; i++)
//			{
//				num1 = num1.add(BigInteger.valueOf(i).multiply(BigInteger.valueOf(i)));
//			}
//			//System.out.println(num1);
//			System.out.println(num.subtract(num1));
		}
		s.close();
	}

}
