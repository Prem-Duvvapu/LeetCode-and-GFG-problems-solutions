//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();
            
            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}
// } Driver Code Ends

//Prefix Sum
class Solution {
    public static int equilibriumPoint(long arr[], int n) {

        long totalSum=0;
        long currSum=0;
        for (long val: arr)
            totalSum+=val;
            
        for (int i=0;i<n;i++)
        {
            totalSum-=arr[i];
            
            if (totalSum==currSum)
                return i+1;
                
            currSum+=arr[i];
        }
        
        return -1;
    }
}
