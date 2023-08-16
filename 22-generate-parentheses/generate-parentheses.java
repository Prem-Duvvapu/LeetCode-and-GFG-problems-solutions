class Solution {
    private void solve(int open,int close,int n,StringBuilder curr,List<String> res)
    {
        if (curr.length()==2*n)
        {
            res.add(curr.toString());
            return;
        }

        if (open<n)
        {
            curr.append('(');
            solve(open+1,close,n,curr,res);
            curr.deleteCharAt(curr.length()-1);
        }

        if (close<open)
        {
            curr.append(')');
            solve(open,close+1,n,curr,res);
            curr.deleteCharAt(curr.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        solve(0,0,n,new StringBuilder(),res);
        return res;
    }
}