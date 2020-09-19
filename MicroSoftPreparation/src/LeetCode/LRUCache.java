package LeetCode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

// https://leetcode.com/problems/lru-cache/
public class LRUCache 
{
	int capacity = 0;
	Map<Integer, Integer> map;
	public LRUCache(int capacity)
	{
		this.capacity = capacity;
		map = new LinkedHashMap<>();
	}
	
	public int get(int key)
	{
		if(map.size() == 0 || !map.containsKey(key))
		{
			return -1;
		}
		int val = map.get(key);
		map.remove(key);
		map.put(key, val);
        return val;
    }
    
    public void put(int key, int value)
    {
        if(map.containsKey(key))
        {
        	map.remove(key);
        }
        else
        {
        	if(map.size()>=capacity)
        	{
        		int firstKey = 0;
        		for(Integer i: map.keySet())
        		{
        			firstKey = i;
        			break;
        		}
        		map.remove(firstKey);
        	}
        }
        map.put(key, value);
    }
	
	public static void main(String[] args) 
	{
		System.out.println("Start..");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the capacity of the catche: ");
		int capacity = s.nextInt();
		LRUCache lruCache = new LRUCache(capacity);
		System.out.print("NumberOfQueries to be made: ");
		int query = s.nextInt();
		while(query-->0)
		{
			System.out.print("Insert get and put query: ");
			String str = s.next();
			if(str.equalsIgnoreCase("get"))
			{
				System.out.println("Insert the keys for which you want to get data: ");
				int key = s.nextInt();
				System.out.println(lruCache.get(key));
			}
			else
			{
				System.out.println("Insert key and value pair: ");
				int key = s.nextInt();
				int value = s.nextInt();
				lruCache.put(key, value);
			}
		}
		s.close();
	}
}
