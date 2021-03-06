package ProjectEulerProblems;

// https://projecteuler.net/problem=4
public class Problem4
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		int res = 0;
		for(int i=999 ; i>99 ; i--)
		{
			for(int j=999 ; j>99 && i*j>res ; j--)
			{
				System.out.println("i is "+i +"and j is "+j);
				if(checkPalindrom(i*j))
				{
					res = i*j;
				}
			}
		}
		System.out.println("Result is "+res);
	}

	private static boolean checkPalindrom(int i) 
	{
		String str = String.valueOf(i);
		System.out.println("String is "+str);
		int s = 0;
		int e = str.length()-1;
		boolean flag = true;
		while(s<=e)
		{
			if(str.charAt(s) != str.charAt(e))
			{
				flag = false;
				break;
			}
			s++;
			e--;
		}
		return flag;
	}

}
