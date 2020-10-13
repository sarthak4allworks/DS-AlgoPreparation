package LeetCode.Octber2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3486/

public class RotateList 
{
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			ListNode head = null;
			int n = s.nextInt();
			while(n-->0)
			{
				head = InsertNodeAtEndInList(head, s.nextInt());
			}
			PrintList(head);
			System.out.println();
			head = rotateRight(head, s.nextInt());
			PrintList(head);
			System.out.println();
		}
		s.close();
	}

	private static ListNode rotateRight(ListNode head, int k) 
	{
		if(head == null)
		{
			return null;
		}
		if(head.next == null)
		{
			return head;
		}
		int len = LengthOfList(head);
		int noOfRotations = k%len;
		ListNode prev = null;
		ListNode temp = head;
		for(int i=0 ; i<len-noOfRotations ; i++)
		{
			prev = temp;
			temp = temp.next;
		}
		temp = ReverseList(temp);
		PrintList(head);
		System.out.println();
		while(temp != null)
		{
			prev.next = temp.next;
			temp.next = head;
			head = temp;
			temp = prev.next;
		}
		return head;
	}

	private static ListNode ReverseList(ListNode root) 
	{
		if(root == null)
		{
			return null;
		}
		if(root.next == null)
		{
			return root;
		}
		ListNode temp = null, nextNode = null;
		while(root != null)
		{
			nextNode = root.next;
			root.next = temp;
			temp = root;
			root = nextNode;
		}
		return temp;
	}

	private static int LengthOfList(ListNode head)
	{
		int len = 0;
		while(head!=null)
		{
			len++;
			head = head.next;
		}
		return len;
	}

	public static void PrintList(ListNode head)
	{
		if(head != null)
		{
			System.out.print(head.val+" ");
			PrintList(head.next);
		}
	}

	public static ListNode InsertNodeAtEndInList(ListNode head, int k) 
	{
		if(head == null)
		{
			head = new ListNode(k);
			return head;
		}
		ListNode temp = head;
		while(temp.next != null)
		{
			temp = temp.next;
		}
		temp.next = new ListNode(k);
		return head;
	}
}
