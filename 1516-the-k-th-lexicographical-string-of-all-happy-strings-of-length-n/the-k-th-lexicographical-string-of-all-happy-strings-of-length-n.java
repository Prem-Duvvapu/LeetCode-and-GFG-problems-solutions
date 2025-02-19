class Solution {
    int pos=0;
    String res="";

    public String getHappyString(int n, int k) {
        int total=(1<<(n-1))*3;
        if (k>total)
            return "";

        String[] arr=new String[total];
        
        solve("",-1,n,arr,new int[]{k});
        return res;
    }

    private void solve(String curr,int last,int n,String[] arr,int[] k) {
        if (curr.length()==n) {
            k[0]--;
            if (k[0]==0)
                res=new String(curr);
            return;
        }

        for (int i=0;i<3;i++) {
            if (last!=i)
                solve(curr+(char)(i+'a'),i,n,arr,k);
        }
    }
}