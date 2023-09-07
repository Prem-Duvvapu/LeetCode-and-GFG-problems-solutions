//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java


//BFS
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        int mod=(int)(1e5);
        int[] opsCnt=new int[mod];
        for (int i=0;i<mod;i++)
            opsCnt[i]=(int)(1e9);
            
        Queue<Integer> q=new ArrayDeque<>();
        q.add(start);
        opsCnt[start]=0;
        
        if (start==end)
            return 0;
        
        while (!q.isEmpty())
        {
            int front=q.poll();
            
            for (int i=0;i<arr.length;i++)
            {
                int currVal=(front*arr[i])%mod;
                    
                if (opsCnt[currVal]>opsCnt[front]+1)
                {
                    opsCnt[currVal]=opsCnt[front]+1;
                    
                    if (currVal==end)
                        return opsCnt[currVal];
                
                    q.add(currVal);
                }
            }
        }
        
        return -1;
    }
}
