class Solution {
    public List<List<String>> partition(String s) {
        int n=s.length();
        List<List<String>> res=new ArrayList<>();
        solve(0,new ArrayList<>(),res,s,n);

        return res;
    }

    public void solve(int pos,List<String> currList,List<List<String>> res,String s,int n) {
        if (pos==n) {
            res.add(new ArrayList<>(currList));
            return;
        }

        for (int i=pos;i<n;i++) {
            if (isPalindrome(s,pos,i)) {
                currList.add(s.substring(pos,i+1));
                solve(i+1,currList,res,s,n);
                currList.remove(currList.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s,int left,int right) {
        while (left<right) {
            if (s.charAt(left)!=s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}