//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out=new PrintWriter(System.out);
        
        //taking testcases
        int t = Integer.parseInt(br.readLine()); 
    	for(int i=0;i<t;i++)
    	{
            String str=br.readLine();
    		
    		//input n and d
    	    int n=Integer.parseInt(str);
    		Stack<Integer> stack=new Stack<>();
    		String str1=br.readLine();
    		String[] starr1=str1.split(" ");
    		//inserting elements in the array
    		for(int j=0;j<n;j++)
    		{
    		    stack.push(Integer.parseInt(starr1[j]));
    		}
    		//calling reverse() function
            Solution.reverse(stack);
            for(int j:stack){
                out.print(j+" ");
            }
            out.println();
         }
         out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static void solve(Stack<Integer> s,Stack<Integer> s2)
    {
        int val=s.pop();
        s2.push(val);
        // System.out.println("fromFirst"+" "+s+" "+s2);
        
        if (s.isEmpty())
            return;
            
        solve(s,s2);
        // System.out.println("fromLast"+" "+s+" "+s2);
    }
    
    static void reverse(Stack<Integer> s)
    {
        Stack<Integer> s2=new Stack<>();
        Stack<Integer> s3=new Stack<>();
        solve(s,s2);
        solve(s2,s3);
        solve(s3,s);
    }
}