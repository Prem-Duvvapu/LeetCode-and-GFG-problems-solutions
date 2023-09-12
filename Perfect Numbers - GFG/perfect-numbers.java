//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isPerfectNumber(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int isPerfectNumber(long n) {
        long sum=1;
        for (int i=2;i<=(int)Math.sqrt(n);i++)
        {
            if (n%i==0)
            {
                sum+=i;
                if (n!=n/i)
                {
                    sum+=n/i;
                }
            }
        }
                
        if (n!=1 && sum==n)
            return 1;
            
        return 0;
    }
};