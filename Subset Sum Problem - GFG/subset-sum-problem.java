//{ Driver Code Starts
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
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int target){
        int[][] dp=new int[N][target+1];
        for (int i=0;i<N;i++)
            for (int j=0;j<=target;j++)
                dp[i][j]=-1;
        return solve(N-1,target,arr,dp);
    }
    
    static Boolean solve(int index,int target,int[] a,int[][] dp)
    {
        if (target==0)
            return true;
            
        if (index==0)
            return (a[0]==target);
            
        if (dp[index][target]!=-1)
            return (dp[index][target]==1);
            
        Boolean notTake=solve(index-1,target,a,dp);
        Boolean take=false;
        if (target>=a[index])
            take=solve(index-1,target-a[index],a,dp);
            
        if (take || notTake)
            dp[index][target]=1;
        else
            dp[index][target]=0;
            
        return (take || notTake);
    }
}