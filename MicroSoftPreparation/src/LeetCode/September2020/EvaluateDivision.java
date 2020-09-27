package LeetCode.September2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3474/
class Edge 
{
    public String e;
    public Double v;

    public Edge(String e, Double v) 
    {
        this.e = e;
        this.v = v;
    }
}

public class EvaluateDivision 
{	
	public static void main(String[] args) 
	{
		System.out.println("Start...");
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			List<List<String>> equations = new ArrayList<>();
			int noOfEquations = s.nextInt();
			for(int i=0 ; i<noOfEquations ; i++)
			{
				List<String> equation = new ArrayList<>();
				equation.add(s.next());
				equation.add(s.next());
				equations.add(equation);
			}
			double[] values = new double[noOfEquations];
			for(int i=0 ; i<noOfEquations ; i++)
			{
				values[i] = s.nextDouble();
			}
			List<List<String>> queries = new ArrayList<>();
			int noOfQueries = s.nextInt();
			for(int i=0 ; i<noOfQueries ; i++)
			{
				List<String> query = new ArrayList<>();
				query.add(s.next());
				query.add(s.next());
				queries.add(query);
			}
			double[] results = calcEquation(equations, values, queries);
			for(double result: results)
			{
				System.out.print(result+" ");
			}
			System.out.println();
		}
		s.close();
	}

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) 
    {
        Map<String, List<Edge>> g = new HashMap<>();
        for (int i = 0; i < equations.size(); i++)
        {
            List<String> eq = equations.get(i);
            addEdge(g, eq.get(0), eq.get(1), values[i]);
            addEdge(g, eq.get(1), eq.get(0), 1 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) 
        {
            List<String> q = queries.get(i);
            res[i] = dfs(g, new HashSet<>(), q.get(0), q.get(1));
        }
        return res;
    }

    private static double dfs(Map<String, List<Edge>> g, Set<String> v, String s, String e) 
    {
        if (v.contains(s)) 
        {
            return -1;
        }
        if (!g.containsKey(s) || !g.containsKey(e)) 
        {
            return -1;
        }
        if (s.equals(e))
        {
            return 1;
        }
        v.add(s);

        for (Edge edge : g.get(s)) 
        {
            if (edge.e.equals(e)) 
            {
                return edge.v;
            } 
            else 
            {
                double d = dfs(g, v, edge.e, e);
                if (d != -1) 
                {
                    return edge.v * d;
                }
            }
        }
        return -1;
    }

    private static void addEdge(Map<String, List<Edge>> g, String s, String e, double v)
    {
        if (!g.containsKey(s)) 
        {
            g.put(s, new ArrayList<>());
        }
        g.get(s).add(new Edge(e, v));
    }
}
