package LeetCode.Octber2020;

import java.util.Scanner;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3493/
public class SortList 
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
				head = RotateList.InsertNodeAtEndInList(head, s.nextInt());
			}
			head = sortList(head);
			RotateList.PrintList(head);
		}
		s.close();
	}

	private static ListNode sortList(ListNode head) 
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		ListNode midNode = head;
		ListNode startPtr = head;
		ListNode endPtr = head;
		while(endPtr.next!=null && endPtr.next.next != null)
		{
			startPtr = startPtr.next;
			endPtr = endPtr.next.next;
		}
		midNode = startPtr.next;
		startPtr.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(midNode);
		return merge(left, right);
	}

	private static ListNode merge(ListNode left, ListNode right)
	{
		ListNode head = new ListNode(Integer.MIN_VALUE);
		ListNode ptr = head;
		while(left!=null && right!=null)
		{
			if(left.val < right.val)
			{
				ptr.next = left;
				left = left.next;
			}
			else
			{
				ptr.next = right;
				right = right.next;
			}
			ptr = ptr.next;
		}
		if(left != null) ptr.next = left;
		if(right != null) ptr.next = right;
		return head.next;
	}
}
