//Space Optimization(right shift by 1)

class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[] prev=new int[m+1];
        int[] curr=new int[m+1];

        for (int j=0;j<=m;j++)
            prev[j]=j;

        for (int i=1;i<=n;i++)
        {
            curr[0]=i;
            for (int j=1;j<=m;j++)
            {
                if (word1.charAt(i-1)==word2.charAt(j-1))
                    curr[j]=prev[j-1];
                else
                {
                    int insert=1+curr[j-1];
                    int delete=1+prev[j];
                    int replace=1+prev[j-1];
                    curr[j]=Math.min(insert,Math.min(delete,replace));
                }
            }

            for (int k=0;k<=m;k++)
                prev[k]=curr[k];
        }

        return prev[m];
    }
}