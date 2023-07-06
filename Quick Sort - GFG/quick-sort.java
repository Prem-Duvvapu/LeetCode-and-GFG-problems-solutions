//{ Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			new Solution().quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		}
} }
// } Driver Code Ends


class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if (low<high)
        {
            int pivotIndex=partition(arr,low,high);
            quickSort(arr,low,pivotIndex-1);
            quickSort(arr,pivotIndex+1,high);
        }
    }
    
    static int partition(int a[], int low, int high)
    {
        int pivot=high;
        int k=low-1;
        for (int i=low;i<high;i++)
        {
            if (a[i]<a[pivot])
            {
                k++;
                if (i!=k)
                {
                    int temp=a[i];
                    a[i]=a[k];
                    a[k]=temp;
                }
            }
        }
        k++;
        int temp=a[pivot];
        a[pivot]=a[k];
        a[k]=temp;
        
        return k;
    } 
}
