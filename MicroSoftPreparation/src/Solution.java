import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1. Generate all permutations, I generated string permutations instead of array which is very easier to code in Java because all of the number in our array is single digit.
// => Create string from all element of array s.
// => Now call permutations method why passing s and temp = "", and the list reference where we will keep all the permutations.
// => check when string s became empty we will add the temp which is one of our permutations into list.
// => iterate all the character in the s and remove i one from s and append into temp and call recursively.
//2. Now iterate permutation list and take first two number as HH and second two as MM compare with 24 and 60 for valid HH and MM if so then check if new time is larger then the previous then update.
//3. return res.


public class Solution 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int[] a = new int[4];
			for(int i = 0 ; i<4 ; i++)
			{
				a[i] = s.nextInt();
			}
			System.out.println(largestTimeFromDigits(a));
		}
		s.close();
	}
	
	public static String largestTimeFromDigits(int[] A) 
	{
		List<String> permutations = permutations(A);
		String res = "";
		for (String p : permutations) 
		{
			String HH = p.substring(0, 2);
			String MM = p.substring(2);
			if (HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && res.compareTo(HH + ":" + MM) < 0)
			{
				res = HH + ":" + MM;
			}
		}
		return res;
	}

	// Method for converting the integer array into string and calling the permutation method and storing it into the array list
	private static List<String> permutations(int[] A) 
	{
		String s = "";
		for (int a : A)
		{
			s += a;
		}
		List<String> list = new ArrayList<>();
		permutations(s, "", list);
		return list;
	}

	// Method for generating all the permutations of the string
	private static void permutations(String s, String temp, List<String> list) 
	{
		if (s.isEmpty())
		{
			list.add(temp);
		}
		for (int i = 0; i < s.length(); i++) 
		{
			permutations(s.substring(0, i) + s.substring(i + 1), temp + s.charAt(i), list);
		}
	}
}
