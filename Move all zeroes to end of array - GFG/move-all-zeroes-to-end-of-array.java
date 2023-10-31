//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr, int n) {
        int i=0;
        int cnt=0;
        
        for (int val: arr)
            if (val==0)
                cnt++;
        
        while (i<n && arr[i]!=0)
            i++;
            
        int j=i;
        while (j<n && arr[j]==0)
            j++;
            
        for (;j<n;j++)
        {
            if (arr[j]>0)
            {
                arr[i]=arr[j];
                i++;
            }
        }
        
        for (int k=n-1;k>=n-cnt;k--)
            arr[k]=0;
    }
}