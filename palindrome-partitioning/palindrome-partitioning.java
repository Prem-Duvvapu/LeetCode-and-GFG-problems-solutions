class Solution {
    private boolean isPalindrome(String s,int left,int right)
    {
        while (left<=right)
            if (s.charAt(left++)!=s.charAt(right--))
                return false;

        return true;
    }
    
    private void helper(String s,int idxPos,List<String> curr,List<List<String>> res)
    {
        if (idxPos==s.length())
        {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i=idxPos;i<s.length();i++)
        {
            if (isPalindrome(s,idxPos,i))
            {
                curr.add(s.substring(idxPos,i+1));
                helper(s,i+1,curr,res);
                curr.remove(curr.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        helper(s,0,new ArrayList<>(),res);
        return res;
    }
}