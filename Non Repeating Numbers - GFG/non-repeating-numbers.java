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
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

//a^0=a
//a^a=0

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int value=0;
        for (int val: nums)
            value^=val; //finally remains xor of two distint elements (a^b)
        
        value=(value&(value-1))^value;//only right most set bit remains
        int a=0;
        int b=0;
        for (int val:nums)
        {
            if ((value&val)!=0) //value position bit is set
                a^=val;
            else
                b^=val;
        }
        
        int[] res={a,b};
        Arrays.sort(res);
        return res;
        
    }
}