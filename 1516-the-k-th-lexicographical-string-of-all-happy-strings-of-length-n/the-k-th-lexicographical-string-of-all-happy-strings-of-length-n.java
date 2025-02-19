class Solution {
    int pos=0;
    public String getHappyString(int n, int k) {
        int total=(1<<(n-1))*3;
        if (k>total)
            return "";

        String[] arr=new String[total];
        
        solve("",-1,n,arr,total);
        return arr[k-1];
    }

    private void solve(String curr,int last,int n,String[] arr,int total) {
        if (curr.length()==n) {
            arr[pos++]=new String(curr);
            return;
        }

        for (int i=0;i<3;i++) {
            if (last!=i)
                solve(curr+(char)(i+'a'),i,n,arr,total);
        }
    }
}