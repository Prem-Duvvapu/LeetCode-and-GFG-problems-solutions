//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxOnes(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int maxOnes(int a[], int n) {
        int cnt=0;
        for (int i=0;i<n;i++)
        {
            if (a[i]==1)
            {
                cnt++;
                a[i]=-1;
            }
            else
                a[i]=1;
        }
        
        //Kadane's algorithm
        int maxSum=0;
        int currSum=0;
        for (int val: a)
        {
            currSum+=val;
            
            if (currSum>maxSum)
                maxSum=currSum;
                
            if (currSum<0)
                currSum=0;
        }
        
        return cnt+maxSum;
    }
}
