package ProjectEulerProblems;

// https://projecteuler.net/problem=7
public class Problem7 
{
	public static void main(String[] args) 
	{
		boolean[] arr = new boolean[100000000];
		for(int i=0 ; i<100000000 ; i++)
		{
			arr[i] = true;
		}
		arr[0] = false;
		arr[1] = false;
		int count = 0;
		int number = 2;
		while(count != 10001)
		{
			if(arr[number] == true)
			{
				count++;
				for(int i=2*number ; i<100000000 ; i+=number)
				{
					arr[i] = false;
				}
			}
			number++;
			if(number >= 100000000)
			{
				number--;
				break;
			}
		}
		int c = 0;
		for(int i=0 ; i<100000000 ; i++)
		{
			if(arr[i])
			{
				c++;
			}
			if(c == 10001)
			{
				number = i;
				break;
			}
		}
		System.out.println(number);
	}
}
