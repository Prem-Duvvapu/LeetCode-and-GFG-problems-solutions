//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long substrCount (String s, int k)//returns no. of substrings of size=k
    {
        return solve(s,k)-solve(s,k-1);
    }
    
    private long solve(String s,int k)//returns no. of substrings of size<=k
    {
        int n=s.length();
        long ans=0;
        int left=0;
        int[] cnt=new int[26];
        int distinctChar=0;
        
        for (int right=0;right<n;right++)
        {
            char ch=s.charAt(right);
            cnt[ch-'a']++;
            
            if (cnt[ch-'a']==1)
                distinctChar++;
                
            while (distinctChar>k)
            {
                char temp=s.charAt(left);
                cnt[temp-'a']--;
                
                if (cnt[temp-'a']==0)
                    distinctChar--;
                    
                left++;
            }
            
            ans+=(right-left+1);
        }
        
        return ans;
    }
}