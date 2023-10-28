//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.is_bleak(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int is_bleak(int n)
    {
        for (int i=n;i>=Math.max(1,n-32);i--)
        {
            if (i+countSetBits(i)==n)
                return 0;
        }
        
        return 1;
    }
    
    private int countSetBits(int x)
    {
        int cnt=0;
        
        while (x>0)
        {
            cnt+=(x&1);
            x=x>>>1;
        }
        
        return cnt;
    }
}