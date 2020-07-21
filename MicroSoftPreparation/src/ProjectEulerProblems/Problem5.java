package ProjectEulerProblems;

// https://projecteuler.net/problem=5
public class Problem5 
{
	public static void main(String[] args) 
	{
		// Method-1
		System.out.println("Start...");
		for(int i=20 ; i<Integer.MAX_VALUE ; i+=20)
		{
			boolean flag = true;
			for(int j=19 ; j>=2 ; j--)
			{
				if(i%j != 0)
				{
					flag = false;
					break;
				}
			}
			if(flag == true)
			{
				System.out.println(i);
				break;
			}
		}
		
		// Method-2
		//Use prime factorization of the given numbers
	}

}