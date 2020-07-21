package ProjectEulerProblems;

//https://projecteuler.net/problem=9
public class Problem9 
{
	public static void main(String[] args) 
	{
		int mul = 1;
		boolean flag = false;
		for(int i=1 ; i<1000 ; i++)
		{
			for(int j=i+1 ; j<1000 ; j++)
			{
				for(int k=1000-(i+j) ; k<1000 ; k++)
				{
					if(i+j+k == 1000 && (i*i+j*j == k*k))
					{
						System.out.println("i= "+i+ ", j= "+ j+", k= "+k);
						mul = i*j*k;
						flag = true;
						break;
					}
				}
				if(flag) break;
			}
			if(flag) break;
		}
		System.out.println(mul);
	}

}
