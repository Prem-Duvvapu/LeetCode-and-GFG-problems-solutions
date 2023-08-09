//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isPrime(int n)
    {
         int s=(int)Math.sqrt((double)n);
         for (int i=2;i<s+1;i++)
            if (n%i==0)
                return false;
        return true;
    }
    
    static long largestPrimeFactor(int N) {
        long res=0;
        int sq=(int)Math.sqrt((double)N);
        for (int i=sq+1;i>0;i--)
        {
            if (N%i==0)
            {
                if (isPrime(i))
                    res=Math.max(res,i);
                if (isPrime(N/i))
                    res=Math.max(res,N/i);
            }
        }
        
        return res;
    }
}