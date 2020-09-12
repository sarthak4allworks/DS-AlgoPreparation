package LeetCode;

import java.util.Scanner;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			String str = s.next();
			System.out.println(isValid(str));
		}
		s.close();
	}

	private static boolean isValid(String s) 
	{
		Stack<Character> stack = new Stack<>();
		for(int i=0 ; i<s.length() ; i++)
		{
			if(stack.isEmpty())
			{
				stack.push(s.charAt(i));
			}
			else
			{
				char ch = s.charAt(i);
				char sch = stack.peek();
				if(ch == '}' && sch == '{' || ch == ')' && sch == '(' || ch == ']' && sch == '[')
				{
					stack.pop();
				}
				else
				{
					stack.push(ch);
				}
			}
		}
		return stack.isEmpty();
	}
}
