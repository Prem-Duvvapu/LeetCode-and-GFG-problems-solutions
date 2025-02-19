class Solution {
    public String getHappyString(int n, int k) {
        int total=(1<<(n-1))*3;
        if (k>total)
            return "";

        String[] res=new String[1];
        int[] reqPos=new int[]{k};
        
        solve("",-1,n,res,reqPos);
        return res[0];
    }

    private void solve(String curr,int last,int n,String[] res,int[] reqPos) {
        if (curr.length()==n) {
            reqPos[0]--;

            if (reqPos[0]==0)
                res[0]=new String(curr);

            return;
        }

        for (int i=0;i<3;i++)
            if (last!=i)
                solve(curr+(char)(i+'a'),i,n,res,reqPos);
    }
}