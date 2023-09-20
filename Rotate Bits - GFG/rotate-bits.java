//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.rotate (n, d);
            System.out.println(res.get(0));
            System.out.println(res.get(1));
            
           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> rotate(int n, int d)
    {
        int[] a=new int[16];
        d=d%16;
        
        for (int i=15;i>=0;i--)
        {
            int bitValue=(n&(1<<i));
            if (bitValue>0)
                a[15-i]=1;
        }
        
        int[] temp=new int[16];
        //left shift
        int k=0;
        for (int i=d;i<16;i++)
            temp[k++]=a[i];
            
        for (int i=0;i<d;i++)
            temp[k++]=a[i];
            
        int ls=0;
        for (int i=0;i<16;i++)
        {
            int pos=15-i;
            if (temp[i]==1)
                ls+=(int)Math.pow(2,pos);
        }
        
        //right shift
        k=0;
        for (int i=16-d;i<16;i++)
            temp[k++]=a[i];
            
        for (int i=0;i<16-d;i++)
            temp[k++]=a[i];
            
        int rs=0;
        for (int i=0;i<16;i++)
        {
            int pos=15-i;
            if (temp[i]==1)
                rs+=(int)Math.pow(2,pos);
        }
        
        ArrayList<Integer> list=new ArrayList<>();
        list.add(ls);
        list.add(rs);
        return list;
    }
}