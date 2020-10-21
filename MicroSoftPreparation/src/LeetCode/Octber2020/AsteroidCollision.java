package LeetCode.Octber2020;

import java.util.Scanner;
import java.util.Stack;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3502/
public class AsteroidCollision 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[] asteroids = new int[n];
			for(int i=0 ; i<n ; i++)
			{
				asteroids[i] = s.nextInt();
			}
			int[] res = asteroidCollision(asteroids);
			for(int val: res)
			{
				System.out.print(val+" ");
			}
			System.out.println();
		}
		s.close();
	}

	private static int[] asteroidCollision(int[] asteroids) 
	{
		if (asteroids.length <= 1) return asteroids;  
        Stack<Integer> stack = new Stack<>();
        for (int asteriod : asteroids)
        {
            if (asteriod > 0) 
            {
                stack.push(asteriod);
            } 
            else
            {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteriod))  
                {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) 
                {
                    stack.push(asteriod);
                }
                else if (stack.peek() == Math.abs(asteriod)) 
                {
                    stack.pop();
                }
            }
        }
        int[] output = new int[stack.size()];
        for (int i = output.length - 1; i >= 0; i--)
        {
            output[i] = stack.pop();
        }
        return output;
	}
}
