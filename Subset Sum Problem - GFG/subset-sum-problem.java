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
        boolean[] prev=new boolean[target+1];
        boolean[] curr=new boolean[target+1];
        
        prev[0]=true;
        curr[0]=true;
        
        if (a[0]<=target)
            prev[a[0]]=true;
            
        for (int i=1;i<N;i++)
        {
            for (int j=1;j<=target;j++)
            {
                boolean notTake=prev[j];
                boolean take=false;
                if (j>=a[i])
                    take=prev[j-a[i]];
                    
                curr[j]=(take || notTake);
            }
            System.arraycopy(curr,0,prev,0,target+1);
        }
        
        return prev[target];
    }
}