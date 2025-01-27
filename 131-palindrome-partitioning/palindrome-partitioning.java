class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        solve(0,s,new ArrayList<>(),res);
        return res;
    }

    private void solve(int pos,String s,List<String> currList,List<List<String>> res) {
        if (pos==s.length()) {
            res.add(new ArrayList<>(currList));
            return;
        }

        for (int i=pos;i<s.length();i++) {
            if (isPalindrome(pos,i,s)) {
                currList.add(s.substring(pos,i+1));
                solve(i+1,s,currList,res);
                currList.remove(currList.size()-1);
            }
        }
    }

    private boolean isPalindrome(int i,int j,String s) {
        while (i<j) {
            if (s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}