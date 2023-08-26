//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int left=0;
        int right=0;
        int maxLen=-1;
        int cnt=0;
        int[] v=new int[26];
        Arrays.fill(v,100000);
        while (right<s.length())
        {
            char ch=s.charAt(right);
            if (v[ch-'a']==100000)
                cnt++;
            v[ch-'a']=right;
            if (cnt>k)
            {
                int index=100000;
                char curr='a';
                for (int i=0;i<26;i++)
                {
                    if (v[i]<index)
                    {
                        index=v[i];
                        curr=(char)('a'+i);
                    }
                }
                left=index+1;
                v[curr-'a']=100000;
                cnt--;
            }
            if (cnt==k)
                maxLen=Math.max(maxLen,right-left+1);
            right++;
            // System.out.println(map+" "+maxLen);
        }
        return maxLen;
    }
}