//Tabulation
class Solution {
    public int minOperations(String s1, String s2, int x) {
        int n=s1.length();
        List<Integer> list=new ArrayList<>();

        for (int i=0;i<n;i++)
            if (s1.charAt(i)!=s2.charAt(i))
                list.add(i);

        if (list.size()%2==1)
            return -1;

        if (list.size()==0)
            return 0;

        int m=list.size();
        int[][] dp=new int[m+1][m+1];

        for (int left=m-1;left>=0;left--)
        {
            for (int right=left+1;right<m;right++)
            {
                int val1=Math.min(x,list.get(left+1)-list.get(left));
                if (left+2<m)
                    val1+=dp[left+2][right];
                int val2=Math.min(x,list.get(right)-list.get(right-1));
                if (right-2>=0)
                    val2+=dp[left][right-2];
                int val3=Math.min(x,list.get(right)-list.get(left));
                if (left+1<m && right-1>=0)
                    val3+=dp[left+1][right-1];
                dp[left][right]=Math.min(val1,Math.min(val2,val3));
            }
        }

        return dp[0][m-1];
    }
}