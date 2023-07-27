//{ Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}



// } Driver Code Ends


class Solution
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int N)
    {
        // Your code here
         int startIdx = (N / 2) - 1;
 
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, N, i);
        }
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int N, int i)
    {
        // Your code here
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
 
        if (l < N && arr[l] > arr[largest])
            largest = l;
 
        if (r < N && arr[r] > arr[largest])
            largest = r;
 
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            heapify(arr, N, largest);
        }
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int N)
    {
        //code here
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);
 
        for (int i = N - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            heapify(arr, i, 0);
        }
    }
 }
 
 
