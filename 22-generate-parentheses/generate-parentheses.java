class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        solve(n,n,"",res);
        return res;
    }

    private void solve(int openLeft,int closeLeft,String curr,List<String> res) {
        if (openLeft == 0 && closeLeft == 0) {
            res.add(new String(curr));
            return;
        }

        if (openLeft == closeLeft) {
            solve(openLeft-1,closeLeft,curr+'(',res);
        } else {
            if (openLeft > 0) {
                solve(openLeft-1,closeLeft,curr+'(',res);
            }

            solve(openLeft,closeLeft-1,curr+')',res);
        }
    }
}