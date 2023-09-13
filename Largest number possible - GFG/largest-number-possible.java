//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int n, int s){
        StringBuilder sb=new StringBuilder();
        int q=s/9;
        int rem=s%9;
        
        for (int i=0;i<q;i++)
            sb.append('9');
        if (rem>0)
            sb.append(rem);
            
        if ((s==0 && n>1) || sb.length()>n)
            return "-1";
            
        while (sb.length()<n)
            sb.append('0');
            
        return sb.toString();
    }
}