package DataStructures.Tree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

// DS book problem 31
public class VerticleSumOfBinaryTree 
{
	static Map<Integer, Integer> map = new LinkedHashMap<>();
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s= new Scanner(System.in);
		TreeNode root = null;
		System.out.print("Insert number of nodes in a tree: ");
		int noOfNodes = s.nextInt();
		for(int i=0 ; i<noOfNodes ; i++)
		{
			root = InsertingAnElementInBinaryTree.InsertInBinaryTree(root, s.nextInt());
		}
		BasicADTOfBinaryTree.printLevelOrderRecursive(root);
		System.out.println();
		VerticleSum(root, 0);
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) // key == 0 means root
		{
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		s.close();
	}
	
	private static void VerticleSum(TreeNode root, int i) 
	{
		if(root == null)
		{
			return;
		}
		VerticleSum(root.left, i-1);
		if(map.containsKey(i))
		{
			int val = map.get(i);
			map.put(i, val+root.data);
		}
		else
		{
			map.put(i, root.data);
		}
		VerticleSum(root.right, i+1);
	}
}
