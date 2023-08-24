//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String num1,String num2)
    {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
            
        boolean flag=(num1.charAt(0)=='-')^(num2.charAt(0)=='-');
        if (num1.charAt(0)=='-')
            num1=num1.substring(1);
            
        if (num2.charAt(0)=='-')
            num2=num2.substring(1);
        
        StringBuilder sb1=new StringBuilder(num1);
        StringBuilder sb2=new StringBuilder(num2);
        sb1.reverse();
        sb2.reverse();
        String s1=sb1.toString();
        String s2=sb2.toString();

        int l1=s1.length();
        int l2=s2.length();
        int[] res=new int[l1+l2];

        for (int i=0;i<l2;i++)
        {
            for (int j=0;j<l1;j++)
            {
                int a=Character.getNumericValue(s2.charAt(i));
                int b=Character.getNumericValue(s1.charAt(j));

                res[i+j]+=a*b;
                res[i+j+1]+=(res[i+j]/10);
                res[i+j]%=10;
            }
        }

        StringBuilder sb=new StringBuilder();
        for (int i=0;i<l1+l2;i++)
            sb.append(Integer.toString(res[i]));
        sb.reverse();
        String s=sb.toString();
        
        int begin=0;
        while (begin<s.length() && s.charAt(begin)=='0')
                begin++;

        if (flag)
            return "-"+s.substring(begin);
        
        return s.substring(begin);
    }
}