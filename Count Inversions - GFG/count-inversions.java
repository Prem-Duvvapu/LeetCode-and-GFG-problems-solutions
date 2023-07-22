//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        // long[] a=new long[N];
        // for (long i=0;i<N;i++)
        //     a[i]=arr[i];
        return mergeSort(arr,0,(int)N-1);
    }
    
    static long mergeSort(long[] a,int left,int right)
    {
        long cnt=0;
        if (left<right)
        {
            int mid=left+(right-left)/2;
            cnt+=mergeSort(a,left,mid);
            cnt+=mergeSort(a,mid+1,right);
            cnt+=conquer(a,left,mid,right);
        }
        return cnt;
    }
    
    static long conquer(long[] a,int si,int mid,int ei)
    {
        long[] merged=new long[ei-si+1];
        int index1=si;
        int index2=mid+1;
        int x=0;
        long cnt=0;

        while (index1<=mid && index2<=ei)
        {
            if (a[index1]<=a[index2])
                merged[x++]=a[index1++];
            else
            {
                cnt+=(mid-index1+1);
                merged[x++]=a[index2++];  
            }
        }

        while (index1<=mid)
            merged[x++]=a[index1++];

        while (index2<=ei)
            merged[x++]=a[index2++];

        for (int i=0,j=si;i<merged.length;i++,j++)
            a[j]=merged[i];
            
        return cnt;
    }
}