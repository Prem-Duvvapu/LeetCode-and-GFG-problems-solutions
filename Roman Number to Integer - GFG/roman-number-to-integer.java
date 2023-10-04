//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    Map<Character,Integer> map;
    
    Solution()
    {
        map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }
    
    public int romanToDecimal(String s) {
        int n=s.length();
        char prevChar=s.charAt(n-1);
        int ans=map.get(prevChar);
        
        for (int i=n-2;i>=0;i--)
        {
            char currChar=s.charAt(i);
            
            if (map.get(currChar)>=map.get(prevChar))
                ans+=map.get(currChar);
            else
                ans-=map.get(currChar);
                
            prevChar=currChar;
        }
        
        return ans;
    }
}