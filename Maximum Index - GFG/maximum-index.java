//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends



class Solution {

    int maxIndexDiff(int a[], int n) {
        // code here
        int res=0;
        
        int[] maxFromLeft=new int[n];
        int[] minFromRight=new int[n];
        
        int maxVal=a[n-1];
        int minVal=a[0];
        
        for (int i=n-1;i>=0;i--)
        {
            if (a[i]>maxVal)
                maxVal=a[i];
                
            maxFromLeft[i]=maxVal;
        }
        
        for (int i=0;i<n;i++)
        {
            if (a[i]<minVal)
                minVal=a[i];
                
            minFromRight[i]=minVal;
        }
        
        int i=0;
        int j=0;
        
        while (j<n && i<n)
        {
            if (minFromRight[i]<=maxFromLeft[j])
            {
                res=Math.max(j-i,res);
                j++;
            }
            else
            {
                i++;
            }
            
        }
        
        return res;
    }
}