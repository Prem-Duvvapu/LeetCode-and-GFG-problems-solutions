//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int pos)
    {
	// Your code here
	    int rowStart=0;
	    int rowEnd=n-1;
	    int colStart=0;
	    int colEnd=m-1;
	    
	    int[] spiral=new int[n*m];
	    int k=0;
	    
	    while (rowStart<=rowEnd && colStart<=colEnd)
	    {
	        for (int i=colStart;i<=colEnd;i++)
	            spiral[k++]=A[rowStart][i];
	        rowStart++;
	        
	        for (int i=rowStart;i<=rowEnd;i++)
	            spiral[k++]=A[i][colEnd];
	        colEnd--;
	        
	        if (rowStart<=rowEnd)
	        {
    	        for (int i=colEnd;i>=colStart;i--)
    	            spiral[k++]=A[rowEnd][i];
    	        rowEnd--;
	        }
	        
	        if (colStart<=colEnd)
	        {
    	        for (int i=rowEnd;i>=rowStart;i--)
    	            spiral[k++]=A[i][colStart];
    	        colStart++;
	        }
	    }
	    
	    return spiral[pos-1];
    }
}