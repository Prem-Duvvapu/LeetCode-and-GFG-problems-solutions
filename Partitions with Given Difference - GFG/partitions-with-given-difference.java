//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{
    int mod=(int)(1e9)+7;
    public int countPartitions(int n, int d, int a[]){
        int totalSum=0;
        for (int val: a)
            totalSum+=val;
            
        if ((totalSum-d)<0 || (totalSum-d)%2==1)
            return 0;
            
        int sum=(totalSum-d)/2;
        int[][] dp=new int[n][sum+1];
        
        if (a[0]==0)
            dp[0][0]=2;
        else
            dp[0][0]=1;
            
        if (a[0]!=0 && a[0]<=sum)
            dp[0][a[0]]=1;
            
        for (int i=1;i<n;i++)
        {
            for (int target=0;target<=sum;target++)
            {
                int notPick=dp[i-1][target];
                int pick=0;
                if (a[i]<=target)
                    pick=dp[i-1][target-a[i]];
                    
                dp[i][target]=(pick+notPick)%mod;
            }
        }
        
        return dp[n-1][sum];
    }
}