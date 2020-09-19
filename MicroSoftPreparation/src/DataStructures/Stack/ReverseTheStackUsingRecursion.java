package DataStructures.Stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseTheStackUsingRecursion 
{
	static Stack<Integer> stack = new Stack<>();;
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			for(int i=0; i<n ; i++)
			{
				stack.push(s.nextInt());
			}
			System.out.print("Before reverse: ");
			Stack<Integer> tempStack = new Stack<>();
			tempStack.addAll(stack);
			while(!tempStack.isEmpty())
			{
				System.out.print(tempStack.pop()+" ");
			}
			System.out.println();
			ReverseStack();
			System.out.print("Afetr reverse: ");
			while(!stack.isEmpty())
			{
				System.out.print(stack.pop()+" ");
			}
			System.out.println();
		}
		s.close();
	}

	private static void ReverseStack()
	{
		if(stack.isEmpty())
		{
			return;
		}
		int num = stack.pop();
		ReverseStack();
		InsertIntoBottom(num);
	}

	private static void InsertIntoBottom(int num) 
	{
		if(stack.isEmpty())
		{
			stack.push(num);
		}
		else
		{
			int number = stack.pop();
			InsertIntoBottom(num);
			stack.push(number);
		}
	}
}
