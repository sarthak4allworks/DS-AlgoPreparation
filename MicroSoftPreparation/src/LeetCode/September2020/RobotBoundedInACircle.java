package LeetCode.September2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3463/
public class RobotBoundedInACircle
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			String instructions = s.next();
			System.out.println(isRobotBounded(instructions));
		}
		s.close();
	}

	private static boolean isRobotBounded(String instructions) 
	{
		boolean res = true;
		char direction = 'N';
		int[] position = {0, 0};
		for(char ch: instructions.toCharArray())
		{
			if(ch == 'L')
			{
				if(direction == 'N')
				{
					direction = 'W';
				}
				else if(direction == 'S')
				{
					direction = 'E';
				}
				else if(direction == 'E')
				{
					direction = 'N';
				}
				else
				{
					direction = 'S';
				}
			}
			else if(ch == 'R')
			{
				if(direction == 'N')
				{
					direction = 'E';
				}
				else if(direction == 'S')
				{
					direction = 'W';
				}
				else if(direction == 'E')
				{
					direction = 'S';
				}
				else
				{
					direction = 'N';
				}
			}
			else
			{
				if(direction == 'N')
				{
					position[1]++;
				}
				else if(direction == 'S')
				{
					position[1]--;
				}
				else if(direction == 'E')
				{
					position[0]++;
				}
				else
				{
					position[0]--;
				}
			}
		}
		System.out.println(direction+" x="+ position[0]+" ,y="+position[1]);
		if(direction == 'N' && (position[0] != 0 || position[1] != 0))
		{
			res = false;
		}
		return res;
	}
}
