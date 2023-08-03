//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
     
      Solution obj = new Solution();
      boolean ans = obj.checkSubsequenceSum(n,a,k);
      System.out.println(ans?"Yes":"No");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static boolean solve(int pos,int[] arr,int k,int sum)
    {
        if (sum>k)
            return false;
         
        // if (sum==k)  
        //     return true;
            
        if (pos==arr.length)
        {
            if (sum==k)
                return true;
            else
                return false;
        }
        
        //pick
        sum+=arr[pos];
        if (solve(pos+1,arr,k,sum))
            return true;
        sum-=arr[pos];
        
        //not pick
        if (solve(pos+1,arr,k,sum))
            return true;
            
        return false;
    }
    
  public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        return solve(0,arr,K,0);
  }
}
     