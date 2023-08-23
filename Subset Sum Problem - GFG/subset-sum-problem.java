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


    static Boolean isSubsetSum(int N, int arr[], int sum){
        int[][] dp=new int[N][sum+1];
        for (int i=0;i<N;i++)
            for (int j=0;j<=sum;j++)
                dp[i][j]=-1;
            
        if ((solve(0,0,N,arr,sum,dp)==1))
            return true;
            
        return false;
    }
    
    static int solve(int pos,int currSum,int n,int[] a,int givenSum,int[][] dp)
    {
        if (currSum==givenSum)
            return 1;
            
        if (pos==n || currSum>givenSum)
            return 0;
            
        if (dp[pos][currSum]!=-1)
            return dp[pos][currSum];
        
        if (solve(pos+1,currSum+a[pos],n,a,givenSum,dp)==1)
            return dp[pos][currSum]=1;
            
        if (solve(pos+1,currSum,n,a,givenSum,dp)==1)
            return dp[pos][currSum]=1;
            
        return dp[pos][currSum]=0;
    }
}