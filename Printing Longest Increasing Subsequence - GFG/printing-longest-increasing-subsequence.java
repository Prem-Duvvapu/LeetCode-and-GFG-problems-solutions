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
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            ArrayList<Integer>ans=obj.longestIncreasingSubsequence(N, arr);
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]){
        int[] dp=new int[n];
        int maxVal=1;
        for (int i=0;i<n;i++)
            dp[i]=1;
        int[] prevInd=new int[n];
        for (int i=0;i<n;i++)
            prevInd[i]=-1;
        int lastInd=0;
            
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<i;j++)
            {
                if (arr[j]<arr[i] && dp[j]+1>dp[i])
                {
                    dp[i]=dp[j]+1;
                    prevInd[i]=j;
                }
            }
            if (dp[i]>maxVal)
            {
                maxVal=dp[i];
                lastInd=i;
            }
        }
        
        ArrayList<Integer> lis=new ArrayList<>();
        while (lastInd!=-1)
        {
            lis.add(0,arr[lastInd]);
            lastInd=prevInd[lastInd];
        }
        
        return lis;
    }
}
