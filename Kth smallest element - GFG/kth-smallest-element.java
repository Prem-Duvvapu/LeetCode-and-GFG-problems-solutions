//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        Comparator<Integer> com=new Comparator<>()
        {
            public int compare(Integer a,Integer b)
            {
                if (a<b)
                    return 1;
                else
                    return -1;
            }
        };
        
        PriorityQueue<Integer> q=new PriorityQueue<>(com); //contains largest element at peek
        for (int val: arr)
        {
            q.add(val);
            if (q.size()>k)
                q.poll();
        }
        
        return q.peek();
    } 
}
