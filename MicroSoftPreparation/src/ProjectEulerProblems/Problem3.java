package ProjectEulerProblems;

//https://projecteuler.net/problem=3
public class Problem3 
{
	public static void main(String[] args)
	{
		//************ Method1 ***********
		System.out.println("Start...");
		long num = 600851475143L;
		long maxPrime = -1;
		while(num%2 == 0)
		{
			maxPrime = 2;
			num >>= 1;
		}
		
		for(int i=3 ; i*i <= num ; i+=2)
		{
			while(num%i == 0)
			{
				maxPrime = i;
				num /= i;
			}
		}
		if(num > 2)
		{
			maxPrime = num;
		}
		System.out.println(maxPrime);
		//System.out.println(600851475143L/maxPrime);
		
		//************ Method2 ***********
		long Lol = 2L;
        long ux = 600851475143L;
        while (ux > 1) 
        {
//        	System.out.println(Lol);
            while (ux % Lol == 0) 
            {
                System.out.println(" * " + Lol);
                ux = ux / Lol;
            }
            Lol++;
        }
	}
}
