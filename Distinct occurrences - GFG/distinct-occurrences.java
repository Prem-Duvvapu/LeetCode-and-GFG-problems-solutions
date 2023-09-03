//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    int mod=(int)(1e9)+7;
    
    int  subsequenceCount(String s, String t)
    {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n+1][m+1];
        
        for (int[] arr: dp)
            Arrays.fill(arr,-1);

        return solve(n,m,s,t,dp);
    }
    
    private int solve(int i,int j,String s,String t,int[][] dp)
    {
        if (j==0)
            return 1;

        if (i==0)
            return 0;

        if (dp[i][j]!=-1)
            return dp[i][j];

        if (s.charAt(i-1)==t.charAt(j-1))
            return dp[i][j]=(solve(i-1,j-1,s,t,dp)+solve(i-1,j,s,t,dp))%mod;

        return dp[i][j]=(solve(i-1,j,s,t,dp))%mod;
    }
}