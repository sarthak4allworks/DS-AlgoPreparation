package LeetCode.September2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://leetcode.com/explore/featured/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3449/

public class AllElementsIn2BinarySearchTree 
{
	class TreeNode 
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() 
		{
		}
		TreeNode(int val) 
		{
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) 
		{
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		AllElementsIn2BinarySearchTree abst = new AllElementsIn2BinarySearchTree();
		while(t-->0)
		{
			TreeNode root1 = null;
			TreeNode root2 = null;
			int n1 = s.nextInt();
			for(int i=0 ; i<n1 ; i++)
			{
				root1 = abst.InsertNode(root1, s.nextInt());
			}
			int n2 = s.nextInt();
			for(int i=0 ; i<n2 ; i++)
			{
				root2 = abst.InsertNode(root2, s.nextInt());
			}
			printTree(root1);
//			System.out.println();
			printTree(root2);
			System.out.println();
			List<Integer> list = getAllElements(root1, root2);
			//System.out.println(list.size());
			for(Integer i: list)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
		s.close();
	}

	private static List<Integer> getAllElements(TreeNode root1, TreeNode root2) 
	{
		List<Integer> list1 = getInorderList(root1);
		List<Integer> list2 = getInorderList(root2);
		if(list1 == null || list1.size() == 0)
		{
			list1 = new ArrayList<>();
		}
		if(list2 == null || list2.size() == 0)
		{
			list2 = new ArrayList<>();
		}
		list1.addAll(list2);
		int[] a = list1.stream().mapToInt(i->i).toArray();
		mergeSort(a, 0, a.length-1);
		list1.clear();
		for(int i: a)
		{
			list1.add(i);
		}
		return list1;
	}

	private static void mergeSort(int[] a, int i, int j) 
	{
		if(i<j)
		{
			int m = (i+j)/2;
			mergeSort(a, i, m);
			mergeSort(a, m+1, j);
			merge(a, i, m, j);
		}
	}

	private static void merge(int arr[], int l, int m, int r) 
	{
		int n1 = m - l + 1; 
        int n2 = r - m;
        int L[] = new int[n1]; 
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l; 
        while (i < n1 && j < n2)
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else 
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 

        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
	}

	private static List<Integer> getInorderList(TreeNode root) 
	{
		if(root == null)
		{
			return null;
		}
		TreeNode current, pre;
		current = root;
		List<Integer> list = new ArrayList<Integer>();
		while(current!=null)
		{
			if(current.left==null)
			{
				list.add(current.val);
				current = current.right;
			}
			else
			{
				pre = current.left;
				while (pre.right != null && pre.right != current) 
				{
                    pre = pre.right; 
				}
				if (pre.right == null)
				{ 
                    pre.right = current; 
                    current = current.left; 
                }
				else 
				{ 
                    pre.right = null; 
                    list.add(current.val);
                    current = current.right; 
                }
			}
		}
		return list;
	}

	private static void printTree(TreeNode root) 
	{
		if(root!=null)
		{
			printTree(root.left);
			System.out.print(root.val+" ");
			printTree(root.right);
		}
	}

	private TreeNode InsertNode(TreeNode root, int val) 
	{
		if(root == null)
		{
			root = new TreeNode(val, null, null);
			return root;
		}
		if(val < root.val)
		{
			root.left = InsertNode(root.left, val);
		}
		else
		{
			root.right = InsertNode(root.right, val);
		}
		return root;
	}

}
