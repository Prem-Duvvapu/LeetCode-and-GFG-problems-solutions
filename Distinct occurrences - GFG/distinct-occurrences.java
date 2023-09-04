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
        int[] prev=new int[m+1];
        int[] curr=new int[m+1];
        
        prev[0]=curr[0]=1;
        
        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=m;j++)
            {
                if (s.charAt(i-1)==t.charAt(j-1))
                    curr[j]=(prev[j-1]+prev[j])%mod;
                else
                    curr[j]=prev[j];
            }
            
            for (int k=1;k<=m;k++)
                prev[k]=curr[k];
        }
        
        return prev[m];
    }
}