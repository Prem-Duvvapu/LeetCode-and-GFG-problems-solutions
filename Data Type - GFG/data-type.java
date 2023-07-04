//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.dataTypeSize(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int dataTypeSize(String str) {
        // code here
        int res=0;
        switch (str)
        {
            case "Character":
                res=1;
                break;
            case "Integer":
                res=4;
                break;
            case "Long":
                res=8;
                break;
            case "Float":
                res=4;
                break;
            case "Double":
                res=8;
        }
        return res;
    }
}