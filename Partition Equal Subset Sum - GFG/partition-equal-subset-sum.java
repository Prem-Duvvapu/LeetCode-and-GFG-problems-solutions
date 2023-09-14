//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int n, int arr[])
    {
        int totalSum=0;
        for (int val: arr)
            totalSum+=val;
            
        if (totalSum%2==1)
            return 0;
            
        if (solve(0,totalSum/2,arr))
            return 1;
            
        return 0;
    }
    
    static boolean solve(int pos,int target,int[] arr)
    {
        if (target==0)
            return true;
            
        if (pos==arr.length || target<0)
            return false;
        
        //pick
        if (solve(pos+1,target-arr[pos],arr))
            return true;
            
        //not pick
        if (solve(pos+1,target,arr))
            return true;
            
        return false;
    }
}