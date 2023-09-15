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
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        int n=nums.length;
        int[] frontDp=new int[n];
        int[] revDp=new int[n];
        for (int i=0;i<n;i++)
        {
            frontDp[i]=1;
            revDp[i]=1;
        }
        
        LongestIncreasingSubsequence(nums,n,frontDp);
        reverseArray(nums,0,n-1);
        LongestIncreasingSubsequence(nums,n,revDp);
        reverseArray(revDp,0,n-1);
        
        int ans=0;
        for (int i=0;i<n;i++)
            ans=Math.max(ans,frontDp[i]+revDp[i]-1);
            
        return ans;
    }
    
    private int LongestIncreasingSubsequence(int[] nums,int n,int[] dp)
    {
        int maxVal=1;
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<i;j++)
            {
                if (nums[j]<nums[i] && dp[j]+1>dp[i])
                    dp[i]=dp[j]+1;
            }
            maxVal=Math.max(maxVal,dp[i]);
        }
        
        return maxVal;
    }
    
    private void reverseArray(int[] nums,int left,int right)
    {
        while (left<=right)
        {
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}