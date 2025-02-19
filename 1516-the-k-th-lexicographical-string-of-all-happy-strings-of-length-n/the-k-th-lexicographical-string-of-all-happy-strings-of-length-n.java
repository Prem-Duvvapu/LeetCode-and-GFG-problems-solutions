class Solution {
    public String getHappyString(int n, int k) {
        int total=3 * (1<<(n-1));

        if (k>total)
            return "";

        String[] res=new String[1];
        int[] reqPos=new int[]{k};
        
        solve(new StringBuilder(),-1,n,res,reqPos);
        return res[0];
    }

    private boolean solve(StringBuilder curr,int last,int n,String[] res,int[] reqPos) {
        if (curr.length()==n) {
            reqPos[0]--;

            if (reqPos[0]==0) {
                res[0]=new String(curr);
                return true;
            }

            return false;
        }

        for (int i=0;i<3;i++) {
            if (last!=i) {
                curr.append((char)(i+'a'));
                if (solve(curr,i,n,res,reqPos))
                    return true;
                curr.deleteCharAt(curr.length()-1);
            }
        }

        return false;
    }
}