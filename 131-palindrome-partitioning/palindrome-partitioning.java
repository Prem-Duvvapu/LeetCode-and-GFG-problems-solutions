class Solution {
    private boolean isPalindrome(String s,int left,int right)
    {
        while (left<right)
        {
            if (s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    private void solve(int pos,String s,List<String> curr,List<List<String>> res)
    {
        if (pos==s.length())
        {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i=pos;i<s.length();i++)
        {
            if (isPalindrome(s,pos,i))
            {
                curr.add(s.substring(pos,i+1));
                solve(i+1,s,curr,res);
                curr.remove(curr.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        solve(0,s,new ArrayList<>(),res);
        return res;
    }
}