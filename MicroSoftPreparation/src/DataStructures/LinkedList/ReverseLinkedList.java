package DataStructures.LinkedList;

import java.util.Scanner;

class ListNode
{
	int data;
	ListNode next;
}

public class ReverseLinkedList 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		System.out.println("Insert the length of link list...");
		Scanner s = new Scanner(System.in);
		int len = s.nextInt();
		ListNode head = CreateLinkList(len);
		PrintLinkList(head);
		head = ReverseLinkList(head);
		PrintLinkList(head);
		s.close();
	}

	private static ListNode ReverseLinkList(ListNode head) 
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		else
		{
			ListNode temp = null, nextNode = null;
			while(head != null)
			{
				nextNode = head.next;
				head.next = temp;
				temp = head;
				head = nextNode;
			}
			return temp;
		}
	}

	private static void PrintLinkList(ListNode head) 
	{
		if(head == null)
		{
			System.out.println("Link list is empty");
		}
		else
		{
			while(head != null)
			{
				if(head.next!=null)
				{
					System.out.print(head.data+" -> ");
				}
				else
				{
					System.out.println(head.data +" -> NULL");
				}
				head = head.next;
			}
		}
	}

	private static ListNode CreateLinkList(int len) 
	{
		ListNode head = null;
		for(int i=1 ; i<=len ; i++)
		{
			ListNode temp = new ListNode();
			temp.data = i;
			temp.next = null;
			if(head == null)
			{
				head = temp;
			}
			else
			{
				ListNode temp2 = head;
				while(temp2.next != null)
				{
					temp2 = temp2.next;
				}
				temp2.next = temp;
			}
		}
		return head;
	}
}
