package LeetCode;

import java.util.Scanner;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedList 
{
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		SingleLinkListNode root1 = null, root2 = null;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter nodes in first sorted linked list: ");
		int n1 = s.nextInt();
		for(int i=0 ; i<n1 ; i++)
		{
			root1 = InsertAtEndOfLinkedList(root1, s.nextInt());
		}
		PrintSingleLinkList(root1);
		System.out.println();
		System.out.print("Enter nodes in second sorted linked list: ");
		int n2 = s.nextInt();
		for(int i=0 ; i<n2 ; i++)
		{
			root2 = InsertAtEndOfLinkedList(root2, s.nextInt());
		}
		PrintSingleLinkList(root2);
		System.out.println();
		root1 = MergeTwoSortedLinkList(root1, root2);
		System.out.print("Merged sorted link list: ");
		PrintSingleLinkList(root1);
		System.out.println();
		s.close();
	}

	private static SingleLinkListNode MergeTwoSortedLinkList(SingleLinkListNode root1, SingleLinkListNode root2)
	{
		if(root1 == null && root2 == null)
		{
			return null;
		}
		SingleLinkListNode temp = null;
		SingleLinkListNode temp1 = root1;
		SingleLinkListNode temp2 = root2;
		while(temp1 != null && temp2 != null)
		{
			if(temp1.data < temp2.data)
			{
				temp = InsertAtEndOfLinkedList(temp, temp1.data);
				temp1 = temp1.next;
			}
			else
			{
				temp = InsertAtEndOfLinkedList(temp, temp2.data);
				temp2 = temp2.next;
			}
		}
		if(temp1 != null)
		{
			if(temp == null)
			{
				temp = temp1;
			}
			else
			{
				SingleLinkListNode temp3 = temp;
				while(temp3.next != null)
				{
					temp3 = temp3.next;
				}
				temp3.next = temp1;
			}
		}
		if(temp2 != null)
		{
			if(temp == null)
			{
				temp = temp2;
			}
			else
			{
				SingleLinkListNode temp3 = temp;
				while(temp3.next != null)
				{
					temp3 = temp3.next;
				}
				temp3.next = temp2;
			}
		}
		return temp;
	}

	public static void PrintSingleLinkList(SingleLinkListNode root) 
	{
		if(root == null)
		{
			return;
		}
		else
		{
			System.out.print(root.data+" ");
			PrintSingleLinkList(root.next);
		}
	}

	public static SingleLinkListNode InsertAtEndOfLinkedList(SingleLinkListNode root, int nextInt) 
	{
		if(root == null)
		{
			root = new SingleLinkListNode(nextInt);
		}
		else
		{
			SingleLinkListNode temp = root;
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = new SingleLinkListNode(nextInt);
		}
		return root;
	}
}
