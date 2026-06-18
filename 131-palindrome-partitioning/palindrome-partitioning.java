class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        solve(0,new ArrayList<>(),s,res);
        return res;
    }

    private void solve(int pos,List<String> currList,String s,List<List<String>> res) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(currList));
            return;
        }

        for (int i=pos;i<s.length();i++) {
            if (isPalindrome(s,pos,i)) {
                currList.add(s.substring(pos,i+1));
                solve(i+1,currList,s,res);
                currList.remove(currList.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s,int left,int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}