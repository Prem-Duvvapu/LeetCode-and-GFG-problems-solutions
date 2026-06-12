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
            curr += '(';
            solve(openLeft-1,closeLeft,curr,res);
            curr = curr.substring(0,curr.length()-1);
        } else {
            if (openLeft > 0) {
                curr += '(';
                solve(openLeft-1,closeLeft,curr,res);
                curr = curr.substring(0,curr.length()-1);

                curr += ')';
                solve(openLeft,closeLeft-1,curr,res);
                curr = curr.substring(0,curr.length()-1);
            } else {
                curr += ')';
                solve(openLeft,closeLeft-1,curr,res);
                curr = curr.substring(0,curr.length()-1);
            }
        }
    }
}