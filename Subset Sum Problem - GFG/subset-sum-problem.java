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


    static Boolean isSubsetSum(int N, int a[], int target){
        boolean[][] dp=new boolean[N][target+1];
        
        //Base Case
        for (int i=0;i<N;i++)
            dp[i][0]=true;
            
        if (a[0]<=target)
            dp[0][a[0]]=true;
        
        for (int i=1;i<N;i++)
        {
            for (int j=1;j<=target;j++)
            {
                boolean notTake=dp[i-1][j];
                boolean take=false;
                if (j>=a[i])
                    take=dp[i-1][j-a[i]];
                    
                dp[i][j]=(take || notTake);
            }
        }
        
        return dp[N-1][target];
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