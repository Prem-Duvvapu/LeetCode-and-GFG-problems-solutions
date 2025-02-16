class Solution {

    public int[] constructDistancedSequence(int n) {
        int[] res=new int[2*n-1];
        boolean[] visited=new boolean[n+1];
        solve(0,n,visited,res);
        return res;
    }

    public boolean solve(int pos,int n,boolean[] visited,int[] res) {
        while (pos<2*n-1 && res[pos]!=0)
            pos++;
            
        if (pos>=2*n-1)
            return true;

        for (int num=n;num>=1;num--) {
            if (visited[num])
                continue;

            if (num==1) {
                if (res[pos]==0) {
                    visited[num]=true;
                    res[pos]=num;
                    if (solve(pos+1,n,visited,res))
                        return true;
                    visited[num]=false;
                    res[pos]=0;
                }
            } else {
                int j=pos+num;
                if (j<2*n-1 && res[j]==0) {
                    visited[num]=true;
                    res[pos]=num;
                    res[j]=num;
                    if (solve(pos+1,n,visited,res))
                        return true;
                    visited[num]=false;
                    res[pos]=0;
                    res[j]=0;
                }
            }

            System.out.println(Arrays.toString(res));
        }

        return false;
    }
}