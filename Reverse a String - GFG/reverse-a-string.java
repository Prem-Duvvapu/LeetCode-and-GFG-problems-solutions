//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- >0)
        {
            String str = read.readLine();
            System.out.println(new Reverse().reverseWord(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        char[] a=str.toCharArray();
        reverse(a,0,str.length()-1);
        return new String(a);
    }
    
    private static void reverse(char[] a,int left,int right)
    {
        if (left>=right)
            return;
            
        char temp=a[left];
        a[left]=a[right];
        a[right]=temp;
        reverse(a,left+1,right-1);
    }
}